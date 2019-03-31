package com.sebastianperez.tennisgame.dto;

import java.util.Date;

public class GameRecord {
    private Game game;
    private Date date;

    public GameRecord(Game game) {
        this.game = game;
        this.date = new Date();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
