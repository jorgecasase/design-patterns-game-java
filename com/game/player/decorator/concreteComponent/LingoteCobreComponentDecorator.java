package com.game.player.decorator.concreteComponent;

import com.game.player.decorator.GalardonComponent;

public class LingoteCobreComponentDecorator extends AbstractGalardonComponentDecorator {
    public static final Integer DEFAULT_DANIO = 1;
    public static final String DEFAULT_DESCRIPTION = "Lingote de Cobre";
    public LingoteCobreComponentDecorator(GalardonComponent galardonComponent){
        super(DEFAULT_DESCRIPTION, DEFAULT_DANIO, galardonComponent);
    }

}
