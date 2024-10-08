package com.game.player.strategy;

import com.game.enemy.enemyfactory.Enemy;
import com.game.player.player.Player;

public interface PlayerStrategy {
    public void perform(Player player, Enemy enemy);
}
