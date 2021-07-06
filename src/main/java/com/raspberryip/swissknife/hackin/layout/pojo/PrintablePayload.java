package com.raspberryip.swissknife.hackin.layout.pojo;

public class PrintablePayload implements Printable {
    private final String payload;
    private Integer length = 0;

    PrintablePayload(String msg) {
        payload = msg;
    }

    PrintablePayload(String msg, Integer length) {
        this(msg);
        this.length = length;
    }

    @Override
    public String print() {
        return payload;
    }

    @Override
    public Integer length() {
        return length;
    }
}
