package com.raspberryip.swissknife.hackin.layout.pojo;

import com.raspberryip.swissknife.hackin.layout.pojo.basic.Line;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.TString;
import lombok.Data;

@Data
public class LineWriter implements Drawable {
    private final Line line;
    private TString content = new TString();
    protected Printable reset = Texts.RESET;

    public LineWriter(Line line) {
        this.line = line;
    }

    public LineWriter(Point p, Integer width) {
        this(new Line(p, width));
    }

    public LineWriter(Integer x, Integer y, Integer width) {
        this(new Line(x, y, width));
    }

    public LineWriter append(Printable msg) {
        content.append(msg);
        return this;
    }

    public LineWriter append(String msg) {
        content.append(msg);
        return this;
    }

    public LineWriter resetTo(Printable reset) {
        this.reset = reset;
        return this;
    }

    public LineWriter resetTo(Colors foreground, Colors background) {
        this.reset = Escape.format(foreground.fg(), background.bg());
        return this;
    }

    public LineWriter resetTo(Colors foreground, Colors background, Texts... txtFormat) {
        this.reset = Escape.format(foreground, background, txtFormat);
        return this;
    }

    public LineWriter reset() {
        return append(reset);
    }

    @Override

    public Draw draw() {
        return new Draw.Builder().move(this.line).msg(content).ready();
    }

    public Point getOrigin() {
        return line;
    }
}
