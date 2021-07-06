package com.raspberryip.swissknife.hackin.layout.pojo.basic;

import lombok.Getter;

@Getter
public class Line extends Point {
    protected final Integer width;

    public Line(Integer x, Integer y, Integer width) {
        super(x, y);
        this.width = width;
    }

    public Line(Point p, Integer width) {
        this(p.getX(), p.getY(), width);
    }

    public Point getOrigin() {
        return this;
    }
}
