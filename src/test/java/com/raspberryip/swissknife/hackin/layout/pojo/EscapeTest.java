package com.raspberryip.swissknife.hackin.layout.pojo;

import org.junit.Test;

public class EscapeTest {

    @Test
    public void should_something() {
        String fmt = Escape.format(Colors.YELLOW, Colors.RED, Texts.BOLD).print();
        System.out.println(fmt + " Testing! ");
    }
}