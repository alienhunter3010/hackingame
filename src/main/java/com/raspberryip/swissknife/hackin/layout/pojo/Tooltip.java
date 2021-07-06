package com.raspberryip.swissknife.hackin.layout.pojo;

import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;

public class Tooltip extends Window {


    public Tooltip(Point origin, Point size, Colors foreground, Colors background) {
        super(origin, size, foreground, background);
    }

    public Tooltip(Integer x, Integer y, Integer width, Integer height, Colors foreground, Colors background) {
        super(x, y, width, height, foreground, background);
    }

    public Tooltip addLine(Integer y, String msg) {
        getCanvas().add(new LineWriter(getScreenPoint(2, y), getSize().getY() -2).append(msg));
        return this;
    }

    @Override
    public Draw.Builder builder() {
        return super.builder().move(getOrigin().getX() + 2, getTarget().getY()) /* .msg("  ")
                .move(getOrigin().getX() + 2, getTarget().getY() + 1) */ .msg(Frames.NO_ES.print() + Frames.NE_OS.print());
    }
}
