package com.game.enemy.enemyfactory;

public class Level1AbstractFactory implements EnemyAbstractFactory{
    public Enemy CreateGuerrero() {
        return new Level1Guerrero(60, 30, 20, 40, 10, "Armadura de cobre");
    }
    public Enemy CreateHechicero() {
        return new Level1Hechicero(70, 20, 50, 20, 90, "Mal de ojo");
    }
    public Enemy CreateMutante() {
        return new Level1Mutante(70, 30, 10, 60, 10, "Mutacion de fuerza");
    }
}
