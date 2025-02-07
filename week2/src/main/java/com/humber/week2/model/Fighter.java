package com.humber.week2.model;

import javax.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Fighter {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Damage per hit is required")
    @Max(value = 99, message = "Damage must be less than 100")
    private Integer damagePerHit;

    @NotNull(message = "Health is required")
    @Min(value = 1001, message = "Health must be more than 1000")
    private Integer health;

    @NotNull(message = "Resistance is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Resistance must be at least 0")
    @DecimalMax(value = "10.0", inclusive = true, message = "Resistance must be at most 10")
    private Double resistance;

    @NotNull(message = "Anime is required")
    private Anime animeFrom;
}
