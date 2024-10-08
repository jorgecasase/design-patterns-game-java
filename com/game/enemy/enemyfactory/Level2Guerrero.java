package com.game.enemy.enemyfactory;

import com.game.enemy.strategy.AtacarEnemyStrategy;
import com.game.enemy.strategy.CurarseEnemyStrategy;
import com.game.enemy.strategy.EsquivarEnemyStrategy;

public class Level2Guerrero extends AbstractGuerrero {
    public Level2Guerrero(Integer vida, Integer fuerza, Integer agilidad, Integer resistencia, Integer curacion, String nombreArmadura){
        super("Guerrero de nivel 2", vida, fuerza, agilidad, resistencia, curacion, nombreArmadura);
    }
    @Override
    public void selectStrategy(){
        Double random = Math.random();
        if(random < 0.1){
            super.setEnemyStrategy(new CurarseEnemyStrategy());
        }
        else if(random < 0.4){
            super.setEnemyStrategy(new EsquivarEnemyStrategy());
        }
        else{
            super.setEnemyStrategy(new AtacarEnemyStrategy());
        }
    }
}
