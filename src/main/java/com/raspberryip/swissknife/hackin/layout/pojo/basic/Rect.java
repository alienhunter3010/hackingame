package com.raspberryip.swissknife.hackin.layout.pojo.basic;

import lombok.Getter;

@Getter
public class Rect {
    private final Point origin;
    private final Point size;
    private final Point target;

    public Rect(Point origin, Point size) {
        this.origin = origin;
        this.size = size;
        target = new Point(
                origin.getX() + size.getX() - 1,
                origin.getY() + size.getY() - 1);
    }

    public Rect(Integer x, Integer y, Integer width, Integer height) {
        this(new Point(x,y), new Point(width, height));
    }
}
