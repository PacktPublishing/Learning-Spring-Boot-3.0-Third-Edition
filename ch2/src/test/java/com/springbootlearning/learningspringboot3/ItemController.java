package com.springbootlearning.learningspringboot3;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ItemController {

  @PostMapping("/items")
  public String newItem(@RequestBody Item item) {
    // process item
    return "done";
  }

  @PostMapping("/new-item")
  public String newVideo(@ModelAttribute Item newItem) {
    // process the new item
    return "redirect:/";
  }

  record Item(String id, String description, Long price) {
  }

}
