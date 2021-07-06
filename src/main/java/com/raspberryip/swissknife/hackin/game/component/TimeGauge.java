package com.raspberryip.swissknife.hackin.game.component;

import com.raspberryip.swissknife.hackin.layout.pojo.Evolvable;
import com.raspberryip.swissknife.hackin.layout.pojo.Gauge;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Line;

public class TimeGauge extends Gauge implements Evolvable {

    public TimeGauge(Line line, Score score) {
        super(line, score);
    }

    public TimeGauge(Integer x, Integer y, Integer width, Score score) {
        super(x, y, width, score);
    }

    public TimeGauge(Integer x, Integer y, Integer width, Integer max) {
        super(x, y, width, max);
    }

    public TimeGauge(Integer x, Integer y, Integer width, Integer score, Integer max) {
        super(x, y, width, score, max);
    }

    public void evolve() {
        // TODO: make proportional to time gap
        getScore().addScore(1);
    }
}
