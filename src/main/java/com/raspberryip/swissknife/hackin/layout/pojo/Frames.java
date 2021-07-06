package com.raspberryip.swissknife.hackin.layout.pojo;

public enum Frames implements Printable {
    OE("\u2500", "\u2550"),
    NS("\u2502", "\u2551"),
    ES("\u250C", "\u2554"),
    OS("\u2510", "\u2557"),
    NE("\u2514", "\u255a"),
    NO("\u2518", "\u255d"),
    NES("\u251C", "\u2560"),
    NOS("\u2524", "\u2563"),
    OES("\u252C", "\u2566"),
    NOE("\u2534", "\u2569"),
    NOES("\u253C", "\u256c"),

    NO_ES("\u2572", "\u2572"),
    NE_OS("\u2571", "\u2571");

    private final String singleLine;
    private final String doubleLine;
    private boolean heavy = false;

    Frames(String singleLine, String doubleLine) {
        this.singleLine = singleLine;
        this.doubleLine = doubleLine;
    }

    public Frames isHeavy(Boolean heavy) {
        this.heavy = heavy;
        return this;
    }

    @Override
    public String toString() {
        return print();
    }

    @Override
    public String print() {
        return heavy ? doubleLine : singleLine;
    }

    @Override
    public Integer length() {
        return 1;
    }
}
