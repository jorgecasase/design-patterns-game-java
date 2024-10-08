package com.game.enemy.enemyfactory;

import com.game.enemy.strategy.AtacarEnemyStrategy;
import com.game.enemy.strategy.CurarseEnemyStrategy;
import com.game.enemy.strategy.EsquivarEnemyStrategy;

public class Level2Hechicero extends AbstractHechicero{
    public Level2Hechicero(Integer vida, Integer fuerza, Integer agilidad, Integer resistencia, Integer curacion, String nombreConjuro){
        super("Hechicero de nivel 2", vida, fuerza, agilidad, resistencia, curacion, nombreConjuro);
    }
    @Override
    public void selectStrategy(){
        Double random = Math.random();
        if(random < 0.3){
            super.setEnemyStrategy(new CurarseEnemyStrategy());
        }
        else if(random < 0.7){
            super.setEnemyStrategy(new EsquivarEnemyStrategy());
        }
        else{
            super.setEnemyStrategy(new AtacarEnemyStrategy());
        }
    }
}
