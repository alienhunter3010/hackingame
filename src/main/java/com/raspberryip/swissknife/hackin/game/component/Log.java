package com.raspberryip.swissknife.hackin.game.component;

import com.raspberryip.swissknife.hackin.generator.component.Names;
import com.raspberryip.swissknife.hackin.layout.pojo.*;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import org.springframework.stereotype.Component;

@Component
public class Log extends Window {

    public Log(Names names) {
        super(new Point(1, 35), new Point(101, 26), Colors.BLACK, Colors.YELLOW);
        withTitle("/var/log");
    }

    public void track(String msg) {
        if (getCanvas().length() > (getSize().getY() - 3)) {
            dropEntry();
        }
        getCanvas().add(
                new LineWriter(getScreenPoint(1, 1 + getCanvas().length()), 12)
                        .append(msg));
    }

    public void dropEntry() {
        getCanvas().getElements().remove(0);
        for (Drawable element : getCanvas().getElements()) {
            element.getOrigin().setY(element.getOrigin().getY() - 1);
        }
    }
}
