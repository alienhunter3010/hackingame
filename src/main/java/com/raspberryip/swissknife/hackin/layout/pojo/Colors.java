package com.raspberryip.swissknife.hackin.layout.pojo;

public enum Colors implements Printable {
    BLACK(30),
    RED(31),
    GREEN(32),
    YELLOW(33),
    BLUE(34),
    PURPLE(35),
    CYAN(36),
    WHITE(37),

    GRAY(90),
    BLACKHL(90),
    REDHL(91),
    GREENHL(92),
    YELLOWHL(93),
    BLUEHL(94),
    PURPLEHL(95),
    CYANHL(96),
    WHITEHL(97);

    private static final Integer toBackground = 10;
    //private static final Integer toHighlight = 60;
    private final Integer base;

    Colors(Integer base) {
        this.base = base;
    }

    public String fg() {
        return toString(base);
    }

    private String toString(Integer i) {
        return i.toString();
    }

    public String print() {
        return toString(base);
    }

    public Integer length() {
        return 0;
    }

    public String bg() {
        return toString(base + toBackground);
    }

    /*
    public String highlight() {
        return toString(base + toHighlight);
    }

    public String bgHighlight() {
        return toString(base + toBackground + toHighlight);
    }
    // */
}
