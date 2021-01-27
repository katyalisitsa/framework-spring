package com.jackson.repository;


import com.jackson.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //
//Write a derived query to get cinema with a specific name

    List<Cinema> findByName(String name);

//Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name

    List<Cinema> findFirst3BySponsoredNameContainingOrderBySponsoredName(String name);

//Write a derived query to list all cinemas in a specific country

    List<Cinema> findByLocationCountry(String country);

//Write a derived query to list all cinemas with a specific name or sponsored name

    List<Cinema> findByNameOrSponsoredName(String name, String sponsoredName);

// ------------------- JPQL QUERIES ------------------- //

//Write a JPQL query to read the cinema name with a specific id

    @Query("select c from cinema c where c.id = ?1")
    Cinema findCinemaById(int id);

// ------------------- Native QUERIES ------------------- //

//Write a native query to read all cinemas by location country

    @Query(value = "select * from cinema c join location l on c.id = l.id where l.country = ?1", nativeQuery = true)
    List<Cinema> findCinamesByLocation(String country);

//Write a native query to read all cinemas by name or sponsored name contains a specific pattern

    @Query(value = "select * from cinema where name ilike concat('%',?1,'%') or sponsored_name ilike concat('%',?1,'%')", nativeQuery = true)
    List<Cinema> findCinemasByPattern(String pattern);

//Write a native query to sort all cinemas by name

    @Query(value = "Select * from cinema order by name", nativeQuery = true)
    List<Cinema> sortAllCinemas();

//Write a native query to distinct all cinemas by sponsored name

    @Query(value = "Select distinct sponsored_name from cinema", nativeQuery = true)
    List<Cinema> distinctCinemasSponsoredName();
}

