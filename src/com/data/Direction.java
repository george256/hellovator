package com.data;

public enum Direction {
    UP,
    DOWN,
    NONE;

    public static Direction convertCharToDirection(char c) {
        if (c == 'u' || c == 'U') return UP;
        if (c == 'd' || c == 'D') return DOWN;
        return NONE;
    }
}