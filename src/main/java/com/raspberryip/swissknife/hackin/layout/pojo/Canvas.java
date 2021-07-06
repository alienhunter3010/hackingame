package com.raspberryip.swissknife.hackin.layout.pojo;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Canvas implements Printable {
    protected final List<Drawable> elements = new ArrayList<>();

    public String print() {
        StringBuffer paint = new StringBuffer();
        elements.forEach(
                d -> paint.append(d.draw().output())
        );
        return paint.toString();
    }

    @Override
    public Integer length() {
        return elements.size();
    }

    public Canvas add(Drawable element) {
        elements.add(element);
        return this;
    }
}
