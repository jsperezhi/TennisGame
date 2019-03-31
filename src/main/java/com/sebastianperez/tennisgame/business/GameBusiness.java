package com.sebastianperez.tennisgame.business;

import com.sebastianperez.tennisgame.dto.Game;
import com.sebastianperez.tennisgame.dto.Player;
import com.sebastianperez.tennisgame.enumerable.EState;
import com.sebastianperez.tennisgame.exception.TennisGameException;
import com.sebastianperez.tennisgame.gamerules.GameRulesImpls;

import java.util.Comparator;

public class GameBusiness {

    private static final short PLAYER_ONE = 1;
    private static final short PLAYER_TWO = 2;
    private static int POINT_DIFFERENCE_TO_WIN = 2;
    private PlayerBusiness playerBusiness;

    public GameBusiness (PlayerBusiness playerBusiness) {
        this.playerBusiness = playerBusiness;
    }
    public Game startGame() throws Exception {
       Game game = registerGame();
       executeGame(game);
       return game;
    }

    private Game registerGame() {
      Player playerOne = registerPlayer(PLAYER_ONE);
      Player playerTwo = registerPlayer(PLAYER_TWO);

      Game game = new Game(playerOne, playerTwo);
      return game;
    }

    private Player registerPlayer(short number) {
     return playerBusiness.registerPlayer(number);
    }

    private void executeGame(Game game) throws Exception {
        while(game.isInProgress()) {
            watchGame(game);
        }
    }

    private void watchGame(Game game) throws Exception {
       registerGameScore(game);
       validateGameProgress(game);
       checkGameRules(game);
    }

    private void registerGameScore(Game game) throws TennisGameException {
       game = playerBusiness.registerPlayerScore(game);
    }

    private void validateGameProgress(Game game) {
        if (game.getPlayers().stream().anyMatch(p -> p.getPoints() > 3)) {
            game
            .getPlayers()
            .stream()
            .map(Player::getPoints)
            .map(p -> (int) p)
            .reduce((p1, p2) -> Math.abs(p1 - p2))
            .ifPresent(p -> selectToWinner(game, p));
        }
    }

    private void selectToWinner(Game game, int pointDifference) {
        if (pointDifference >= POINT_DIFFERENCE_TO_WIN) {
            game.setInProgress(false);
            game.getPlayers()
                    .stream()
                    .max(Comparator.comparingInt(p -> (int) p.getPoints()))
                    .ifPresent(p -> {
                        p.setGameResult(EState.WINNER.get());
                        playerBusiness.registerWinner(p);
                    });
        }
    }

    private void checkGameRules(Game game) {
        if (game.isInProgress()) {
            GameRulesImpls.validateGameRules(game);
        }
    }
}
