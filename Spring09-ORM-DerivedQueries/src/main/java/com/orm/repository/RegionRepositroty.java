package com.orm.repository;

import com.orm.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegionRepositroty extends JpaRepository<Region,Integer> {

    //Display all the regions in Canada (or any other)
    List<Region> findAllByCountry(String country);

    //Display distinct regions in Canada (or any other)
    List<Region> findDistinctByCountry(String country);

    //Display all regions with country name includes 'United'
    List<Region> findByCountryContains(String pattern);

    //Display all regions with country name includes 'United' in order
    List<Region> findByCountryContainingOrderByCountryDesc(String country);

    //Display top 2 regions in Canada
    List<Region> findTopBy2ByCountry(String country);
}
