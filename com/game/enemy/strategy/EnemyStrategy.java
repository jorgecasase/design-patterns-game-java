package com.game.enemy.strategy;

import com.game.enemy.enemyfactory.Enemy;
import com.game.player.player.Player;

public interface EnemyStrategy {
    public void perform(Enemy enemy, Player player);
}
