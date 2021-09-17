package com.raspberryip.swissknife.hackin.game.pojo.tutorial;

import com.raspberryip.swissknife.hackin.layout.pojo.Colors;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import lombok.Getter;

@Getter
public class Box {
    Point origin;
    Point size;
    Colors fg;
    Colors bg;

    public void setOrigin(Integer[] xy) {
        origin = new Point(xy[0], xy[1]);
    }

    public void setSize(Integer[] xy) {
        size = new Point(xy[0], xy[1]);
    }
}
