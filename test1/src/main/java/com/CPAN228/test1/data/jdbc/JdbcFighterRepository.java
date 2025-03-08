package com.CPAN228.test1.data.jdbc;

import com.CPAN228.test1.data.FighterRepository;
import com.CPAN228.test1.model.Anime;
import com.CPAN228.test1.model.Fighter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.sql.Timestamp;
import java.time.Instant;

@Repository
public abstract class JdbcFighterRepository implements FighterRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcFighterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Fighter> findByAnimeFrom(Anime animeFrom) {
        // Your custom implementation here
        return List.of();
    }

    @Override
    public List<Fighter> findByNameStartingWithAndCreatedAtBetween(String namePrefix, LocalDateTime fromDate, LocalDateTime toDate) {
        // Your custom implementation here
        return List.of();
    }
}
