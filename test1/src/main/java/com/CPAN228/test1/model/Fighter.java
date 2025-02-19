package com.CPAN228.test1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fighter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "createdat")
    @CreationTimestamp
    private LocalDateTime createdAt;
    private String name;
    @Column(name = "damageperhit")
    private int damagePerHit;
    private int health;
    private double resistance;
    @Column(name = "animefrom")
    private Anime animeFrom;
}
