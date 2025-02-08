package com.CPAN228.test1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class Fighter {
    private long id;
    private Date createdAt;
    private String name;
    private int damagePerHit;
    private int health;
    private double resistance;
    private Anime animeFrom;

    public Fighter(long id, Date createdAt, String name, int damagePerHit, int health, double resistance, Anime animeFrom) {
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
        this.damagePerHit = damagePerHit;
        this.health = health;
        this.resistance = resistance;
        this.animeFrom = animeFrom;
    }
}
