package com.game.player.strategy;

import com.game.enemy.enemyfactory.Enemy;
import com.game.player.player.Player;
import com.game.randomLogs.RandomLogs;

public class CurarsePlayerStrategy implements PlayerStrategy {
    public void perform(Player player, Enemy enemy){
        if((player.getVida() + player.getCuracion()) > 100){
            player.setVida(100);
        }
        else{
            player.setVida(player.getVida() + player.getCuracion());
        }
        System.out.println("- " + player.getNombre() + ": " + RandomLogs.getInstance().getCurarseDialogue());
        System.out.println("(i) Player " + player.getNombre() + " se ha curado  " + (100 - player.getCuracion()) + " puntos de vida ["+player.getNombre()+ " " + player.getVida() + " vida]");
    }
}
