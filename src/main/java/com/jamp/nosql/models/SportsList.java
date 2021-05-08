package com.jamp.nosql.models;

import java.util.List;
import java.util.Random;

public enum SportsList {
    SOCCER ("Soccer"),
    FOOTBALL ("Football"),
    HOCKEY ("Hockey"),
    GOLF ("Golf"),
    BASEBALL ("Baseball"),
    CHESS ("Chess");

    private String label;

    SportsList(String label) {
        this.label = label;
    }

    public String toString() {
        return label;
    }

    private static final List<SportsList> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static String random() {
        return VALUES.get(RANDOM.nextInt(SIZE)).toString();
    }
}
