package com.springbootlearning.learningspringboot3;

import java.util.Map;

record SearchSnippet(String publishedAt, String channelId, String title, String description,
  Map<String, SearchThumbnail> thumbnails, String channelTitle) {

  String shortDescription() {
    if (this.description.length() <= 100) {
      return this.description;
    }
    return this.description.substring(0, 100);
  }

  SearchThumbnail thumbnail() {
    return this.thumbnails.entrySet().stream() //
      .filter(entry -> entry.getKey().equals("default")) //
      .findFirst() //
      .map(Map.Entry::getValue) //
      .orElse(null);
  }
}
