package com.game.enemy.enemyfactory;

public class Level2AbstractFactory implements EnemyAbstractFactory{
    public Enemy CreateGuerrero() {
        return new Level2Guerrero(100, 25, 35, 30, 20, "Armadura de oro");
    }
    public Enemy CreateHechicero() {
        return new Level2Hechicero(100, 25, 20, 20, 90, "Mal de muchos ojos");
    }
    public Enemy CreateMutante() {
        return new Level2Mutante(100, 35, 20, 20, 20, "Mutacion de biceps");
    }
}
