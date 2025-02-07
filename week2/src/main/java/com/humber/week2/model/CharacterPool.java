package com.humber.week2.model;

import java.util.List;

import lombok.Data;

@Data
public class CharacterPool {
    private List<Fighter> fighters;
    public void addHero(Fighter fighter) {
        fighters.add(fighter);
    }
}
