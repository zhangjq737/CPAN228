package com.CPAN228.test1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fighter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime created_at;
    private String name;
    private int damage_per_hit;
    private int health;
    private double resistance;
    private Anime anime_from;

    public Fighter(long id, LocalDateTime createdAt, String name, int damagePerHit, int health, double resistance, Anime animeFrom) {
        this.id = id;
        this.created_at = createdAt;
        this.name = name;
        this.damage_per_hit = damagePerHit;
        this.health = health;
        this.resistance = resistance;
        this.anime_from = animeFrom;
    }
}
