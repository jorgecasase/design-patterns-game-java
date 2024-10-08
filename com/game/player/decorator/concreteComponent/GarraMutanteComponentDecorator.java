package com.game.player.decorator.concreteComponent;

import com.game.player.decorator.GalardonComponent;

public class GarraMutanteComponentDecorator extends AbstractGalardonComponentDecorator {
    public static final Integer DEFAULT_DANIO = 4;
    public static final String DEFAULT_DESCRIPTION = "Garra Mutante";
    public GarraMutanteComponentDecorator(GalardonComponent galardonComponent){
        super(DEFAULT_DESCRIPTION, DEFAULT_DANIO, galardonComponent);
    }
}
