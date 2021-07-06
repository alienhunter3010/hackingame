package com.raspberryip.swissknife.hackin.game.component;

import com.raspberryip.swissknife.hackin.layout.pojo.*;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Line;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.TString;
import lombok.Getter;
import org.jline.terminal.Terminal;
import org.springframework.stereotype.Component;

@Getter
@Component
public class BWHat extends Line implements Drawable {
    private final Score white = new Score();
    private final Score black = new Score();

    public BWHat(Terminal terminal) {
        super(1, 1, terminal.getWidth());
    }

    @Override
    public Draw draw() {
        // " White HatBlack Hat " length ------------------------------------------VV
        String blackWhite = new TString().append(" White Hat").spacer((int)((width-20) * percentage()))
                .append(percentage() < 0.5 ? Powerline.LARROW : Powerline.RARROW.normal()).append(Texts.RESET.escape())
                .rightText("Black Hat ", width);
        return new Draw.Builder()
                .msg(Screen.move(x,y)).msg(Escape.format(Colors.BLACK, Colors.WHITE))
                .msg(blackWhite).msg(Texts.RESET.escape()).ready();
    }

    private Float percentage() {
        return (white.score() + black.score()) == 0 ?
                0.5f :
                Float.valueOf(white.score()) / (white.score() + black.score());
    }

    public Point getOrigin() {
        return this;
    }
}
