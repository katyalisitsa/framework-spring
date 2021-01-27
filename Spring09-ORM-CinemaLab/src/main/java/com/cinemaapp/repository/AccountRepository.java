package com.cinemaapp.repository;

import com.cinemaapp.entity.Account;
import com.cinemaapp.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //
//Write a derived query to list all accounts with a specific country or state

    List<Account> findByCountryOrState(String country, String state);
//Write a derived query to list all accounts with age lower than or equal to a specific value

    List<Accoont> findByAgeLessThanEqual(int age);
//Write a derived query to list all accounts with a specific role

    List<Account> findByRole(UserRole role);
    //Write a derived query to list all accounts between a range of ages

    List<Account> findByAgeBetween(int age1, int age2);
//Write a derived query to list all accounts where the beginning of the address contains the keyword

    List<Account> findByAddressStartsWith(String address);
//Write a derived query to sort the list of accounts with age

    List<Account> findByOrderByAgeDesc();

// ------------------- JPQL QUERIES ------------------- //
//Write a JPQL query that returns all accounts

    @Query("Select a from account a")
    List<Account> findAllAccounts();

//Write a JPQL query to list all admin accounts

    @Query("Select a from account a where a.role = 'ADMIN'")
    List<Account> findAdminAccounts();

//Write a JPQL query to sort all accounts with age

    @Query("Select a from account a sort by a.age")
    List<Account> sortAccountsByAge();

// ------------------- Native QUERIES ------------------- //

//Write a native query to read all accounts with an age lower than a specific value

    @Query(value = "Select * from account_details where age < ?1", nativeQuery = true)
    List<Account> findAccountsLowerAge(int age)

//Write a native query to read all accounts that a specific value can be containable in the name, address,
// country, state city

    @Query(value = "Select * from account_details where name ilike concat('%',?1,'%') or address ilike concat('%',?1,'%') or country ilike concat('%',?1,'%') or state ilike concat('%',?1,'%') or city ilike concat('%',?1,'%')", nativeQuery = true)
    List<Account> findByPattern(String pattern);

//Write a native query to read all accounts with an age lower than a specific value

    @Query(value = "Select * from account_details where age < ?1", nativeQuery = true)
    List<Account> findAccountsLowerThen(int age);
}
