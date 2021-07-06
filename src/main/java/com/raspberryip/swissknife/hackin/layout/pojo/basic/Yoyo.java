package com.raspberryip.swissknife.hackin.layout.pojo.basic;


import com.raspberryip.swissknife.hackin.layout.pojo.Escape;

public class Yoyo {
    private static final TString SAVE = Escape.escape("s");
    private static final TString BACK = Escape.escape("u");

    public static TString go() {
        return SAVE;
    }

    public static TString back() {
        return BACK;
    }
}
