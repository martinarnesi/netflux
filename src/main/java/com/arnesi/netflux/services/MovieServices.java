package com.arnesi.netflux.services;

import com.arnesi.netflux.domain.Movie;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovieServices {

  Mono<Movie> getMovieById(String id);

  Flux<Movie> getAllMovies();
}