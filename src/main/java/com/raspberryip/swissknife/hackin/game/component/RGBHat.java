package com.raspberryip.swissknife.hackin.game.component;

import com.raspberryip.swissknife.hackin.layout.pojo.*;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Line;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.TString;
import lombok.Getter;
import org.jline.terminal.Terminal;
import org.springframework.stereotype.Component;

@Component
public class RGBHat extends Line implements Drawable {
    @Getter
    private final Score red = new Score(10);
    @Getter
    private final Score green = new Score(10);
    @Getter
    private final Score blue = new Score(10);

    private final String lRed =   " Ideologist    ";
    private final String lGreen = " Green warrior ";
    private final String lBlue =  " Attacker      ";

    public RGBHat(Terminal terminal) {
        super(1, 2, terminal.getWidth());
    }

    @Override
    public Draw draw() {
        Integer pillow = width - lRed.length() / 3;
        String rgb = new TString()
                .append(Escape.format(Colors.RED.bg(), Colors.YELLOW.fg(), Texts.BOLD.code())).append(lRed).spacer((int)(pillow * percentage(red))).append(Escape.format(Colors.GREEN.bg(), Colors.RED.fg())).append(Powerline.RARROW).bookmark()
                .append(Escape.format(Colors.WHITEHL.fg(), Texts.BOLD.code())).append(lGreen).spacer((int)(pillow * percentage(green))).append(Escape.format(Colors.GREEN.fg(), Colors.BLUE.bg())).append(Powerline.RARROW).bookmark()
                .append(Escape.format(Colors.WHITE.fg())).append(lBlue).rightText(" ", width);
        return new Draw.Builder()
                .msg(Screen.move(x,y)).msg(rgb).ready();
    }

    private Double percentage(Score target) {
        return red.score() + green.score() + blue.score() == 0 ?
                0.33333d :
                Double.valueOf(target.score()) / (red.score() + green.score() + blue.score());
    }

    public Point getOrigin() {
        return this;
    }
}
