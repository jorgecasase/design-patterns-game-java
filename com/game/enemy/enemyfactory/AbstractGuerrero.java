package com.game.enemy.enemyfactory;

import com.game.enemy.strategy.EnemyStrategy;
import com.game.player.player.Player;

public abstract class AbstractGuerrero implements Guerrero {
    protected String nombre;
    protected Integer vida;
    protected Integer fuerza;
    protected Integer agilidad;
    protected Integer resistencia;
    protected Integer curacion;
    protected String nombreArmadura;
    protected boolean esquivar = false;
    protected EnemyStrategy enemyStrategy;
    public AbstractGuerrero(String nombre, Integer vida, Integer fuerza, Integer agilidad, Integer resistencia, Integer curacion, String nombreArmadura){
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.resistencia = resistencia;
        this.curacion = curacion;
        this.nombreArmadura = nombreArmadura;
    }

    public String getNombre(){
        return this.nombre;
    }
    public Integer getVida(){
        return this.vida;
    }
    public Integer getFuerza(){
        return this.fuerza;
    }
    public Integer getResistencia(){
        return this.resistencia;
    }
    public Integer getAgilidad(){
        return this.agilidad;
    }
    public Integer getCuracion(){
        return this.curacion;
    }
    public void setVida(Integer vida){
        this.vida = vida;
    }
    public boolean getEsquivar(){
        return this.esquivar;
    }
    public void setEsquivar(boolean esquivar){
        this.esquivar = esquivar;
    }
    public void recibirAtaque(Integer danio){
        if(this.vida - danio < 0){
            this.vida = 0;
        }
        else {
            this.vida = vida - danio;
        }
    }
    // template + strategy
    public void templatePerform(Player player){
        this.selectStrategy();
        this.perform(player);
    }
    public void selectStrategy(){
    }
    public void perform(Player player){
        this.enemyStrategy.perform(this, player);
    }
    public void setEnemyStrategy(EnemyStrategy enemyStrategy){
        this.enemyStrategy = enemyStrategy;
    }


    public String getNombreArmadura(){
        return this.nombreArmadura;
    }
    public String toString(){
        return "Enemy: " + this.nombre + " con " + this.nombreArmadura  + "[Vida: " + vida + ", fuerza: "+ fuerza + ", agilidad: " + agilidad + ", resistencia: " + resistencia + ", curación: " + curacion +"]";
    }
}
