package com.raspberryip.swissknife.hackin.layout.pojo.basic;

import com.raspberryip.swissknife.hackin.layout.pojo.Printable;

public class TString implements Printable {
    private final StringBuffer text = new StringBuffer();
    private Integer length = 0;
    private Integer bookmark = 0;

    public String print() {
        return text.toString();
    }

    @Override
    public String toString() {
        return print();
    }

    public TString append(String msg, Integer realLength) {
        text.append(msg);
        length += realLength;
        return this;
    }

    private TString prepend(String msg, Integer realLength) {
        text.insert(0, msg);
        length += realLength;
        return this;
    }

    public TString append(String msg) {
        if (msg == null) {
            return this;
        }
        return append(msg, msg.length());
    }

    public TString append(Printable msg) {
        return append(msg.print(), msg.length());
    }

    public TString prepend(String msg) {
        return prepend(msg, msg.length());
    }

    public TString prepend(Printable msg) {
        return prepend(msg.print(), msg.length());
    }

    private String spacer(String msg, Integer len) {
        if (len - (length - bookmark) > 0) {
            return fill(msg, (len - (length - bookmark)));
        } else {
            return "";
        }
    }

    public TString spacer(Integer len) {
        return append(spacer(" ", len));
    }

    public static String fill(String msg, Integer len) {
        if (len > 0) {
            return String.format("%" + len + "s", msg);
        } else {
            return "";
        }
    }

    public static String fill(Integer len) {
        return fill(" ", len);
    }

    public String rightText(String msg, Integer len) {
        bookmark = 0;
        return append(spacer(msg, len)).print();
    }

    public Integer length() {
        return length;
    }

    public TString bookmark() {
        bookmark = length;
        return this;
    }
}
