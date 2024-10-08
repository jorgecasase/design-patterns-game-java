package com.game.enemy.strategy;

import com.game.enemy.enemyfactory.Enemy;
import com.game.player.player.Player;
import com.game.randomLogs.RandomLogs;

public class AtacarEnemyStrategy implements EnemyStrategy{
    public void perform(Enemy enemy, Player player){
        if(player.getEsquivar()){
            System.out.println("(i) El ataque de " + enemy.getNombre() + " ha fallado");
            player.setEsquivar(false);
        }
        else{
            Integer danio = Math.round((float)enemy.getFuerza() - (float)(enemy.getFuerza() * ((float)player.getResistencia() / 100f)));
            if(danio > 100){
                danio = 100;
            }

            player.recibirAtaque(danio);
            System.out.println("- " + enemy.getNombre() + ": " + RandomLogs.getInstance().getAtaqueDialogue());
            System.out.println("(i) " + enemy.getNombre() + " ha atacado a " + player.getNombre() + " y le ha hecho " + danio + " de daño ["+enemy.getNombre()+ " " + enemy.getFuerza() + " fuerza, " + player.getNombre() + " " + player.getResistencia() + " resistencia]");
        }
    }
}
