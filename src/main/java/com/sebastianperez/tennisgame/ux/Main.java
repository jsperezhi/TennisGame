package com.sebastianperez.tennisgame.ux;

import com.sebastianperez.tennisgame.business.GameBusiness;
import com.sebastianperez.tennisgame.business.PlayerBusiness;
import com.sebastianperez.tennisgame.business.RecordBusiness;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        RecordBusiness recordBusiness = new RecordBusiness();
        PlayerBusiness playerBusiness = new PlayerBusiness();
        GameBusiness gameBusiness = new GameBusiness(playerBusiness);
        start(gameBusiness, recordBusiness);
    }

    private static void start(GameBusiness gameBusiness, RecordBusiness recordBusiness) {
        try {
            String option = "";
             while (!option.equals("0")) {
                 System.out.println("\n\n TENNIS GAME \n MENU \n\n 1. Jugar \n 2. Ver Resultados \n 0. Salir");
                 Scanner scanner = new Scanner(System.in);
                 option = scanner.nextLine();
                 executeMenu(option, gameBusiness, recordBusiness);
             }
        } catch (Exception tennisGameException) {
            System.out.println("Se ha detectado un error en la ejecución del juego");
            tennisGameException.printStackTrace();
        }
    }

    private static void executeMenu(String option, GameBusiness gameBusiness, RecordBusiness recordBusiness)
            throws Exception {
        switch (option) {
            case "1" : recordBusiness.save(gameBusiness.startGame());
            break;
            case "2" : recordBusiness.showRecords();
            break;
            case "0": System.out.println("Hasta la próxima");
            break;
            default: System.out.println("Opción no valida, por favor intente de nuevo");
        }
    }
}
