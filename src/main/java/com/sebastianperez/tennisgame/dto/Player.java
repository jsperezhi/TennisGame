package com.sebastianperez.tennisgame.dto;

import com.sebastianperez.tennisgame.enumerable.EState;

public class Player {
    private short number;
    private String name;
    private short points;
    private String gameResult;

    public Player(short number, String name) {
        this.number = number;
        this.name = name;
        this.gameResult = EState.LOOSER.get();
    }


    public short getNumber() {
        return number;
    }

    public void setNumber(short number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getPoints() {
        return points;
    }

    public void setPoints(short points) {
        this.points = points;
    }

    public String getGameResult() {
        return gameResult;
    }

    public void setGameResult(String gameResult) {
        this.gameResult = gameResult;
    }

    @Override
    public String toString() {
        return "Player{" +
                "Jugador=" + number +
                ", Nombre='" + name + '\'' +
                ", puntos=" + points +
                ", Resultado='" + gameResult + '\'' +
                '}';
    }
}
