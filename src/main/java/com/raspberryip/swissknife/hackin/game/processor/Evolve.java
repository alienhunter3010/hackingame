package com.raspberryip.swissknife.hackin.game.processor;

import com.raspberryip.swissknife.hackin.game.component.HaCkanvas;
import com.raspberryip.swissknife.hackin.layout.pojo.Canvas;
import com.raspberryip.swissknife.hackin.layout.pojo.Evolvable;
import com.raspberryip.swissknife.hackin.layout.pojo.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.JLineShellComponent;
import org.springframework.stereotype.Component;

@Component
public class Evolve implements Runnable {

    @Autowired
    private HaCkanvas mainCanvas;

    @Autowired
    private JLineShellComponent shell;

    private void scanElements(Canvas canvas) {
        canvas.getElements().stream()
                .filter(e -> e instanceof Window).forEach(
                w -> scanElements(((Window) w).getCanvas())
        );
        canvas.getElements().stream()
                .filter(e -> e instanceof Evolvable).forEach(
                        e -> ((Evolvable)e).evolve()
        );
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(500);
                scanElements(mainCanvas);
                shell.executeCommand("hack");
            } catch (InterruptedException e) {
                // NOP, just exiting...
            }
        }
    }
}
