package com.sebastianperez.tennisgame.memento;

import com.sebastianperez.tennisgame.dto.Game;
import com.sebastianperez.tennisgame.dto.GameRecord;

import java.util.ArrayList;
import java.util.List;

public class MementoGame {
    private static MementoGame ourInstance = new MementoGame();

    private List<GameRecord> gameRecords;

    private MementoGame() {
        gameRecords = new ArrayList<>();
    }

    public static void save(Game game){
        ourInstance.gameRecords.add(createGameRecord(game));
    }

    private static GameRecord createGameRecord(Game game) {
        GameRecord gameRecord = new GameRecord(game);
        return gameRecord;
    }

    public static List<GameRecord> getRecords(){
        return ourInstance.gameRecords;
    }
}
