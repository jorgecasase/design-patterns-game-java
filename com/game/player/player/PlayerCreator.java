package com.game.player.player;

import java.util.Scanner;

public class PlayerCreator {
    private Player player;
    public PlayerCreator(){
    }
    public void createPlayer(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de su personaje: ");
        this.player = new Player(scanner.nextLine());
    }
    public void setStats(){
        Scanner scanner = new Scanner(System.in);
        Integer opcion;
        do{
            System.out.println("--- Escoja las estadísticas de su personaje ---");
            System.out.println("1 - Preset fácil\n2 - Preset medio\n3 - Preset difícil\n4 - Custom");
            opcion = scanner.nextInt();
        }while(opcion < 1 || opcion > 4);
        switch(opcion){
            case 1:{
                player.setStats(90, 60, 60, 40);
                break;
            }
            case 2:{
                player.setStats(60, 40,40,40);
                break;
            }
            case 3:{
                player.setStats(30, 30, 20, 30);
                break;
            }
            case 4:{
                player = this.getCustomStats();
                break;
            }
        }
    }
    public Player getPlayer(){
        return this.player;
    }
    private Player getCustomStats(){
        System.out.println("Ingresar estadísitcas de personaje (0-100)");
        Scanner scanner = new Scanner(System.in);
        Integer fuerza, agilidad, resistencia, curacion;
        do{
            System.out.println("Ingrese fuerza (daño): ");
            fuerza = scanner.nextInt();
            System.out.println("Ingrese agilidad: (% de esquivar ataque): ");
            agilidad = scanner.nextInt();
            System.out.println("Ingrese resistencia (factor de resistencia a golpes): ");
            resistencia = scanner.nextInt();
            System.out.println("Ingrese curación (vida que te curas): ");
            curacion = scanner.nextInt();

            if((fuerza < 0 || fuerza > 100) || (agilidad < 0 || agilidad > 100) || (resistencia < 0 || resistencia > 100) || (curacion < 0 ||curacion > 100)){
                System.out.println("Error: algún valor fuera de lo permitido");
            }
        } while((fuerza < 0 || fuerza > 100) || (agilidad < 0 || agilidad > 100) || (resistencia < 0 || resistencia > 100) || (curacion < 0 ||curacion > 100));
        player.setStats(fuerza,agilidad,resistencia,curacion);
        return player;
    }
}
