package com.jackson.controller;

import com.jackson.repository.GenreRepository;
import com.jackson.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;


@RestController
public class WebFluxController {

    private WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8080")
            .build();

    private MovieRepository movieRepository;
    private GenreRepository genreRepository;

    public WebFluxController(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    @GetMapping("flux-movie-cinemas")
    public 
}
