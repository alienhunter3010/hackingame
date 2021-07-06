package com.raspberryip.swissknife.hackin.generator.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Argument {
    private Map<String, List<String>> groups;
}
