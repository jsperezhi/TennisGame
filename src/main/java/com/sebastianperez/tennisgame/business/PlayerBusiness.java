package com.sebastianperez.tennisgame.business;

import com.sebastianperez.tennisgame.dto.Game;
import com.sebastianperez.tennisgame.dto.Player;
import com.sebastianperez.tennisgame.enumerable.EConsoleColor;
import com.sebastianperez.tennisgame.exception.TennisGameException;

import java.util.List;
import java.util.Scanner;

public class PlayerBusiness {

    public Player registerPlayer(short number) {
        String playerName = getPlayerName(number);
        return new Player(number, playerName);
    }

    private String getPlayerName(short number) {
        System.out.println(EConsoleColor.ANSI_YELLOW.get()
                .concat("\n Ingrese nombre del jugador # ")
                .concat(String.valueOf(number))
        );
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();

        return playerName;
    }

    public Game registerPlayerScore(Game game) throws TennisGameException {
        short pointToPlayer = getSelectedPlayerGoal();
        Player player = getSelectedPlayer(game.getPlayers(), pointToPlayer);
        short points = (short) (player.getPoints() + 1);
        player.setPoints(points);
        registerPoint(player);
        return game;
    }

    private short getSelectedPlayerGoal() {
        return (short) Math.ceil(Math.random()*2);
    }

    private Player getSelectedPlayer(List<Player> players, short playerNumber) throws TennisGameException {
        return players
                .stream()
                .filter(p -> p.getNumber() == playerNumber)
                .findFirst()
                .orElseThrow(() -> new TennisGameException("El jugador seleccionado no existe"));
    }

    private void registerPoint(Player player) {
        System.out.println(
                "EL jugador # "
                        .concat(String.valueOf(player.getNumber()))
                        .concat(" ")
                        .concat(player.getName())
                        .concat(" ha anotado un punto.")
        );
    }

    public void registerWinner(Player player) {
        System.out.println("Juego terminado. \n Jugador #"
                .concat(String.valueOf(player.getNumber()))
                .concat(" ")
                .concat(player.getName())
                .concat(" ")
                .concat(player.getGameResult())
                .concat("\n FELICIDADES!!!!")
        );
    }
}
