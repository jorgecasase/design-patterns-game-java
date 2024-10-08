package com.game.enemy.enemyfactory;

import com.game.enemy.strategy.EnemyStrategy;
import com.game.player.player.Player;

public abstract class AbstractMutante implements Mutante{
    protected String nombre;
    protected Integer vida;
    protected Integer fuerza;
    protected Integer agilidad;
    protected Integer resistencia;
    protected Integer curacion;
    protected String mutacion;
    protected EnemyStrategy enemyStrategy;
    protected boolean esquivar;
    public AbstractMutante(String nombre, Integer vida, Integer fuerza, Integer agilidad, Integer resistencia, Integer curacion, String mutacion){
        this.nombre = nombre;
        this.vida = vida;
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.resistencia = resistencia;
        this.curacion = curacion;
        this.mutacion = mutacion;
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
    public String getMutacion(){
        return this.mutacion;
    }
    public void recibirAtaque(Integer danio){
        if(this.vida - danio < 0){
            vida = 0;
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


    public String toString(){
        return "Enemy: " + this.nombre + " con " + this.mutacion + "[Vida: " + vida + ", fuerza: "+ fuerza + ", agilidad: " + agilidad + ", resistencia: " + resistencia + ", curación: " + curacion +"]";
    }
}
