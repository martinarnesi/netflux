package com.arnesi.netflux.domain;

import lombok.Builder;
import lombok.Data;

import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "Movies")
public class Movie {
  private String id;
  private String title;
}
