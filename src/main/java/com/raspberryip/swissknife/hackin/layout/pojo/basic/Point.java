package com.raspberryip.swissknife.hackin.layout.pojo.basic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Point {
    protected Integer x;
    protected Integer y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public TString move() {
        return new TString().append(String.format("\033[%d;%dH", y, x), 0);
    }

    public String where() {
        return String.format("(%d,%d)", x, y);
    }
}
