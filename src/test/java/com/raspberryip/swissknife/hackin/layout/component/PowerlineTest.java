package com.raspberryip.swissknife.hackin.layout.component;

import com.raspberryip.swissknife.hackin.layout.pojo.Colors;
import com.raspberryip.swissknife.hackin.layout.pojo.Powerline;
import com.raspberryip.swissknife.hackin.layout.pojo.Screen;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PowerlineTest {

    @Test
    public void should_print_the_right_char() {
        System.out.println(Powerline.LARROW.print() + Powerline.LOCK.print() + Powerline.RARROW.print());
        assertThat(Powerline.LARROW.print()).isEqualTo("\uE0B2[7m");
        assertThat(Powerline.LOCK.print()).isEqualTo("");
        assertThat(Powerline.RARROW.print()).isEqualTo("[0m");
    }

    @Test
    public void should_shift_the_right_colors() {
        System.out.println(Powerline.LARROW.shift(Colors.RED, Colors.GREEN) + Powerline.LOCK.print(Colors.RED, Colors.GREEN) + Powerline.RARROW.shift(Colors.GREEN, Colors.RED));
        assertThat(Powerline.LARROW.shift(Colors.RED, Colors.GREEN)).isEqualTo("\u001B[32;41m\uE0B2\u001B[31;42m");
        assertThat(Powerline.LOCK.print(Colors.RED, Colors.GREEN)).isEqualTo("[31;42m");
        assertThat(Powerline.RARROW.shift(Colors.RED, Colors.GREEN)).isEqualTo("\u001B[31;42m\uE0B0");
        System.out.println(Screen.reset());
    }
}