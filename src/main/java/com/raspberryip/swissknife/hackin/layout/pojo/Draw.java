package com.raspberryip.swissknife.hackin.layout.pojo;

import com.raspberryip.swissknife.hackin.layout.pojo.basic.Yoyo;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import org.springframework.shell.support.util.StringUtils;

public class Draw {
    private StringBuffer output = new StringBuffer();

    Draw() {
    }

    private Draw append(String s) {
        output.append(s);
        return this;
    }

    public Integer length() {
        return output.length();
    }

    public String output() {
        return output.toString();
    }

    public static class Builder {
        private final Draw draw = new Draw();

        public Builder msg(String message) {
            draw.append(message);
            return this;
        }

        public Builder msg(Printable printable) {
            return msg(printable.print());
        }

        public Builder spacer(Integer len, String filler) {
            return msg(StringUtils.padLeft("", len, filler));
        }

        public Builder spacer(Integer len, Printable special) {
            return spacer(len, special.print());
        }
        public Builder spacer(Integer len) {
            return spacer(len, " ");
        }

        public Builder go() {
            return msg(Yoyo.go());
        }

        public Builder back() {
            return msg(Yoyo.back());
        }

        public Builder move(Point p) {
            return msg(p.move());
        }

        public Builder move(Integer x, Integer y) {
            return move(new Point(x,y));
        }

        public String build() {
            return draw.output();
        }

        public Draw ready() {
            return draw;
        }
    }
}
