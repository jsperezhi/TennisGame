package com.sebastianperez.tennisgame.enumerable;

public enum EState {
    DEUCE("DEUCE"),
    ADVANTAGE("VENTAJA"),
    WINNER("GANADOR"),
    LOOSER("PERDEDOR");

    private String value;

    EState(String value){
        this.value = value;
    }

    public String get(){
        return this.value;
    }
}
