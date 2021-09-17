package com.raspberryip.swissknife.hackin.game.shell;

import com.raspberryip.swissknife.hackin.game.component.HaCkanvas;
import com.raspberryip.swissknife.hackin.game.processor.Advance;
import com.raspberryip.swissknife.hackin.layout.pojo.Colors;
import com.raspberryip.swissknife.hackin.layout.pojo.Escape;
import com.raspberryip.swissknife.hackin.layout.pojo.Screen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultBannerProvider;
import org.springframework.shell.support.util.OsUtils;
import org.springframework.stereotype.Component;

import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class HackinGBannerProvider extends DefaultBannerProvider {

    private final Point screenSize;

    public HackinGBannerProvider(@Qualifier("ScreenSize") Point screenSize) {
        this.screenSize = screenSize;
    }

    @Autowired
    private HaCkanvas canvas;

    @Autowired
    private Advance advance;

    private StringBuffer banner() {
        StringBuffer buf = new StringBuffer();
        buf.append(Screen.clearScreen()).append(Screen.toggleScreen())
            .append("Welcome to").append(OsUtils.LINE_SEPARATOR)
            .append(" _____ _            _   _ _  _        _    _        ____ _  _").append(OsUtils.LINE_SEPARATOR)
            .append("|_   _| |__   ___  | | | | || |   ___| | _(_)_ __  / ___| || |  _ __ ___   ___").append(OsUtils.LINE_SEPARATOR)
            .append("  | | | '_ \\ / _ \\ | |_| | || |_ / __| |/ / | '_ \\| |  _| || |_| '_ ` _ \\ / _ \\").append(OsUtils.LINE_SEPARATOR)
            .append("  | | | | | |  __/ |  _  |__   _| (__|   <| | | | |" + Escape.format(Colors.YELLOWHL.fg()) + "_" + Screen.reset() + "|_| |__   _| | | | | |  __/").append(OsUtils.LINE_SEPARATOR)
            .append("  |_| |_| |_|\\___| |_| |_|  |_|  \\___|_|\\_\\_|_| |_" + Escape.format(Colors.YELLOWHL.fg()) + "(_)" + Screen.reset() + "___|  |_| |_| |_| |_|\\___|").append(OsUtils.LINE_SEPARATOR);
        return buf;
    }

    public String getBanner() {
        StringBuffer buf = new StringBuffer();
        return buf.append(banner()).append(banner()).toString();
    }

    public String getVersion() {
        return "0.0.1";
    }

    public String getWelcomeMessage() {
        Thread thread = new Thread(advance);
        thread.start();
        return  "DISCLAIMER: in this game you can find fictional or existing organizations names.\n" +
                "No one of them is involved in this game. They are just a beloved citations.\n" +
                "Gameplay is not influenced by them, any game behaviour is part of player choices only.\n\n";
    }

    @Override
    public String getProviderName() {
        return "The H4ckinG4me";
    }


}
