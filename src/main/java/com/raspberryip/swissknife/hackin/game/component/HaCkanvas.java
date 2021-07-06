package com.raspberryip.swissknife.hackin.game.component;

import com.raspberryip.swissknife.hackin.layout.pojo.Canvas;
import com.raspberryip.swissknife.hackin.layout.pojo.Colors;
import com.raspberryip.swissknife.hackin.layout.pojo.Tooltip;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import org.springframework.stereotype.Component;

@Component
public class HaCkanvas extends Canvas {

    public HaCkanvas(BWHat bwHat, RGBHat rgbHat, Skills skills, WhoAmI whoami, Log log) {
        elements.add(bwHat);
        elements.add(rgbHat);
        elements.add(whoami);
        elements.add(skills);
        //elements.add(missions);
        elements.add(log);
        //elements.add(flavor);
    }
}
