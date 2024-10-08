package com.game.enemy.enemyfactory;

public class EnemyFactoryManager {
    private Level1AbstractFactory level1AbstractFactory;
    private Level2AbstractFactory level2AbstractFactory;

    public EnemyFactoryManager(){
        this.level1AbstractFactory = new Level1AbstractFactory();
        this.level2AbstractFactory = new Level2AbstractFactory();
    }
    public Enemy CreateLevel1Guerrero(){
        return this.level1AbstractFactory.CreateGuerrero();
    }
    public Enemy CreateLevel1Hechicero(){
        return this.level1AbstractFactory.CreateHechicero();
    }
    public Enemy CreateLevel1Mutante(){
        return this.level1AbstractFactory.CreateMutante();
    }
    public Enemy CreateLevel2Guerrrero(){
        return this.level2AbstractFactory.CreateGuerrero();
    }
    public Enemy CreateLevel2Hechicero(){
        return this.level2AbstractFactory.CreateHechicero();
    }
    public Enemy CreateLevel2Mutante(){
        return this.level2AbstractFactory.CreateMutante();
    }


}
