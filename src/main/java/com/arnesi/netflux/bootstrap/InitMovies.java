package com.arnesi.netflux.bootstrap;

import com.arnesi.netflux.domain.Movie;
import com.arnesi.netflux.repositories.MovieRepositories;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.w3c.dom.ls.LSOutput;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class InitMovies implements CommandLineRunner {
  private final MovieRepositories movieRepositories;

  @Override
  public void run(String... args) {

    Flux<String> movies = Flux.just("Back to the Future",
        "E.T. the Extra-Terrestrial",
        "The Empire Strikes Back",
        "The Terminator",
        "Indiana Jones and the Last Crusade",
        "Blade Runner",
        "The Shining",
        "Ghostbusters",
        "Die Hard", "Ferris Bueller's Day Off");

    movies.map(title -> Movie.builder().title(title).build())
        .flatMap(movieRepositories::save)
        .subscribe(null,
            null,
            () -> movieRepositories.findAll().subscribe(System.out::println));
  }
}
