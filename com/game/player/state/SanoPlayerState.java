package com.game.player.state;

import com.game.player.player.Player;

public class SanoPlayerState implements PlayerState {
    private Player player;
    private Integer danio = 0;
    public SanoPlayerState(Player player){
        this.player = player;
    }
    public void refreshState(){
        if(player.getVida() < 33){
            player.setPlayerState(player.getHeridoPlayerState());
        }
        else if(player.getVida() > 66 && player.getFuerza() > 85){
            player.setPlayerState(player.getPoderosoPlayerState());
        }
    }
    public String soutPlayerState(){
        return player.getNombre() + " está en estado sano";
    }
    public Integer getDanio(){
        return this.danio;
    }
}
