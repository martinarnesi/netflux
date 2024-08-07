package com.arnesi.netflux.controllers;

import com.arnesi.netflux.domain.Movie;
import com.arnesi.netflux.domain.MovieEvent;
import com.arnesi.netflux.services.MovieServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
@Log4j2
public class MovieController {

  @Autowired
  private MovieServices movieServices;

  @GetMapping("/{id}")
  Mono<Movie> getMovieById(@PathVariable String id) {
    log.info("Get movie by id: " + id);
    return movieServices.getMovieById(id);
  }

  @GetMapping
  Flux<Movie>getAllMovies() {
    log.info("Get all movies");
    return movieServices.getAllMovies();
  }

  @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  Flux<MovieEvent> streamMovieEvents(@PathVariable String id) {
    return movieServices.streamMovieEvents(id);
  }
}