package com.raspberryip.swissknife.hackin.game.shell;

import com.raspberryip.swissknife.hackin.game.PersistSetup;
import com.raspberryip.swissknife.hackin.game.component.*;
import com.raspberryip.swissknife.hackin.layout.pojo.Colors;
import com.raspberryip.swissknife.hackin.layout.pojo.LineWriter;
import com.raspberryip.swissknife.hackin.layout.pojo.Screen;
import com.raspberryip.swissknife.hackin.layout.pojo.Tooltip;
import com.raspberryip.swissknife.hackin.layout.pojo.basic.Point;
import org.jline.terminal.Terminal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.ExitShellRequest;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

@Component
public class HackinGCLI implements CommandMarker {

    @Autowired
    private HaCkanvas canvas;

    @Autowired
    private Terminal terminal;

    @Autowired
    private BWHat hat;

    @Autowired
    private RGBHat rgb;

    @Autowired
    private Log log;

    @Autowired
    private PersistSetup setup;

    @Autowired
    private Tutorial tutorial;

    @Autowired
    @Qualifier("ScreenSize")
    private Point screenSize;

    /*
    @CliCommand(value = { "web-get", "wg" })
    public String webGet(
      @CliOption(key = "url") String url) {
        return getContentsOfUrlAsString(url);
    }

    @CliCommand(value = { "web-save", "ws" })
    public String webSave(
      @CliOption(key = "url") String url,
      @CliOption(key = { "out", "file" }) String file) {
        String contents = getContentsOfUrlAsString(url);
        try (PrintWriter out = new PrintWriter(file)) {
            out.write(contents);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return "Done.";
    }
    // */

    @CliCommand(value = { "log" }, help="Log a custom message")
    public String logMsg(@CliOption(key = {"", "msg"}) String msg) {
        log.track(msg);
        return refresh();
    }

    /*
     * DEBUG Commands!
     */
    @CliCommand(value = { "dw" }, help="DEBUG: add score to White Hat")
    public String yangScore() {
        hat.getWhite().addScore(10);
        return refresh();
    }
    @CliCommand(value = { "db" }, help="DEBUG: add score to Black Hat")
    public String yinScore() {
        hat.getBlack().addScore(10);
        return refresh();
    }
    @CliCommand(value = { "dr" }, help="DEBUG: add score to Ideologist")
    public String redScore() {
        rgb.getRed().addScore(10);
        return refresh();
    }
    @CliCommand(value = { "dg" }, help="DEBUG: add score to Green Warrior")
    public String greenScore() {
        rgb.getGreen().addScore(10);
        return refresh();
    }
    @CliCommand(value = { "dt" }, help="DEBUG: add score to Attacker")
    public String blueScore() {
        rgb.getBlue().addScore(10);
        return refresh();
    }



    @CliCommand(value={ "tutor", "tutorial" }, help="Learn a new Skill")
    public void tutorial(@CliOption(key = {"", "skill"}) Integer what) {
        if (what == null) {
            what = 0;
        }
        //canvas.hideTooltips();
        tutorial.build(what).ifPresent(t -> canvas.injectTooltip(t));
    }

    private String tooltip(Tooltip tooltip) {
        return new StringBuffer()
                .append(Screen.clearScreen())
                .append(refresh())
                .append(
                        tooltip.draw().output()
                ).toString();
    }

    /*
    private String getContentsOfUrlAsString(String url) {
        try {
            return getContentsOfUrlAsString(new URL(url));
        } catch (IOException e) {
            return "Unable to download content. Wrong URL?";
        }
    }

    private String getContentsOfUrlAsString(URL url) {
        StringBuilder sb = new StringBuilder();
        try {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    sb.append(inputLine);
                }
            }
        } catch (IOException ex) {
            sb.append("ERROR");
        }
        return sb.toString();
    }
    // */

    @CliCommand(value = { "hack" }, help="Back to hack!")
    public String refresh() {
        return canvas.print();
    }

    @CliCommand(
            value = {"bye"},
            help = "Save and Exits the shell"
    )
    public ExitShellRequest wq() {
        setup.save();
        return ExitShellRequest.NORMAL_EXIT;
    }
}
