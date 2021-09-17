package com.raspberryip.swissknife.hackin.game.component;

import com.raspberryip.swissknife.hackin.game.processor.Evolvable;
import com.raspberryip.swissknife.hackin.layout.pojo.*;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Line;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Skills extends Window {

    @Autowired
    private Log log;

    public Skills() {
        super(new Point(52,4), new Point(50, 30), Colors.BLACK, Colors.WHITE);
        withTitle("~/skills").withHint("learn");

        addTimeGauge(getCanvas(), "1. Developer", "Just a fake skill!", 3, 30);
    }

    private TimeGauge addTimeGauge(Canvas canvas, String label, String title, Integer y, Integer max) {
        TimeGauge t = new TimeGauge(new Line(getScreenPoint(1, y), getSize().getX() - 2), new Score().max(max));
        t.onMax(s -> {
            log.track(String.format("Skill %s acquired", s));
        });
        canvas.add(t.withLabel(new Label(getScreenPoint(1, y-1), getSize().getX()-2).withText(label))
                .withColors(Colors.GREEN, Colors.BLACKHL)
                .withTitle(title)
                .resetTo(Colors.BLACK, Colors.WHITE, Texts.BOLD, Texts.ITALIC));
        return t;
    }
}
