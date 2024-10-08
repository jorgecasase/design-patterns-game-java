package com.game.game;

import com.game.player.player.PlayerCreator;

public class GameControllerFacade {
    private PlayerCreator playerCreator;
    private CreadorEnfrentamientosSystem creadorEnfrentamientosSystem;
    public GameControllerFacade(){
        playerCreator = new PlayerCreator();
        creadorEnfrentamientosSystem = new CreadorEnfrentamientosSystem();
    }
    public void setupGame(){
        this.playerCreator.createPlayer();
        this.playerCreator.setStats();
        this.creadorEnfrentamientosSystem.setPlayer(playerCreator.getPlayer());
    }
    public void playStoryGame(){
        while(creadorEnfrentamientosSystem.getPlayer().getVida() > 0 && creadorEnfrentamientosSystem.getRondas() <= 6){
            creadorEnfrentamientosSystem.generarEnfrentamiento();
        }
        if(creadorEnfrentamientosSystem.getRondas() > 6){
            System.out.println("ENHORABUENA, GANASTE EL JUEGO!!");
        }
    }
    public void playInfiniteGame(){
        while(creadorEnfrentamientosSystem.getPlayer().getVida() > 0){
            creadorEnfrentamientosSystem.generarEnfrentamientoRandom();
        }
    }
}
