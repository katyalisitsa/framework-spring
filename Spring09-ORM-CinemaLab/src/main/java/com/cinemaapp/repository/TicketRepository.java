package com.cinemaapp.repository;

import com.cinemaapp.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

    // ------------------- DERIVED QUERIES ------------------- //
//Write a derived query to count how many tickets a user bought

    int countByUserId(Long userId);

//Write a derived query to list all tickets by specific email

    List<Ticket> findByUserEmail(String email);

//Write a derived query to count how many tickets are sold for a specific movie

    int countByMovieCinemaMovieName(String name);

//Write a derived query to list all tickets between a range of dates

    List<Ticket> findAllByDateTimeBetween(LocalDateTime date1, LocalDate date2);


// ------------------- JPQL QUERIES ------------------- //
//Write a JPQL query that returns all tickets are bought from a specific user

    @Query("Select t from Ticekt t where t.user.id = ?1")
    List<Ticket> findTicketsFromUser(Long userId);

//Write a JPQL query that returns all tickets between a range of dates

    @Query("Select t from Ticekt t where t.dateTime between ?1 and ?2")
    List<Ticket> findTicketsInDatesRange(LocalDate start, LocalDate end);

// ------------------- Native QUERIES ------------------- //
//Write a native query to count the number of tickets a user bought

    @Query(value = "Select count from ticket where user_account_id = ?1", nativeQuery = true)
    int countTicektsUserBought(Long userId);

//Write a native query to count the number of tickets a user bought in a specific range of dates

    @Query(value = "Select count (*) from ticket were user_account_id = ?1 amd date_time between ?2 and ?3", nativeQuery = true)
    int countTicketsUserBoughtInTimeRange(Long userId, LocalDate date1, LocalDate date2);

//Write a native query to distinct all tickets by movie name

    @Query(value = "Select distinct(m.name) from ticket join movie_cinema mc on mc.id=ticket.movie_cinema_id join movie m on " +
            "mc.movie_id = m.id", nativeQuery = true)
    List<Ticket> distinctTiketsMovieNames();

//Write a native query to find all tickets by user email

    @Query(value = "Select * from ticekt t join user_account ua on t.user_account_id = ua.id where ua.email = ?1", nativeQuery = true)
    List<Ticket> findTicektsByUserEmail(String userEmail);

//Write a native query that returns all tickets

    @Query(value = "Select * from ticket", nativeQuery = true)
    List<Ticket> returnAllTickets();

//Write a native query to list all tickets where a specific value should be containable in the username or name or movie name

    @Query(value = "Select * from ticket t " +
            "join user_account ua on t.user_account_id = ua.id" +
            "join account_details ad on ad.id = ua.account_details_id" +
            "join movie_cinema mc on t.movie_cinema_id = mc.identity" +
            "join movie m on mc.movie_id = m.id" +
            "where ua.username ILIKE concat('%',?1,'%')" +
            "or ad.name ILIKE concat('%',?1,'%')" +
            "or m.name ILIKE concat('%',?1,'%')", nativeQuery = true)
    List<Ticket> retrieveTicketsWithPatternInUsernameOrMoviename(String pattern);
}
