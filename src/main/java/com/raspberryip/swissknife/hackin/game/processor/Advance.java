package com.raspberryip.swissknife.hackin.game.processor;

import com.raspberryip.swissknife.hackin.game.component.HaCkanvas;
import com.raspberryip.swissknife.hackin.layout.pojo.Canvas;
import com.raspberryip.swissknife.hackin.layout.pojo.Drawable;
import com.raspberryip.swissknife.hackin.layout.pojo.Progressive;
import com.raspberryip.swissknife.hackin.layout.pojo.Window;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.JLineShellComponent;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Advance implements Runnable {

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
                .filter(e -> e instanceof Evolvable && !((Evolvable<?>) e).isMax())
                .forEach(
                        e -> ((Evolvable<?>)e).evolve()
        );
        canvas.getElements().removeAll(
                canvas.getElements().stream().filter(e -> e instanceof Progressive && ((Progressive<?>) e).isDisposable())
                        .collect(Collectors.toList())
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
