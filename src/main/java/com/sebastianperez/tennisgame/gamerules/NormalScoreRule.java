package com.sebastianperez.tennisgame.gamerules;

import com.sebastianperez.tennisgame.dto.Game;

import java.util.List;

public class NormalScoreRule extends GameRuleBase implements IGameRule {

    @Override
    public void validatePoints(Game game) {
       if (game.getPlayers().stream().allMatch(p -> p.getPoints() <= limitPoint)) {
          List<Short> points = getPlayersScore(game.getPlayers());
          registerScoreBoard(points.get(0), points.get(1));
       }
    }
}
