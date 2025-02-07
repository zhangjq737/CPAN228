package com.CPAN228.test1.data.jdbc;

import com.CPAN228.test1.data.FighterRepository;
import com.CPAN228.test1.model.Fighter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class JdbcFighterRepository implements FighterRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcFighterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // 1. Implement findAll method to return all fighters
    @Override
    public Iterable<Fighter> findAll() {
        String sql = "SELECT id, name, damage_per_hit, health, resistance FROM fighter";
        List<Fighter> fighters = jdbcTemplate.query(sql, new FighterRowMapper());
        return fighters;
    }

    // 2. Implement findById method to return fighter by their id
    @Override
    public Optional<Fighter> findById(long id) {
        String sql = "SELECT id, name, damage_per_hit, health, resistance FROM fighter WHERE id = ?";
        try {
            Fighter fighter = jdbcTemplate.queryForObject(sql, new Object[]{id}, new FighterRowMapper());
            return Optional.ofNullable(fighter);
        } catch (Exception e) {
            // Could be EmptyResultDataAccessException if no fighter found
            return Optional.empty();
        }
    }

    // 3. Implement save method to store a fighter in the database
    @Override
    public Fighter save(Fighter fighter) {
        String sql = "INSERT INTO fighter (name, damage_per_hit, health, resistance) VALUES (?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, new String[] {"id"});
            ps.setString(1, fighter.getName());
            ps.setInt(2, fighter.getDamagePerHit());
            ps.setInt(3, fighter.getHealth());
            ps.setDouble(4, fighter.getResistance());
            return ps;
        }, keyHolder);

        // Set the generated ID in the fighter object, if available
        Number key = keyHolder.getKey();
        if (key != null) {
            fighter.setId(key.longValue());
        }
        return fighter;
    }

    // Inner class implementing RowMapper to map a ResultSet row to a Fighter object
    private static class FighterRowMapper implements RowMapper<Fighter> {
        @Override
        public Fighter mapRow(ResultSet rs, int rowNum) throws SQLException {
            Fighter fighter = new Fighter();
            fighter.setId(rs.getLong("id"));
            fighter.setName(rs.getString("name"));
            fighter.setDamagePerHit(rs.getInt("damage_per_hit"));
            fighter.setHealth(rs.getInt("health"));
            fighter.setResistance(rs.getInt("resistance"));
            return fighter;
        }
    }
}
