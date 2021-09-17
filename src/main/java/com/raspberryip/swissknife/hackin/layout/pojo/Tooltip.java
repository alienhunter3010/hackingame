package com.raspberryip.swissknife.hackin.layout.pojo;

import com.raspberryip.swissknife.hackin.layout.pojo.basic.Arrow;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Positions;

public class Tooltip extends Window {
    private Boolean visible = true;
    private Positions arrowPosition = Positions.SO;

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

    public Tooltip isVisible(Boolean visible) {
        this.visible = visible;
        return this;
    }

    public Tooltip arrowOn(Positions position) {
        arrowPosition = position;
        return this;
    }

    @Override
    public Draw draw() {
        return visible ? super.draw() : new Draw();
    }

    @Override
    public Draw.Builder builder() {
        return new Arrow(this).on(arrowPosition, super.builder());
    }
}
