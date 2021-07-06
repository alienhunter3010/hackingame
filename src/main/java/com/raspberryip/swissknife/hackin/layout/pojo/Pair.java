package com.raspberryip.swissknife.hackin.layout.pojo;

import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pair implements Drawable {
    private final Label key;
    private final Label value;

    public Pair(Integer x, Integer y, Integer keyWidth, Integer valueWidth) {
        key = new Label(x, y, keyWidth);
        value = new Label(x + keyWidth, y, valueWidth);
    }

    public Pair(Point p, Integer keyWidth, Integer valueWidth) {
        this(p.getX(), p.getY(), keyWidth, valueWidth);
    }

    public Pair withColors(Colors keyForeground, Colors keyBackground, Colors valueForeground, Colors valueBackground) {
        key.withColor(keyForeground, keyBackground);
        value.withColor(valueForeground, valueBackground);
        return this;
    }

    public Pair withColors(Colors foreground, Colors background) {
        return withColors(foreground, background, foreground, background);
    }

    public Pair withText(String keyText, String valueText) {
        key.withText(keyText);
        value.withText(valueText);
        return this;
    }

    public Pair withText(String keyText, Printable valuePrintable) {
        return withText(keyText, valuePrintable.print());
    }

    @Override
    public Draw draw() {
        return new Draw.Builder()
                .move(key.getOrigin()).msg(key)
                .move(value.getOrigin()).msg(value).ready();
    }

    public Point getOrigin() {
        return key.getOrigin();
    }
}
