package com.game.player.decorator.concreteComponent;

import com.game.player.decorator.GalardonComponent;

public class OjoEnvidiaComponentDecorator extends AbstractGalardonComponentDecorator {
    public static final Integer DEFAULT_DANIO = 3;
    public static final String DEFAULT_DESCRIPTION = "Ojos de la envidia";
    public OjoEnvidiaComponentDecorator(GalardonComponent galardonComponent){
        super(DEFAULT_DESCRIPTION, DEFAULT_DANIO, galardonComponent);
    }
}
