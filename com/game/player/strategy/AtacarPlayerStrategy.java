package com.game.player.strategy;

import com.game.enemy.enemyfactory.Enemy;
import com.game.player.player.Player;
import com.game.randomLogs.RandomLogs;

public class AtacarPlayerStrategy implements PlayerStrategy {
    public void perform(Player player, Enemy enemy){
        if(enemy.getEsquivar()){
            System.out.println("(i) tu ataque ha fallado porque el enemigo hizo esquive");
            enemy.setEsquivar(false);
        }
        else{
            Integer danio = Math.round(((float)player.getFuerza() - (float)(player.getFuerza() * ((float)enemy.getResistencia() / 100f)))+ player.getGalardonComponent().getDanio() + player.getPlayerState().getDanio());
            if(danio > 100){
                danio = 100;
            }
            enemy.recibirAtaque(danio);
            System.out.println("- " + player.getNombre() + ": " + RandomLogs.getInstance().getAtaqueDialogue());
            System.out.println("(i) Player " + player.getNombre() + " ha atacado a " + enemy.getNombre() + " con ["+player.getGalardonComponent().getDescripcion()+ "] y le ha hecho " + danio + " de daño ["+player.getNombre()+ ": " + player.getFuerza() + " fuerza + "+ player.getGalardonComponent().getDanio()+" daño de " + player.getGalardonComponent().getNumGalardones() + " galardones + " +player.getPlayerState().getDanio() + " por su estado, " + enemy.getNombre() + ": " + enemy.getResistencia() + " resistencia]");
        }
    }
}
