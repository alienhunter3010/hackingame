package com.raspberryip.swissknife.hackin.game.component;

import com.raspberryip.swissknife.hackin.game.PersistSetup;
import com.raspberryip.swissknife.hackin.game.pojo.Bio;
import com.raspberryip.swissknife.hackin.generator.component.Names;
import com.raspberryip.swissknife.hackin.layout.pojo.Colors;
import com.raspberryip.swissknife.hackin.layout.pojo.Pair;
import com.raspberryip.swissknife.hackin.layout.pojo.Window;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class WhoAmI extends Window {
    private final Bio bio;

    public WhoAmI(PersistSetup setup, Names names) {
        super(new Point(52,4), new Point(50, 30), Colors.BLACK, Colors.WHITE);
        withTitle("/usr/bin/whoami");

        bio = setup.getBio();

        getCanvas().add(
                new Pair(getScreenPoint(1, 3), 12, 40)
                        .withColors(Colors.GREEN, Colors.WHITE).withText("Name", bio.getFirstName() + " " + bio.getLastName()))
            .add(
                new Pair(getScreenPoint(1, 4), 13, 3)
                        .withColors(Colors.GREEN, Colors.WHITE).withText("Declared sex", bio.getSex()))
            .add(
                new Pair(getScreenPoint(1, 5), 12, 40)
                        .withColors(Colors.GREEN, Colors.WHITE).withText("Training @", bio.getPhD()));
    }
}
