package com.game.player.player;

import com.game.enemy.enemyfactory.Enemy;
import com.game.player.decorator.GalardonComponent;
import com.game.player.decorator.baseComponent.InsigniaLuchador;
import com.game.player.state.HeridoPlayerState;
import com.game.player.state.PlayerState;
import com.game.player.state.PoderosoPlayerState;
import com.game.player.state.SanoPlayerState;
import com.game.player.strategy.PlayerStrategy;

public class Player {
    private final String nombre;
    private Integer vida;

    // estadísticas de combate
    private Integer fuerza; // ataque
    private Integer agilidad; // esquivar
    private Integer resistencia; // aguante de ataques
    private Integer curacion; // curacion

    // State pattern
    private PlayerState playerState;
    private SanoPlayerState sanoPlayerState;
    private HeridoPlayerState heridoPlayerState;
    private PoderosoPlayerState poderosoPlayerState;

    // Strategy pattern
    private PlayerStrategy playerStrategy;
    private boolean esquivar = false;

    // Decorator pattern
    private GalardonComponent galardonComponent;

    // player methods
    public Player(String nombre){

        // player
        this.nombre = nombre;
        this.vida = 100;

        // state
        this.sanoPlayerState = new SanoPlayerState(this);
        this.poderosoPlayerState = new PoderosoPlayerState(this);
        this.heridoPlayerState = new HeridoPlayerState(this);
        this.playerState = sanoPlayerState; // estado por defecto

        // decorator
        this.galardonComponent = new InsigniaLuchador();
    }
    public void setStats(Integer fuerza, Integer agilidad, Integer resistencia, Integer curacion){
        this.fuerza = fuerza;
        this.agilidad = agilidad;
        this.resistencia = resistencia;
        this.curacion = curacion;
        this.refreshState();
    }
    public Integer getVida(){
        return this.vida;
    }
    public Integer getResistencia(){
        return this.resistencia;
    }
    public boolean getEsquivar(){
        return this.esquivar;
    }
    public void setEsquivar(boolean esquivar){
        this.esquivar = esquivar;
    }
    public Integer getCuracion(){
        return this.curacion;
    }
    public String getNombre(){
        return this.nombre;
    }
    public Integer getFuerza(){
        return this.fuerza;
    }
    public Integer getAgilidad(){
        return this.agilidad;
    }
    public void setVida(Integer vida){
        this.vida = vida;
    }
    public void mostrarOpciones(){
        System.out.println("----- MENU OPCIONES -----\n1 - atacar ("+this.fuerza+" daño)\n2 - intentar esquivar siguiente ataque ("+this.agilidad+"% posibilidades)\n3 - curarte ("+this.curacion+") vida");
    }
    public void recibirAtaque(Integer danio){
        if(this.vida - danio < 0){
            this.vida = 0;
        }
        else{
            this.vida -= danio;
        }
        this.refreshState();
    }
    public void setFuerza(Integer fuerza){
        this.fuerza = fuerza;
    }
    public void setAgilidad(Integer agilidad){
        this.agilidad = agilidad;
    }
    public void setResistencia(Integer resistencia){
        this.resistencia = resistencia;
    }
    public void setCuracion(Integer curacion){
        this.curacion = curacion;
    }


    // state pattern
    public PlayerState getPlayerState(){
        return this.playerState;
    }
    public void refreshState(){
        this.playerState.refreshState();
    }
    public PlayerState getSanoPlayerState(){
        return this.sanoPlayerState;
    }
    public PlayerState getHeridoPlayerState(){
        return this.heridoPlayerState;
    }
    public PlayerState getPoderosoPlayerState(){
        return this.poderosoPlayerState;
    }
    public void setPlayerState(PlayerState playerState){
        this.playerState = playerState;
    }

    // strategy methods
    public void setPlayerStrategy(PlayerStrategy playerStrategy){
        this.playerStrategy = playerStrategy;
    }
    public void perform(Enemy enemy){
        this.playerStrategy.perform(this, enemy);
    }

    // decorator methods
    public GalardonComponent getGalardonComponent(){
        return this.galardonComponent;
    }
    public void setGalardonComponent(GalardonComponent galardonComponent){
        this.galardonComponent = galardonComponent;
    }
    // object methods
    @Override
    public String toString(){
        return "Player " + nombre +"[vida: " + vida + ", fuerza: "+ fuerza + ", agilidad: " + agilidad + ", resistencia: " + resistencia + ", curación: " + curacion +"]";
    }
}
