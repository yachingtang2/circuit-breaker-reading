package com.tang.circuitbreakerreading;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
class BookService {

  private RestTemplate restTemplate;

  public BookService(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  public String reliable() {
    return "Cloud Native Java (O'Reilly)";
  }

  @HystrixCommand(fallbackMethod = "reliable")
  public String readingList() {
    URI uri = URI.create("http://localhost:8090/recommended");

    return restTemplate.getForEntity(uri, String.class).getBody();
  }
}
