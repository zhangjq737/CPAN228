package com.CPAN228.test1.model;

public enum Anime {
    NARUTO("Naruto"), BLEACH("Bleach"), TEKKEN("Tekken"), ONE_PIECE("One Piece"),
    FULL_METAL_ALCHEMIST("Full Metal Alchemist"), DRAGON_BALL("Dragon Ball");

    public final String name;

    private Anime(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
