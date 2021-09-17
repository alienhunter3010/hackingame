package com.raspberryip.swissknife.hackin.layout.pojo.basic;

import com.raspberryip.swissknife.hackin.layout.pojo.Draw;
import com.raspberryip.swissknife.hackin.layout.pojo.Frames;

import static com.raspberryip.swissknife.hackin.layout.pojo.basic.Positions.*;

public class Arrow {

    private final Rect frame;
    
    public Arrow(Rect frame) {
        this.frame = frame;    
    }

    public Draw.Builder onNO(Draw.Builder builder) {
        return builder.move(frame.getOrigin().getX() + 2, frame.getOrigin().getY())
                .msg(Frames.NE_OS.print() + Frames.NO_ES.print());
    }

    public Draw.Builder onNE(Draw.Builder builder) {
        return builder.move(frame.getTarget().getX() - 4, frame.getOrigin().getY())
                .msg(Frames.NE_OS.print() + Frames.NO_ES.print());
    }

    public Draw.Builder onEN(Draw.Builder builder) {
        return builder
                .move(frame.getTarget().getX(), frame.getOrigin().getY() + 1).msg(Frames.NO_ES.print())
                .move(frame.getTarget().getX(), frame.getOrigin().getY() + 2).msg(Frames.NE_OS.print());
    }

    public Draw.Builder onES(Draw.Builder builder) {
        return builder
                .move(frame.getTarget().getX(), frame.getTarget().getY() - 2).msg(Frames.NO_ES.print())
                .move(frame.getTarget().getX(), frame.getTarget().getY() - 1).msg(Frames.NE_OS.print());
    }

    public Draw.Builder onSE(Draw.Builder builder) {
        return builder.move(frame.getTarget().getX() - 4, frame.getTarget().getY())
                .msg(Frames.NO_ES.print() + Frames.NE_OS.print());
    }

    public Draw.Builder onSO(Draw.Builder builder) {
        return builder.move(frame.getOrigin().getX() + 2, frame.getTarget().getY())
                .msg(Frames.NO_ES.print() + Frames.NE_OS.print());
    }

    public Draw.Builder onOS(Draw.Builder builder) {
        return builder
                .move(frame.getOrigin().getX(), frame.getTarget().getY() - 2).msg(Frames.NE_OS.print())
                .move(frame.getOrigin().getX(), frame.getTarget().getY() - 1).msg(Frames.NO_ES.print());
    }

    public Draw.Builder onON(Draw.Builder builder) {
        return builder
                .move(frame.getOrigin().getX(), frame.getOrigin().getY() + 1).msg(Frames.NE_OS.print())
                .move(frame.getOrigin().getX(), frame.getOrigin().getY() + 2).msg(Frames.NO_ES.print());
    }

    public Draw.Builder on(Positions position, Draw.Builder builder) {
        switch (position) {
            case OS:
                return onOS(builder);
            case ON:
                return onON(builder);
            case NO:
                return onNO(builder);
            case NE:
                return onNE(builder);
            case EN:
                return onEN(builder);
            case ES:
                return onES(builder);
            case SE:
                return onSE(builder);
            case SO:
            default:
                return onSO(builder);
        }
    }
}
