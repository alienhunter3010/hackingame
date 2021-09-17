package com.raspberryip.swissknife.hackin.game.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.raspberryip.swissknife.hackin.game.pojo.tutorial.Step;
import com.raspberryip.swissknife.hackin.game.pojo.tutorial.TutorialMap;
import com.raspberryip.swissknife.hackin.layout.pojo.Tooltip;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Optional;

@Component
public class Tutorial {
    private TutorialMap tutorialMap;

    public Tutorial() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

            tutorialMap = mapper.readValue(
                    getClass().getClassLoader().getResource("game/tutorial.yaml"),
                    TutorialMap.class);
        } catch (IOException e) {
            System.out.println("E' rotto: " + e.getStackTrace());
        }
    }

    public Optional<Tooltip> build(Integer stepId) {
        Step step = tutorialMap.get(stepId);
        if (step == null) {
            return Optional.empty();
        }

        Tooltip tooltip = new Tooltip(step.getBox().getOrigin(), step.getBox().getSize(), step.getBox().getFg(), step.getBox().getBg());
        tooltip.arrowOn(step.getArrow());
        step.getText().forEach(tooltip::addLine);
        return Optional.of(tooltip);
    }
}
