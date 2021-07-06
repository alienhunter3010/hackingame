package com.raspberryip.swissknife.hackin.generator.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Group {
    private String name;
    private List<String> values;
}
