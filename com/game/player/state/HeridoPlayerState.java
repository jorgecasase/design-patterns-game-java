package com.game.player.state;

import com.game.player.player.Player;

public class HeridoPlayerState implements PlayerState {
    private Player player;
    private Integer danio = -5;
    public HeridoPlayerState(Player player){
        this.player = player;
    }
    public void refreshState(){
        if(player.getVida() > 33){
            player.setPlayerState(player.getSanoPlayerState());
        }
    }
    public String soutPlayerState(){
        return player.getNombre() + " está en estado herido (-" + danio + " daño)";
    }
    public Integer getDanio(){
        return this.danio;
    }
}
