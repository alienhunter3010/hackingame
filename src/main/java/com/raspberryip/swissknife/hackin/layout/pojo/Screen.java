package com.raspberryip.swissknife.hackin.layout.pojo;

import com.raspberryip.swissknife.hackin.layout.pojo.basic.TString;

public class Screen extends Escape {
    protected static final String MOV = "H";
    public static final String TOP = "A";
    public static final String UP = TOP;
    public static final String DWN = "B";
    public static final String DOWN = DWN;
    public static final String FWD = "C";
    public static final String LEFT = FWD;
    public static final String REW = "D";
    public static final String RIGHT = REW;

    protected static final String RESET = "0";
    protected static final String LCLEAN = "K";
    protected static final String CLEAR = "2J";


    protected static final String SCREEN_B = "?47h";
    protected static final String SCREEN_A = "?47l";

    private static String currentScreen = SCREEN_A;

    public static TString reset() {
        return format(RESET);
    }

    public static TString clearScreen() {
        return escape(CLEAR);
    }

    public static TString cleanLine() {
        return escape(LCLEAN);
    }

    public static TString move(String direction, Integer cells) {
        return escape(direction, cells.toString());
    }

    public static TString move(Integer x, Integer y) {
        return escape("f", y.toString(), x.toString());
    }

    public static TString firstScreen() {
        currentScreen = SCREEN_A;
        return escape(SCREEN_A);
    }
    public static TString secondScreen() {
        currentScreen = SCREEN_B;
        return escape(SCREEN_B);
    }
    public static TString toggleScreen() {
        return currentScreen.equals(SCREEN_A) ? secondScreen() : firstScreen();
    }
}
