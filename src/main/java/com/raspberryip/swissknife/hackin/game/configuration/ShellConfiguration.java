package com.raspberryip.swissknife.hackin.game.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.Bootstrap;
import org.springframework.shell.CommandLine;
import org.springframework.shell.core.JLineShellComponent;

@Configuration
@ComponentScan
public class ShellConfiguration {

    @Bean
    public CommandLine butWhy() {
        String[] nothing = {};
        return new CommandLine(nothing, 0, nothing);
    }

    @Bean
    public JLineShellComponent shell() {
        String[] nothing = {};
        final Bootstrap bootstrap = new Bootstrap(nothing, nothing);
        return bootstrap.getJLineShellComponent();
    }

}
