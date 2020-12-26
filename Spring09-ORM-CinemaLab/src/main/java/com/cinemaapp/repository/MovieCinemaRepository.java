package com.cinemaapp.repository;

import com.cinemaapp.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema,Long> {

    // ------------------- DERIVED QUERIES ------------------- //
//Write a derived query to read movie cinema with id

    List<MovieCinema> findMovieCinemasById(int id);

//Write a derived query to count all movie cinemas with a specific cinema id

    int countAllByCinemaId(Long cinemaId);

//Write a derived query to count all movie cinemas with a specific movie id

    Integer countAllByMovieId(Integer movieId);

//Write a derived query to list all movie cinemas with higher than a specific date

    List<MovieCinema> findByDateTimeAfter(LocalDateTime date);

//Write a derived query to find the top 3 expensive movies

    List<MovieCinema> findFirst3ByOrderByPMoviePrice();

//Write a derived query to list all movie cinemas that contain a specific movie name

    List<MovieCinema> findMovieCinemasByMovieNameContaining(String name);

//Write a derived query to list all movie cinemas in a specific location

    List<MovieCinema> findMovieCinemasByMCinemaLocationName(String location);

// ------------------- JPQL QUERIES ------------------- //
//Write a JPQL query to list all movie cinemas with higher than a specific date

    @Query("Select mc from MovieCinema mc where mc.dateTime > ?1")
    List<MovieCinema> fetchAllWithHigherSpecificDate(LocalDateTime dateTime);

// ------------------- Native QUERIES ------------------- //
//Write a native query to count all movie cinemas by cinema id

    @Query(value = "Select count * from movie_cinema where cinema_id = ?1",nativeQuery = true)
    int countMovieCinemasByCinemaId(int id);

//Write a native query that returns all movie cinemas by location name

    @Query(value = "Select * from movie_cinema mc join cinema c on c.id = mc.cinema_id  join location l on c.location_id = l.id where l.name = ?1", nativeQuery = true)
    List<MovieCinema> retrieveMovieCinemasByLocationName(String location);
}
