package com.jamp.nosql.models;

import java.util.List;
import java.util.Random;

public enum SportProficiency {
    NOOB, NOVICE, INTERMEDIATE, ADVANCED, PRO;

    private static final List<SportProficiency> VALUES = List.of(values());
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static SportProficiency random() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
