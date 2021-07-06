package com.raspberryip.swissknife.hackin.generator.pojo;

import com.raspberryip.swissknife.hackin.layout.pojo.Printable;

public enum Sex implements Printable {
    FEMALE("\u2640"),
    MALE("\u2642"),
    FLUID("\u26a7"),
    MACHINE("\u2699"),
    UNKNOWN("?");

    private final String symbol;

    Sex(String symbol) {
        this.symbol = symbol;
    }

    public static Sex getRandom() {
        return Sex.values()[(int)(Math.random() * (Sex.UNKNOWN.ordinal() + 1))];
    }

    @Override
    public String print() {
        return symbol;
    }

    @Override
    public Integer length() {
        return 1;
    }
}
