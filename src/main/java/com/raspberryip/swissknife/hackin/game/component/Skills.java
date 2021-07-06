package com.raspberryip.swissknife.hackin.game.component;

import com.raspberryip.swissknife.hackin.layout.pojo.*;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Line;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import org.springframework.stereotype.Component;

@Component
public class Skills extends Window {

    public Skills() {
        super(new Point(1,4), new Point(50, 30), Colors.BLACK, Colors.WHITE);
        withTitle("~/skills");
        getCanvas()
                .add(new Label(getScreenPoint(1,2), getSize().getX()-2).withText("1. Developer"))
                .add(
                new TimeGauge(new Line(getScreenPoint(1, 3), getSize().getX() -2), new Score(0).max(30))
                        .withColors(Colors.GREEN, Colors.BLACKHL).withTitle("Just a fake skill!").resetTo(Colors.BLACK, Colors.WHITE, Texts.BOLD, Texts.ITALIC)
        );
    }

}
