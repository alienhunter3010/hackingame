package com.raspberryip.swissknife.hackin.game.component;

import com.raspberryip.swissknife.hackin.layout.pojo.*;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HaCkanvas extends Canvas {

    @Autowired
    private Log log;

    private Tooltip tooltip;

    private Boolean clearScreen = false;

    public HaCkanvas(BWHat bwHat, RGBHat rgbHat, Skills skills, WhoAmI whoami, Log log) {
        tooltip  = new Tooltip(new Point(0,0), new Point(0,0), Colors.WHITE,Colors.BLACK);
        tooltip.isVisible(false);

        elements.add(bwHat);
        elements.add(rgbHat);
        elements.add(whoami);
        elements.add(skills);
        //elements.add(missions);
        elements.add(log);
        //elements.add(flavor);
        //elements.add(hardware);
    }

    public void injectTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
        clearScreen = true;
    }

    public void hideTooltip() {
        this.tooltip.isVisible(false);
        clearScreen = true;
    }

    @Override
    public String print() {
        if (clearScreen) {
            clearScreen = false;
            return Screen.clearScreen() + super.print() + tooltip.draw().output();
        } else {
            return super.print() + tooltip.draw().output();
        }
    }
}
