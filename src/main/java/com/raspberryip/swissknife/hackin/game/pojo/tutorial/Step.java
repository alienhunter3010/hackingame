package com.raspberryip.swissknife.hackin.game.pojo.tutorial;

import com.raspberryip.swissknife.hackin.layout.pojo.basic.Positions;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Step {
    private Box box;
    private Positions arrow;
    private Map<Integer, String> text;

    public void setArrow(String position) {
        arrow = Positions.valueOf(position);
    }
}
