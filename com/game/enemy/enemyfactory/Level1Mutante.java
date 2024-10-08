package com.game.enemy.enemyfactory;

import com.game.enemy.strategy.AtacarEnemyStrategy;
import com.game.enemy.strategy.CurarseEnemyStrategy;
import com.game.enemy.strategy.EsquivarEnemyStrategy;

public class Level1Mutante extends AbstractMutante{
    public Level1Mutante(Integer vida, Integer fuerza, Integer agilidad, Integer resistencia, Integer curacion, String mutacion){
        super("Mutante de nivel 1", vida, fuerza, agilidad, resistencia, curacion, mutacion);
    }
    @Override
    public void selectStrategy(){
        Double random = Math.random();
        if(random < 0.3){
            super.setEnemyStrategy(new EsquivarEnemyStrategy());
        }
        else{
            super.setEnemyStrategy(new AtacarEnemyStrategy());
        }
    }
}
