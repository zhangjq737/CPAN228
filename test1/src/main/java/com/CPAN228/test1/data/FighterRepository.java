package com.CPAN228.test1.data;

import com.CPAN228.test1.model.Fighter;

import java.util.Optional;

public interface FighterRepository {
    Iterable<Fighter> findAll();
    Optional<Fighter> findById(long id);
    Fighter save(Fighter fighter);
}
