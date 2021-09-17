package com.raspberryip.swissknife.hackin.layout.pojo;

import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Rect;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.TString;
import lombok.Getter;
import lombok.Setter;

public class Window extends Rect implements Drawable {
    private final Colors foreground;
    private final Colors background;
    @Getter
    private final Canvas canvas = new Canvas();

    @Setter
    private Boolean heavy = false;

    private String title;
    private String hint;

    public Window(Point origin, Point size, Colors foreground, Colors background) {
        super(origin, size);
        this.foreground = foreground;
        this.background = background;
    }

    public Window(Integer x, Integer y, Integer width, Integer height, Colors foreground, Colors background) {
        this(new Point(x, y), new Point(width, height), foreground, background);
    }

    public Window withTitle(String title) {
        this.title = title;
        return this;
    }

    public Window withHint(String hint) {
        this.hint = hint;
        return this;
    }

    protected TString defaultLayout() {
        return Escape.format(foreground.fg(), background.bg());
    }

    protected Draw.Builder builder() {
        Draw.Builder builder = new Draw.Builder().msg(defaultLayout());

        builder.move(getOrigin()).msg(Frames.ES.isHeavy(heavy)).spacer(getSize().getX() - 2, Frames.OE.isHeavy(heavy)).msg(Frames.OS.isHeavy(heavy));
        for (Integer y = (getOrigin().getY() + 1) ; y < (getTarget().getY()) ; y++) {
            builder.move(getOrigin().getX(), y).msg(Frames.NS.isHeavy(heavy)).spacer(getSize().getX()-2).msg(Frames.NS.isHeavy(heavy));
        }
        builder.move(getOrigin().getX(), getTarget().getY()).msg(Frames.NE.isHeavy(heavy)).spacer(getSize().getX() -2, Frames.OE.isHeavy(heavy)).msg(Frames.NO.isHeavy(heavy));

        if (title != null) {
            builder.move(getOrigin().getX() + 1, getOrigin().getY()).msg(String.format(" %s ", title));
        }

        if (hint != null) {
            builder.move(getTarget().getX() - (hint.length() + 3), getTarget().getY())
                    .msg(Escape.format(Texts.ITALIC.code()))
                    .msg(String.format(" %s ", hint))
                    .msg(Escape.format(Texts.RESET.code()))
                    .msg(defaultLayout());
        }

        return builder.msg(canvas.print());
    }

    @Override
    public Draw draw() {
        return builder().ready();
    }

    public Integer getScreenX(Integer x) {
        return (x < 0 ? getTarget().getX() : getOrigin().getX()) + x;
    }

    public Integer getScreenY(Integer y) {
        return (y < 0 ? getTarget().getY() : getOrigin().getY()) + y;
    }

    public Point getScreenPoint(Integer x, Integer y) {
        return new Point(
                getScreenX(x),
                getScreenY(y)
        );
    }

    public Point getScreenPoint(Point relativePoint) {
        return getScreenPoint(relativePoint.getX(), relativePoint.getY());
    }
}
