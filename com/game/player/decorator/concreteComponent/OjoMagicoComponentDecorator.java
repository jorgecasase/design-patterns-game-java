package com.game.player.decorator.concreteComponent;

import com.game.player.decorator.GalardonComponent;

public class OjoMagicoComponentDecorator extends AbstractGalardonComponentDecorator {
    public static final Integer DEFAULT_DANIO = 2;
    public static final String DEFAULT_DESCRIPTION = "Ojo mágico";
    public OjoMagicoComponentDecorator(GalardonComponent galardonComponent){
        super(DEFAULT_DESCRIPTION, DEFAULT_DANIO, galardonComponent);
    }
}
