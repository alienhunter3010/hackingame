package com.raspberryip.swissknife.hackin.layout.pojo;

import com.raspberryip.swissknife.hackin.layout.pojo.basic.Line;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.TString;

public class Label extends Line implements Drawable, Printable {
    private final TString content = new TString();

    public Label(Integer x, Integer y, Integer width) {
        super(x, y, width);
    }

    public Label(Point p, Integer width) {
        super(p, width);
    }

    public Label withColor(Colors foreground, Colors background) {
        content.prepend(Escape.format(foreground.fg(), background.bg()));
        return this;
    }

    public Label withText(String msg) {
        content.append(msg);
        return this;
    }

    @Override
    public String print() {
        return content.prepend(move()).spacer(width - content.length()).print();
    }

    @Override
    public Integer length() {
        return content.length();
    }

    @Override
    public Draw draw() {
        return new Draw.Builder().msg(print()).ready();
    }
}
