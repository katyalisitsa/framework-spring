package com.jackson.repository;


import com.jackson.entity.Movie;
import com.jackson.enums.MovieState;
import com.jackson.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {


// ------------------- DERIVED QUERIES ------------------- //
//Write a derived query to read a movie with a name

    List<Movie> findByName(String name);
//Write a derived query to list all movies between a range of prices

    List<Movie> findByPriceBetween(BigDecimal price1, BigDecimal price2);

//Write a derived query to list all movies where duration exists in the specific list of duration

    List<Movie> findByDurationIn(List<Integer> durations);

//Write a derived query to list all movies with higher than a specific release date

    List<Movie> findByReleaseDateAfter(LocalDateTime releaseDate);

//Write a derived query to list all movies with a specific state and type

    List<Movie> findByStateAndType(MovieState state, MovieType type);

// ------------------- JPQL QUERIES ------------------- //
//Write a JPQL query to list all movies between a range of prices

    @Query("Select m from Movie m where m.price between ?1 and ?2")
    List<Movie> findMoviesInPriceRange(BigDecimal price1, BigDecimal price2);

//Write a JPQL query that returns all movie names

    @Query("Select distinct m.name from Movie m")
    List<String> findAllMovieNames();

// ------------------- Native QUERIES ------------------- //
//Write a native query that returns a movie by name

    @Query(value = "Select * from movie where name = ?1", nativeQuery = true)
    Movie returnMovieByName(String name);

//Write a native query that return the list of movies in a specific range of prices

    @Query(value = "Select * from movie where price between ?1 and ?2)", nativeQuery = true)
    List<Movie> listOfMoviesInPriceRange(BigDecimal price1, BigDecimal price2);

//Write a native query to return all movies where duration exists in the range of duration

    @Query(value = "Select * from movie where duration in ?1", nativeQuery = true)
    List<Movie> retriveMovieByDuration(List<Integer> durations);

//Write a native query to list the top 5 most expensive movies

    @Query(value = "Select * from movie order by price desc limit 5", nativeQuery = true)
    List<Movie> topMostExpensiveMovie();
}
