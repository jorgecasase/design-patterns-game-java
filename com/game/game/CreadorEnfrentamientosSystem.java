package com.game.game;

import com.game.enemy.enemyfactory.Enemy;
import com.game.enemy.enemyfactory.EnemyFactoryManager;
import com.game.player.decorator.concreteComponent.*;
import com.game.player.strategy.AtacarPlayerStrategy;
import com.game.player.player.Player;
import com.game.player.strategy.CurarsePlayerStrategy;
import com.game.player.strategy.EsquivarPlayerStrategy;
import com.game.randomLogs.RandomLogs;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class CreadorEnfrentamientosSystem {
    private Player player;
    private Enemy enemy;
    private Integer rondas = 1;
    private EnemyFactoryManager enemyFactoryManager;
    public Player getPlayer(){
        return this.player;
    }
    public CreadorEnfrentamientosSystem(){
        enemyFactoryManager = new EnemyFactoryManager();
    }
    public void setPlayer(Player player){
        this.player = player;
    }
    public void generarEnfrentamiento(){
        this.generarEnemy();
        this.presentarJugadores();
        System.out.println();

        Random random = new Random();
        boolean playerAtacaPrimero = random.nextBoolean();
        if(playerAtacaPrimero){
            RandomLogs.getInstance().logPlayerAtacaPrimero();
        }
        else{
            RandomLogs.getInstance().logEnemyAtacaPrimero();
        }

        while(player.getVida() > 0 && enemy.getVida() > 0){
            if(playerAtacaPrimero){
                playerTurn();
                enemyTurn();
            }
            else{
                playerTurn();
                enemyTurn();
            }
        }
        if(player.getVida() > 0){
            System.out.println("ENHORABHUENA, ganaste el " + rondas + " enfrentamiento !!!\n");
            this.ofrecerMejoras();
            player.refreshState();
            actualizarGalardones();
        }
        else{
            System.out.println("¡Qué lástima, perdiste la partida!");
        }
        rondas += 1;
    }
    public void generarEnfrentamientoRandom(){
        this.generarRandomEnemy();
        this.presentarJugadores();
        System.out.println();

        Random random = new Random();
        boolean playerAtacaPrimero = random.nextBoolean();
        if(playerAtacaPrimero){
            RandomLogs.getInstance().logPlayerAtacaPrimero();
        }
        else{
            RandomLogs.getInstance().logEnemyAtacaPrimero();
        }

        while(player.getVida() > 0 && enemy.getVida() > 0){
            if(playerAtacaPrimero){
                playerTurn();
                enemyTurn();
            }
            else{
                playerTurn();
                enemyTurn();
            }
        }
        if(player.getVida() > 0){
            System.out.println("ENHORABHUENA, ganaste el " + rondas + " enfrentamiento !!!\n");
            this.ofrecerMejoras();
            player.refreshState();
            actualizarGalardones();
        }
        else{
            System.out.println("¡Qué lástima, perdiste la partida!");
            System.out.println("Has aguantado " + rondas + " rondas!!");
        }
        rondas += 1;
    }
    private void playerTurn(){
        if(player.getVida() == 0){
        }
        else{
            this.player.mostrarOpciones();
            int opcion = getOpcion();
            switch(opcion){
                // atacar
                case 1: {
                    player.setPlayerStrategy(new AtacarPlayerStrategy());
                    player.perform(enemy);
                    break;
                }
                case 2: {
                    player.setPlayerStrategy(new EsquivarPlayerStrategy());
                    player.perform(enemy);
                    break;
                }
                case 3:{
                    player.setPlayerStrategy(new CurarsePlayerStrategy());
                    player.perform(enemy);
                    break;
                }
            }
            this.mostrarJugadores();
            System.out.println();
        }
    }
    private void enemyTurn(){
        if(enemy.getVida() == 0){
        }
        else{
            enemy.templatePerform(player);
            this.mostrarJugadores();
            System.out.println("");
        }
    }

    private static Integer getOpcion(){
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            try {
                opcion = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un número entero válido.");
                scanner.nextLine();
                opcion = -1;
            }
        } while (opcion < 0 || opcion > 3);
        return opcion;
    }
    private void generarEnemy(){
        switch(rondas) {
            case 1: {
                enemy = enemyFactoryManager.CreateLevel1Guerrero();
                break;
            }
            case 2: {
                enemy = enemyFactoryManager.CreateLevel1Hechicero();
                break;
            }
            case 3: {
                enemy = enemyFactoryManager.CreateLevel1Mutante();
                break;
            }
            case 4: {
                enemy = enemyFactoryManager.CreateLevel2Guerrrero();
                break;
            }
            case 5: {
                enemy = enemyFactoryManager.CreateLevel2Hechicero();
                break;
            }
            case 6: {
                enemy = enemyFactoryManager.CreateLevel2Mutante();
                break;
            }
        }

    }
    private void generarRandomEnemy() {
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        int numeroAleatorio = random.nextInt(6) + 1;
        switch (numeroAleatorio) {
            case 1: {
                enemy = enemyFactoryManager.CreateLevel1Guerrero();
                break;
            }
            case 2: {
                enemy = enemyFactoryManager.CreateLevel1Hechicero();
                break;
            }
            case 3: {
                enemy = enemyFactoryManager.CreateLevel1Mutante();
                break;
            }
            case 4: {
                enemy = enemyFactoryManager.CreateLevel2Guerrrero();
                break;
            }
            case 5: {
                enemy = enemyFactoryManager.CreateLevel2Hechicero();
                break;
            }
            case 6: {
                enemy = enemyFactoryManager.CreateLevel2Mutante();
                break;
            }
        }
    }
    private void presentarJugadores(){
        System.out.println("--- ENFRENTAMIENTO " + rondas + " ---");
        System.out.println(player.toString());
        System.out.println("vs");
        System.out.println(enemy.toString());
    }
    private void mostrarJugadores(){
        System.out.println("| " + player.getNombre() + ": " + player.getVida() + " vida, " + player.getPlayerState().soutPlayerState());

        System.out.println("| " + enemy.getNombre() + ": " + enemy.getVida() + " vida");
    }
    private void ofrecerMejoras(){
        Scanner scanner = new Scanner(System.in);
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        Integer fuerzaOfrecida = random.nextInt(5)+1;
        Integer agilidadOfrecida = random.nextInt(5)+1;
        Integer resistenciaOfrecida = random.nextInt(5)+1;
        Integer curacionOfrecida = random.nextInt(5)+1;
        Integer opcion;
        System.out.println("(i) elige un atributo para mejorar");
        System.out.println("| (1) +"+fuerzaOfrecida+" fuerza" );
        System.out.println("| (2) +"+agilidadOfrecida+" agilidad" );
        System.out.println("| (3) +"+resistenciaOfrecida+" resistencia" );
        System.out.println("| (4) +"+curacionOfrecida+" curacion" );
        do{
            opcion = scanner.nextInt();
        }while(opcion < 1 || opcion > 4);
        switch(opcion){
            case 1:{
                if(player.getFuerza() + fuerzaOfrecida > 100){
                    player.setFuerza(100);
                }
                else{
                    player.setFuerza(player.getFuerza() + fuerzaOfrecida);
                    System.out.println("(i) añadido " + fuerzaOfrecida + " de fuerza a tu personaje");
                }
                break;
            }
            case 2:{
                if(player.getAgilidad() + agilidadOfrecida > 100){
                    player.setAgilidad(100);
                }
                else{
                    player.setAgilidad(player.getAgilidad() + agilidadOfrecida);
                    System.out.println("(i) añadido " + agilidadOfrecida + " de agilidad a tu personaje");
                }
                break;
            }
            case 3:{
                if(player.getResistencia() + resistenciaOfrecida > 100){
                    player.setResistencia(100);
                }
                else{
                    player.setResistencia(player.getResistencia() + resistenciaOfrecida);
                    System.out.println("(i) añadido " + resistenciaOfrecida + " de resistencia a tu personaje");
                }
                break;
            }
            case 4:{
                if(player.getCuracion() + curacionOfrecida > 100){
                    player.setCuracion(100);
                }
                else{
                    player.setCuracion(player.getCuracion() + curacionOfrecida);
                    System.out.println("(i) añadido " + curacionOfrecida + " de curacion a tu personaje");
                }
                break;
            }
        }
    }
    public Integer getRondas(){
        return this.rondas;
    }
    private void actualizarGalardones(){
        switch(enemy.getClass().getSimpleName()){
            case "Level1Guerrero":{
                player.setGalardonComponent(new LingoteCobreComponentDecorator(player.getGalardonComponent()));
                break;
            }
            case "Level1Hechicero":{
                player.setGalardonComponent(new OjoMagicoComponentDecorator(player.getGalardonComponent()));
                break;
            }
            case "Level1Mutante":{
                player.setGalardonComponent(new BastonMutanteComponentDecorator(player.getGalardonComponent()));
                break;
            }
            case "Level2Guerrero":{
                player.setGalardonComponent(new LingoteOroComponentDecorator(player.getGalardonComponent()));
                break;
            }
            case "Level2Hechicero":{
                player.setGalardonComponent(new OjoEnvidiaComponentDecorator(player.getGalardonComponent()));
                break;
            }
            case "Level2Mutante":{
                player.setGalardonComponent(new GarraMutanteComponentDecorator(player.getGalardonComponent()));
                break;
            }
        }
    }
}
