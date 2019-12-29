package com.tang.circuitbreakerreading;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CircuitBreakerReadingApplicationTests {

  private CircuitBreakerReadingApplication application;

  @BeforeEach
  void setUp() {
  	application = new CircuitBreakerReadingApplication();
  }

  @Test
  void contextLoads() {
  	assertThat(application).isNotNull();
  }

}
