package com.raspberryip.swissknife.hackin.game.shell;

import com.raspberryip.swissknife.hackin.game.PersistSetup;
import com.raspberryip.swissknife.hackin.game.component.BWHat;
import com.raspberryip.swissknife.hackin.game.component.HaCkanvas;
import com.raspberryip.swissknife.hackin.game.component.Log;
import com.raspberryip.swissknife.hackin.game.component.RGBHat;
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
    public String tutorial(@CliOption(key = {"", "skill"}) String what) {
        if (what == null) {
            what = "0";
        }
        switch (what) {
            case "0":
                Tooltip welcomeTooltip = new Tooltip(new Point(5, screenSize.getY() - 13), new Point(60, 10), Colors.WHITEHL, Colors.BLACK);
                welcomeTooltip
                        .addLine(1, "Since you were kid, you have a good mood for Computers")
                        .addLine(2, "Now that you are at College you are addicted")
                        .addLine(3, "It's time to join the hacker community")
                        .addLine(5, "Everything starts here")
                        .addLine(6, "Real hackers use the terminal")
                        .addLine(7, "Now write `tutorial 1` and press Enter");
                return tooltip(welcomeTooltip);
            case "1":
                Tooltip youTooltip = new Tooltip(new Point(53, 10), new Point(48, 7), Colors.WHITEHL, Colors.BLACK);
                youTooltip
                        .addLine(1, "This is you")
                        .addLine(2, "Later you can learn how to assume a new identity")
                        .addLine(3, "but actually you can't change this")
                        .addLine(7, "Now write `tutorial 2`");
                return tooltip(youTooltip);
            case "2":
                Tooltip skillsTooltip = new Tooltip(new Point(3, 10), new Point(48, 7), Colors.WHITEHL, Colors.BLACK);
                skillsTooltip
                        .addLine(1, "These are your skills")
                        .addLine(2, "improve them by learning stuff")
                        .addLine(3, "For example:")
                        .addLine(4, "you can learn development basics writing `learn 1`")
                        .addLine(5, "you need to study, and study needs time")
                        .addLine(7, "Now write `tutor 3`");
                return tooltip(skillsTooltip);
        }
        return refresh();
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
