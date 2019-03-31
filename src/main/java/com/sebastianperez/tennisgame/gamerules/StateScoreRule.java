package com.sebastianperez.tennisgame.gamerules;

import com.sebastianperez.tennisgame.dto.Game;

import java.util.List;

public class StateScoreRule extends GameRuleBase implements IGameRule {
    @Override
    public void validatePoints(Game game) {

        if (game.getPlayers().stream().anyMatch(p -> p.getPoints() > 3)) {
            List<Short> points = getPlayersScore(game.getPlayers());
            registerStateScoreBoard(points.get(0), points.get(1));
        }
    }

}
