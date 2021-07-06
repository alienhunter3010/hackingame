package com.raspberryip.swissknife.hackin.game.shell;

import com.raspberryip.swissknife.hackin.game.component.HaCkanvas;
import com.raspberryip.swissknife.hackin.layout.pojo.*;
import org.jline.terminal.Terminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultPromptProvider;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HackinGPromptProvider extends DefaultPromptProvider {
    private final Draw prompt;

    public HackinGPromptProvider(Terminal terminal) {
        prompt = new Draw.Builder()
                .msg(Screen.move(1, terminal.getHeight() -2)).msg(Escape.format(Colors.BLUE.bg(), Colors.WHITE.fg()))
                .msg(" H4CK ")
                .msg(Escape.format(Colors.BLUE.fg(), Colors.BLACK.bg()))
                .msg(Powerline.RARROW)
                .msg(Escape.format(Colors.WHITE.fg()))
                .msg(" ")
                .msg(Screen.cleanLine()).msg(Screen.move(9, terminal.getHeight() -2))
                .ready();
    }

    @Override
    public String getPrompt() {
        return prompt.output();
    }

    @Override
    public String getProviderName() {
        return "H4ck Prompt";
    }
}
