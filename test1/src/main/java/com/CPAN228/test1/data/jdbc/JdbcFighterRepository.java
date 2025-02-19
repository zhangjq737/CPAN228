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

    // 1. Implement findAll method to return all fighters
//    @Override
//    public Iterable<Fighter> findAll() {
//        String sql = "SELECT id, name, damagePerHit, health, resistance, animeFrom, createdAt FROM fighter";
//        List<Fighter> fighters = jdbcTemplate.query(sql, new FighterRowMapper());
//        return fighters;
//    }
//
//    // 2. Implement findById method to return fighter by their id
//    @Override
//    public Optional<Fighter> findById(long id) {
//        String sql = "SELECT id, name, damagePerHit, health, resistance, animeFrom, createdAt FROM fighter WHERE id = ?";
//        try {
//            Fighter fighter = jdbcTemplate.queryForObject(sql, new FighterRowMapper(), id);
//            return Optional.ofNullable(fighter);
//        } catch (Exception e) {
//            // Could be EmptyResultDataAccessException if no fighter found
//            return Optional.empty();
//        }
//    }
//
//    // 3. Implement save method to store a fighter in the database
//    @Override
//    public Fighter save(Fighter fighter) {
//        String sql = "INSERT INTO Fighter (name, damagePerHit, health, resistance, createdAt, animeFrom) VALUES (?, ?, ?, ?, ?, ?)";
//
//        int rowsAffected = jdbcTemplate.update(sql,
//                fighter.getName(),
//                fighter.getDamagePerHit(),
//                fighter.getHealth(),
//                fighter.getResistance(),
//                Timestamp.from(Instant.now()),
//                fighter.getAnimeFrom().toString());
//
//        System.out.println("Rows inserted: " + rowsAffected);
//        return fighter;
//    }
//
//    // Inner class implementing RowMapper to map a ResultSet row to a Fighter object
//    private static class FighterRowMapper implements RowMapper<Fighter> {
//        @Override
//        public Fighter mapRow(ResultSet rs, int rowNum) throws SQLException {
//            Fighter fighter = new Fighter();
//            fighter.setId(rs.getLong("id"));
//            fighter.setName(rs.getString("name"));
//            fighter.setDamagePerHit(rs.getInt("damagePerHit"));
//            fighter.setHealth(rs.getInt("health"));
//            fighter.setResistance(rs.getInt("resistance"));
//            fighter.setCreatedAt(rs.getTimestamp("createdAt"));
//            fighter.setAnimeFrom(Anime.valueOf(rs.getString("animeFrom")));
//            return fighter;
//        }
//    }
}
