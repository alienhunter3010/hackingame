package com.raspberryip.swissknife.hackin.layout.pojo;

import com.raspberryip.swissknife.hackin.layout.pojo.basic.TString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Escape {
    protected static final String ESC = "\033[";
    protected static final String SEP = ";";

    protected static final String FMT = "m";

    public static TString escape(String ending, String... args) { ;
        return new TString().append(ESC + String.join(SEP, args) + ending, 0);
    }

    public static TString format(String... args) {
        return escape(FMT, args);
    }

    // TODO: TBT
    public static TString format(Colors foreground, Colors background, Texts... txtFormats) {
        List<String> formats = new ArrayList<>();
        formats.add(foreground.fg());
        formats.add(background.bg());
        Arrays.stream(txtFormats).forEach(t -> formats.add(t.print()));
        String[] as = {};
        return escape(FMT, formats.toArray(as));
    }
}
