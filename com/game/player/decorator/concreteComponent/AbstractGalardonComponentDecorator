package com.game.player.decorator.concreteComponent;

import com.game.player.decorator.GalardonComponent;
import com.game.player.decorator.GalardonComponentDecorator;

public abstract class AbstractGalardonComponentDecorator implements GalardonComponentDecorator {
    protected GalardonComponent galardonComponent;
    protected String descripcion;
    protected Integer danio;
    public AbstractGalardonComponentDecorator(String descripcion, Integer danio, GalardonComponent galardonComponent){
        this.descripcion = descripcion;
        this.danio = danio;
        this.galardonComponent = galardonComponent;
    }
    public GalardonComponent getGalardonComponent(){
        return this.galardonComponent;
    }
    public String getDescripcion(){
        return this.galardonComponent.getDescripcion() + " , " + this.descripcion + " (+" + this.danio +" daño)";
    }
    public Integer getDanio(){
        return this.galardonComponent.getDanio() + this.danio;
    }
    public Integer getNumGalardones(){
        return this.galardonComponent.getNumGalardones() + 1;
    }
}
