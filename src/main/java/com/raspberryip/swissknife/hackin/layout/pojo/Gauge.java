package com.raspberryip.swissknife.hackin.layout.pojo;

import com.raspberryip.swissknife.hackin.game.component.Score;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Line;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.TString;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
public class Gauge extends LineWriter {
    private String title = "";
    private final Score score;
    @Setter
    private Printable colors = Escape.format(Colors.BLACK.bg(), Colors.GREEN.fg());

    public Gauge(Line line, Score score) {
        super(line);
        this.score = score;
    }

    public Gauge(Integer x, Integer y, Integer width, Score score) {
        this(new Line(x, y, width), score);
    }

    public Gauge(Integer x, Integer y, Integer width, Integer max) {
        this(new Line(x, y, width), new Score().max(max));
    }

    public Gauge(Integer x, Integer y, Integer width, Integer score, Integer max) {
        this(new Line(x, y, width), new Score(score).max(max));
    }

    public Gauge withTitle(@NotNull String title) {
        this.title = title;
        return this;
    }

    public Gauge withColors(Colors foreground, Colors background) {
        colors = Escape.format(foreground.fg(), background.bg());
        return this;
    }

    @Override
    public Draw draw() {
        Integer bar = getLine().getWidth() - (getLine().getWidth() > 20 ? 4 : 0);
        Integer completed = (int)( bar  * getScore().percentage());
        Draw.Builder builder = new Draw.Builder().move(getLine().getX(), getLine().getY()).msg(colors);
        if (completed > 0) {
            String highlight = " " + title.substring(0, Math.min(completed - 1, title.length()));
            if (highlight.length() < completed) {
                highlight += TString.fill(completed - highlight.length());
            }
            builder.msg(Texts.INVERSE.escape()).msg(highlight).msg(Texts.RESET.escape())
                    .msg(title.substring(Math.min(completed -1, title.length())));
        } else {
            builder.msg(" " + title);
        }
        builder.msg(TString.fill( bar - Math.max(completed, title.length() + 1) ));
        if (bar < getLine().getWidth()) {
            builder.msg(reset);
            if (getScore().percentage() == 1) {
                builder.msg(Texts.BLINK.escape()).msg("100%");
            } else {
                builder.msg(String.format(" %d%%", (int) (getScore().percentage() * 100)));
            }
            builder.msg(Texts.RESET.escape());
        }
        return builder.ready();
    }
}
