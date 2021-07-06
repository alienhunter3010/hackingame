package com.raspberryip.swissknife.hackin.layout.component;

import com.raspberryip.swissknife.hackin.layout.pojo.Draw;
import com.raspberryip.swissknife.hackin.layout.pojo.Powerline;
import com.raspberryip.swissknife.hackin.layout.pojo.Texts;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class DrawTest {

    @Test
    public void should_be_eye_candy() {
        System.out.println(
                new Draw.Builder()
                        .msg(" ").msg(Powerline.LARROW)
                        .msg(Texts.BLINK).msg("  Welcome to this test  ").msg(Texts.mode())
                        .msg(Powerline.RARROW).msg(" ").build()
        );
    }
}