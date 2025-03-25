package com.CPAN228.test1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Trivia {
    // Getters and setters
    private String id;
    private String text;
    private String source;

    @JsonProperty("source_url")
    private String sourceUrl;

    private String language;
    private String permalink;

    // Default constructor
    public Trivia() {}

    // Optional: toString method for easy logging and debugging
    @Override
    public String toString() {
        return "Trivia{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", source='" + source + '\'' +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", language='" + language + '\'' +
                ", permalink='" + permalink + '\'' +
                '}';
    }
}