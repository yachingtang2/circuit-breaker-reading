package com.tang.circuitbreakerreading;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

  @InjectMocks
  private BookService service;

  @Mock
  private RestTemplate restTemplate;

  private URI uri;

  @BeforeEach
  void setUp() {
    uri = URI.create("http://localhost:8090/recommended");
  }

  @Test
  void reliable() {
    assertThat(service.reliable()).isEqualTo("Cloud Native Java (O'Reilly)");
  }

  @Test
  void readingListOk() {
    ResponseEntity<String> responseEntity = new ResponseEntity<>("A list", HttpStatus.OK);

    given(restTemplate.getForEntity(uri, String.class)).willReturn(responseEntity);

    assertThat(service.readingList()).isEqualTo("A list");
  }
}
