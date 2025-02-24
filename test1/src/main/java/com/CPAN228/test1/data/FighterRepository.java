package com.CPAN228.test1.data;

import com.CPAN228.test1.model.Anime;
import com.CPAN228.test1.model.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FighterRepository extends JpaRepository<Fighter, Long> {

    // Finds fighters based on the anime they come from.
    List<Fighter> findByAnimeFrom(Anime animeFrom);

    // Finds fighters whose names start with the given prefix and were created between the specified dates.
    List<Fighter> findByNameStartingWithAndCreatedAtBetween(String namePrefix, LocalDateTime fromDate, LocalDateTime toDate);

    // find fighters by names in ascending order
    List<Fighter> findAllByOrderByNameAsc();

}
