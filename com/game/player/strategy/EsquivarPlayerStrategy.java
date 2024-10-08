package com.game.player.strategy;

import com.game.enemy.enemyfactory.Enemy;
import com.game.player.player.Player;
import com.game.randomLogs.RandomLogs;

public class EsquivarPlayerStrategy implements PlayerStrategy {
    public void perform(Player player, Enemy enemy){
        Double random = Math.random();
        if(random < ((float) player.getAgilidad() / 100f)){
            player.setEsquivar(true);
            System.out.println("- " + player.getNombre() + ": " + RandomLogs.getInstance().getEsquivarDialogue());
            System.out.println("(i) Esquivar exitoso, esquivarás el próximo ataque de tu oponente");
        }
        else{
            System.out.println("- " + player.getNombre() + ": " + RandomLogs.getInstance().getNoEsquivarDialogue());
            System.out.println("(i) Esquivar fallido, perdiste el turno sin ningún efecto sobre tu oponente");
        }
    }
}
