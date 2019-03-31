package com.sebastianperez.tennisgame.gamerules;
import com.sebastianperez.tennisgame.dto.Game;

import java.util.ArrayList;
import java.util.List;

public class GameRulesImpls {

    private static List<IGameRule> gameRules;

    public static void validateGameRules(Game game) {
       build();
       gameRules.forEach(rule ->  rule.validatePoints(game));
    }

    private static void build() {
        if (null == gameRules || gameRules.isEmpty()) {
            gameRules = new ArrayList<>();
            gameRules.add(new NormalScoreRule());
            gameRules.add(new StateScoreRule());
        }
    }
}
