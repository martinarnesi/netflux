package com.arnesi.netflux.services;

import com.arnesi.netflux.domain.Movie;
import com.arnesi.netflux.domain.MovieEvent;
import com.arnesi.netflux.repositories.MovieRepositories;
import java.time.Duration;
import java.util.Date;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class MovieServicesImpl implements MovieServices {

  @Autowired
  private MovieRepositories movieRepositories;

  @Override
  public Mono<Movie> getMovieById(String id) {
    return movieRepositories.findById(id);
  }

  @Override
  public Flux<Movie> getAllMovies() {
    return movieRepositories.findAll();
  }

  @Override
  public Flux<MovieEvent> streamMovieEvents(String id) {
    return Flux.<MovieEvent>generate(movieEventSynchronousSink -> {
      movieEventSynchronousSink.next(new MovieEvent(id, new Date()));
    }).delayElements(Duration.ofSeconds(1));
  }
}