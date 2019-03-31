package com.sebastianperez.tennisgame.dto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private List<Player> players;

    private boolean inProgress;

    public Game(Player playerOne, Player playerTwo) {
        this.players = Arrays.asList(playerOne, playerTwo);
        this.inProgress = true;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public boolean isInProgress() {
        return inProgress;
    }

    public void setInProgress(boolean inProgress) {
        this.inProgress = inProgress;
    }

    @Override
    public String toString() {
        return players
                .stream()
                .map(Player::toString)
                .collect(Collectors.joining("\n"));
    }
}
