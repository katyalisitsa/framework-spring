package com.jackson.controller;

import com.jackson.entity.MovieCinema;
import com.jackson.repository.GenreRepository;
import com.jackson.repository.MovieCinemaRepository;
import com.jackson.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
public class WebFluxController {

    private WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8080")
            .build();

    private MovieRepository movieRepository;
    private GenreRepository genreRepository;
    private MovieCinemaRepository movieCinemaRepository;

    public WebFluxController(MovieRepository movieRepository, GenreRepository genreRepository, MovieCinemaRepository movieCinemaRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.movieCinemaRepository = movieCinemaRepository;
    }

    @GetMapping("/flux-movie-cinemas")
    public Flux<MovieCinema> readAllCinemaFlux() {
        return Flux.fromIterable(movieCinemaRepository.findAll());
    }

    @GetMapping("/mono-movie-cinema/{id}")
    public Mono<MovieCinema> readById(@PathVariable("id") Long id) {
        return Mono.just(movieCinemaRepository.findById(id).get());
    }

    @GetMapping("/mono-movie-cinema")
    public Mono<MovieCinema> readByIdRequestParam(@RequestParam("id") Long id) {
        return Mono.just(movieCinemaRepository.findById(id).get());
    }
}
