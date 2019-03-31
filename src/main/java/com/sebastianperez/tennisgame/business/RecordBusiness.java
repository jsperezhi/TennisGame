package com.sebastianperez.tennisgame.business;

import com.sebastianperez.tennisgame.dto.Game;
import com.sebastianperez.tennisgame.memento.MementoGame;

public class RecordBusiness {

    public void save(Game game) {
        MementoGame.save(game);
    }

    public void showRecords() {
        MementoGame.getRecords().forEach(record -> {
            System.out.println("\n".concat(record.getDate().toString()));
            System.out.println(record.getGame().toString());
        });
        if (MementoGame.getRecords().isEmpty()) {
            System.out.println("Sin datos de juego");
        }
    }
}
