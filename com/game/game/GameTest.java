package com.game.game;

import java.util.Scanner;

public class GameTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        GameControllerFacade gameControllerFacade = new GameControllerFacade();
        gameControllerFacade.setupGame();
        
        System.out.println("--- FANTASY GAME ---\n1 - modo historia (6 enemigos escalando nivel)\n2 - modo supervivencia (hasta la muerte enemigos aleatorios)");
        do{
            opcion = scanner.nextInt();
        }while(opcion < 1 || opcion > 2);


        if(opcion == 1)
            gameControllerFacade.playStoryGame();
        if(opcion == 2)
            gameControllerFacade.playInfiniteGame();

        scanner.close();
    }
}
