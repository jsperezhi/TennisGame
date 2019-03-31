package com.sebastianperez.tennisgame.gamerules;

import com.sebastianperez.tennisgame.dto.Player;
import com.sebastianperez.tennisgame.enumerable.EPoints;
import com.sebastianperez.tennisgame.enumerable.EState;

import java.util.List;
import java.util.stream.Collectors;

public class GameRuleBase {

    private final static String SCORE_HEADER = "| MARCADOR |";
    private final static String LINE_BREAK = "\n";
    private final static String PIPE = " | ";
    private final static  String PLAYER_ONE = "Jugador #1 ";
    private final static  String PLAYER_TWO = "Jugador #2 ";
    protected short limitPoint = 3;

    protected List<Short> getPlayersScore(List<Player> players) {
        return players
                .stream()
                .map(Player::getPoints)
                .collect(Collectors.toList());
    }

    protected void registerScoreBoard(short playerOneScore, short playerTwoScore) {
        String scoreBoard = writeScoreBoard(showScore((int) playerOneScore), showScore((int) playerTwoScore));
        System.out.println(scoreBoard);
    }


    protected void registerStateScoreBoard(short playerOneScore, short playerTwoScore) {
        String statePlayerOne = getStateToPlayer(playerOneScore, playerTwoScore);
        String statePlayerTwo = getStateToPlayer(playerTwoScore, playerOneScore);
        String scoreBoard = writeScoreBoard(statePlayerOne, statePlayerTwo);
        System.out.println(scoreBoard);
    }

    private String getStateToPlayer(short scoreOne, short scoreTwo) {
        String state = "";
        int scoreLess = scoreOne - scoreTwo;
        if (scoreLess == 1) {
          state = EState.ADVANTAGE.get();
        } else if (scoreLess == 0) {
            state = EState.DEUCE.get();
        } else {
            state = EPoints.getInstance().get(3);
        }

        return state;
    }

    private String showScore(Integer playerScore) {
        return EPoints.getInstance().get(playerScore);
    }

    private String writeScoreBoard(String playerOneScore, String playerTwoScore) {
        return SCORE_HEADER
                .concat(LINE_BREAK)
                .concat(PLAYER_ONE)
                .concat(playerOneScore)
                .concat(PIPE)
                .concat(PLAYER_TWO)
                .concat(playerTwoScore);
    }
}
