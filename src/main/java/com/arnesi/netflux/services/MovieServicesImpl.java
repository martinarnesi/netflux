package com.arnesi.netflux.services;

import com.arnesi.netflux.domain.Movie;
import com.arnesi.netflux.repositories.MovieRepositories;
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
}