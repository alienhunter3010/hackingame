package com.raspberryip.swissknife.hackin.game.component;

import com.raspberryip.swissknife.hackin.game.processor.Evolvable;
import com.raspberryip.swissknife.hackin.layout.pojo.Drawable;
import com.raspberryip.swissknife.hackin.layout.pojo.Gauge;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Line;

import java.util.function.Consumer;

public class TimeGauge extends Gauge implements Evolvable<String> {
    private Consumer<String> consumer;
    private Boolean disposable = false;

    public TimeGauge(Line line, Score score) {
        super(line, score);
    }

    public TimeGauge(String id, Integer x, Integer y, Integer width, Score score) {
        super(x, y, width, score);
    }

    public TimeGauge(Integer x, Integer y, Integer width, Integer max) {
        super(x, y, width, max);
    }

    public TimeGauge(Integer x, Integer y, Integer width, Integer score, Integer max) {
        super(x, y, width, new Score(score).max(max));
    }

    public void evolve() {
        // TODO: make proportional to time gap
        getScore().addScore(1);
        if (isMax()) {
            consumer.accept(getTitle());
            disposable = true;
        }
    }

    @Override
    public Boolean isMax() {
        return getScore().isFull();
    }

    @Override
    public void onMax(Consumer<String> consumer) {
        this.consumer = consumer;
    }

    @Override
    public Boolean isDisposable() {
        return disposable;
    }
}
