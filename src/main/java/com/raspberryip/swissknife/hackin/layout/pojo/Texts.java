package com.raspberryip.swissknife.hackin.layout.pojo;

import com.raspberryip.swissknife.hackin.layout.pojo.basic.TString;

public enum Texts implements Printable {
    RESET(0),
    BOLD(1),
    SNOOZE(2),
    ITALIC(3),
    UNDERLINE(4),
    BLINK(5),
    INVERSE(7),
    HIDDEN(8),
    STRIKE(9);

    private static Texts mode = RESET;
    private final Integer base;

    Texts(Integer base) {
        this.base = base;
    }

    public String print() {
        switch (this) {
            case RESET:
            case INVERSE:
                mode = this;
        }
        return base.toString();
    }

    public Integer length() {
        return 0;
    }

    @Override
    public String toString() {
        return print();
    }

    public TString escape() {
        return new TString().append(Escape.format(print()));
    }

    public String code() {
        return base.toString();
    }

    public static Boolean isInverted() {
        return mode.equals(INVERSE);
    }

    public static String mode() {
        return mode.print();
    }
}
