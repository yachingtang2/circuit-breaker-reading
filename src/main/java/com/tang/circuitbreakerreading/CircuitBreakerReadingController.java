package com.tang.circuitbreakerreading;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class CircuitBreakerReadingController {

  private final BookService bookService;

  public CircuitBreakerReadingController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping("/to-read")
  public String toRead() {
    return bookService.readingList();
  }
}
