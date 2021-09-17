package com.raspberryip.swissknife.hackin.layout.configuration;

import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@ComponentScan
public class TerminalConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(TerminalConfiguration.class);

    private static Terminal terminal;

    public static Terminal singletonTerminal() {
        if (terminal != null) {
            return terminal;
        }
        try {
            terminal = TerminalBuilder.terminal();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return terminal;
    }
    @Bean
    public Terminal terminal() {
        return singletonTerminal();
    }

    @Bean("ScreenSize")
    public Point screenSize() {
        logger.info("Detecting terminal size");
        return new Point(terminal().getWidth(), terminal.getHeight());
    }
}
