package com.game.player.state;

import com.game.player.player.Player;

public class PoderosoPlayerState implements PlayerState {
    private Player player;
    private Integer danio = 3;
    public PoderosoPlayerState(Player player){
        this.player = player;
    }
    public void refreshState(){
        if(player.getVida() < 66 || player.getFuerza() < 85){
            player.setPlayerState(player.getSanoPlayerState());
        }
    }
    public String soutPlayerState(){
        return player.getNombre() + " está en estado poderoso (+"+danio+" daño)";
    }
    public Integer getDanio(){
        return this.danio;
    }

}
