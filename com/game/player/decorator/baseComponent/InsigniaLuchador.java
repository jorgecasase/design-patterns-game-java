package com.game.player.decorator.baseComponent;

import com.game.player.decorator.GalardonComponent;

public class InsigniaLuchador implements GalardonComponent {
    private Integer danio = 0;
    public String getDescripcion(){
        return "Insignia de luchador";
    }
    public Integer getDanio(){
        return danio;
    }
    public Integer getNumGalardones(){
        return 0;
    }
}
