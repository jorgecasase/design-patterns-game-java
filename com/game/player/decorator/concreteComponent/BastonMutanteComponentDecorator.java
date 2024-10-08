package com.game.player.decorator.concreteComponent;

import com.game.player.decorator.GalardonComponent;

public class BastonMutanteComponentDecorator extends AbstractGalardonComponentDecorator {
    public static final Integer DEFAULT_DANIO = 2;
    public static final String DEFAULT_DESCRIPTION = "Baston de Mutante";
    public BastonMutanteComponentDecorator(GalardonComponent galardonComponent){
        super(DEFAULT_DESCRIPTION, DEFAULT_DANIO, galardonComponent);
    }
}
