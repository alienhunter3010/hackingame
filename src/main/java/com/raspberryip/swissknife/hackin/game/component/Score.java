package com.raspberryip.swissknife.hackin.game.component;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true)
public class Score {
    private Integer score = 0;
    private Integer max = Integer.MAX_VALUE;

    public Score() {
    }

    public Score(Integer initialScore) {
        score = initialScore;
    }

    public void addScore(Integer gain) {
        if (score < max) {
            score += gain;
        } else {
            score = max;
        }
    }

    public void subScore(Integer lose) {
        if (score > 0) {
            score -= lose;
        } else {
            score = 0;
        }
    }

    public Double percentage() {
        return Double.valueOf(score) / max;
    }

    public Boolean isFull() {
        return score >= max;
    }
}
