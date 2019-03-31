package com.sebastianperez.tennisgame.gamerules;

import com.sebastianperez.tennisgame.dto.Game;

@FunctionalInterface
public interface IGameRule {
    void validatePoints(Game game);
}
