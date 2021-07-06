package com.raspberryip.swissknife.hackin.layout.pojo;

public enum Powerline implements Printable {
    RARROW("\ue0b0"),
    LARROW("\ue0b2"),
    RCHEVRON("\ue0b1"),
    LCHEVRON("\ue0b3"),

    GITBRANCH("\ue0a0"),
    LN("\ue0a1"),
    LOCK("\ue0a2");

    private final String character;

    Powerline(String character) {
        this.character = character;
    }

    public String print(Colors foreground, Colors background) {
        return Escape.format(foreground.fg(), background.bg()) + character;
    }

    public Integer length() {
        return 1;
    }

    public String shift(Colors left, Colors right) {
        switch (this) {
            case LARROW:
                return print(right, left) + Escape.format(left.fg(), right.bg());
            default:
                return print(left, right);
        }
    }

    public String print() {
        return character;
    }

    public Printable preFormat(Printable format) {
        return new PrintablePayload(format.print() + print(), length());
    }

    public Printable inverse() {
        return preFormat(Texts.INVERSE);
    }

    public Printable normal() {
        return preFormat(Texts.RESET.escape());
    }

    public String smart() {
        if (this.equals(RARROW)) {
            if (Texts.isInverted()) {
                return Texts.RESET.escape() + character;
            } else {
                return Texts.INVERSE.escape() + character;
            }
        } else if (this.equals(LARROW)) {
            if (Texts.isInverted()) {
                return character + Texts.RESET.escape();
            } else {
                return character + Texts.INVERSE.escape();
            }
        } else {
            return print();
        }
    }
}
