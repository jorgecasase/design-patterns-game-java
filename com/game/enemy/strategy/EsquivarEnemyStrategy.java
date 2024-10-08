package com.game.enemy.strategy;

import com.game.enemy.enemyfactory.Enemy;
import com.game.player.player.Player;
import com.game.randomLogs.RandomLogs;

public class EsquivarEnemyStrategy implements EnemyStrategy {
    public void perform(Enemy enemy, Player player){
        Double random = Math.random();
        if(random < ((float) enemy.getAgilidad() / 100f)){
            enemy.setEsquivar(true);
            System.out.println("- " + enemy.getNombre() + ": " + RandomLogs.getInstance().getEsquivarDialogue());
            System.out.println("(i) " + enemy.getNombre() + "S esquivará el siguiente ataque con éxito");
        }
        else{
            System.out.println("- " + enemy.getNombre() + ": " + RandomLogs.getInstance().getNoEsquivarDialogue());
            System.out.println("(i) "+enemy.getNombre() + " ha fallado esquive, pierde su turno");
        }
    }
}
