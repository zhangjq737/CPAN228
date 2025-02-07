package com.CPAN228.test1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Fighter {
    private final String name;
    private final int damagePerHit;
    private final int health;
    private final double resistance;
    private final Anime animeFrom;
}
