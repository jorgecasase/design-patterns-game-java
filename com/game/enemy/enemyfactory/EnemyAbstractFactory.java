package com.game.enemy.enemyfactory;

public interface EnemyAbstractFactory {
    public Enemy CreateGuerrero();
    public Enemy CreateHechicero();
    public Enemy CreateMutante();
}
