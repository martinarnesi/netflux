package com.arnesi.netflux.repositories;

import com.arnesi.netflux.domain.Movie;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MovieRepositories extends ReactiveMongoRepository<Movie, String> {

}