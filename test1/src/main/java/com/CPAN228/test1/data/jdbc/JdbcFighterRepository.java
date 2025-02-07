package com.CPAN228.test1.data.jdbc;

import com.CPAN228.test1.data.FighterRepository;
import com.CPAN228.test1.model.Fighter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class JdbcFighterRepository implements FighterRepository {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public JdbcFighterRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Fighter> findAll(){return null;}

    @Override
    public Optional<Fighter> findById(long id) {
        return Optional.empty();
    }

    @Override
    public Fighter save(Fighter fighter){
        jdbcTemplate.update(
                "inster into fighter () values ()"
        );
        return fighter;
    }
}
