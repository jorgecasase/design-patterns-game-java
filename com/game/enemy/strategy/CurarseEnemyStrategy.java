package com.game.enemy.strategy;

import com.game.enemy.enemyfactory.Enemy;
import com.game.player.player.Player;
import com.game.randomLogs.RandomLogs;

public class CurarseEnemyStrategy implements EnemyStrategy {
    public void perform(Enemy enemy, Player player){
        if((enemy.getVida() + enemy.getCuracion()) > 100){
            enemy.setVida(100);
        }
        else{
            enemy.setVida(enemy.getVida() + enemy.getCuracion());
        }
        System.out.println("- " + enemy.getNombre() + ": " + RandomLogs.getInstance().getCurarseDialogue());
        System.out.println("(i) " + enemy.getNombre() + " se ha curado  " + (100 - enemy.getCuracion()) + " puntos de vida ["+enemy.getNombre()+ " " + enemy.getVida() + " vida");
    }
}
