package com.raspberryip.swissknife.hackin.generator.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.raspberryip.swissknife.hackin.generator.pojo.Arguments;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class Names {
    private Arguments arguments;

    public Names() {
        try {
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

            arguments = mapper.readValue(
                    getClass().getClassLoader().getResource("game/generators.yaml"),
                    Arguments.class);
        } catch (IOException e) {
            System.out.println("E' rotto: " + e.getStackTrace());
        }
    }

    private Map<String, List<String>> names(String subset) {
        return arguments.get(subset);
    }

    public List<String> getNames(String subset) {
        List<String> candidate = new ArrayList<>();
        if (arguments.containsKey(subset)) {
            arguments.get(subset).forEach((k, v) -> {
                candidate.addAll(v);
            });
        }
        return candidate;
    }

    public List<String> getNames(String subset, String... groups) {
        List<String> candidate = new ArrayList<>();
        if (arguments.containsKey(subset)) {
            arguments.get(subset).forEach((k, v) -> {
                if (Arrays.asList(groups).contains(k)) {
                    candidate.addAll(v);
                }
            });
        }
        return candidate;
    }

    private String drawElement(List<String> candidates) {
        return candidates.size() == 0 ? "Nil" : candidates.get((int)(Math.random() * candidates.size()));
    }

    public String getRandom(String subset) {
        List<String> candidates = getNames(subset);
        return drawElement(candidates);
    }

    public String getRandom(String subset, String... groups) {
        List<String> candidates = getNames(subset, groups);
        return drawElement(candidates);
    }

}
