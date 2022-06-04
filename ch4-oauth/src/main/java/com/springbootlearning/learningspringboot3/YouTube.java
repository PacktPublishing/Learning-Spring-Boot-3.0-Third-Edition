package com.springbootlearning.learningspringboot3;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

interface YouTube {

  @GetExchange("/search?part=snippet&type=video")
  SearchListResponse channelVideos( //
    @RequestParam String channelId, //
    @RequestParam int maxResults, //
    @RequestParam Sort order);

  enum Sort {
    DATE("date"), //
    VIEW_COUNT("viewCount"), //
    TITLE("title"), //
    RATING("rating");

    private final String type;

    Sort(String type) {
      this.type = type;
    }
  }
}
