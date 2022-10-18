package hu.Progtech.FoxAndHounds.Service.Validator;

import  hu.Progtech.FoxAndHounds.Model.GameState;

public class Validator {
    private GameState gameState;
    private boolean win = false;
    private boolean lose = false;
    private int[] fox;
    private int size;
    private char[][] map;

    public Validator(GameState gameState) {
        this.gameState = gameState;
        this.fox = gameState.getFox();
        this.size = gameState.getMapVO().getMapSize();
        this.map = gameState.getMapVO().getMap();
    }

    public boolean didYouWin() {
        if (fox[0] == 0) {
            win = true;
        } else {
            win = false;
        }
        return win;
    }


    public boolean didYouLose() {
        if (fox[0] == size - 1 && fox[1] == 0) {
            if (map[fox[0] - 1][fox[1] + 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        } else if (fox[0] == 0 && fox[1] == size - 1) {
            lose = false;
        } else if (fox[0] == 0) {
            lose = false;
        } else if (fox[0] == size - 1) {
            if (map[fox[0] - 1][fox[1] - 1] == 'H' && map[fox[0] - 1][fox[1] + 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        } else if (fox[1] == 0) {
            if (map[fox[0] - 1][fox[1] + 1] == 'H' && map[fox[0] + 1][fox[1] + 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        } else if (fox[1] == size - 1) {
            if (map[fox[0] - 1][fox[1] - 1] == 'H' && map[fox[0] + 1][fox[1] - 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        } else {
            if (map[fox[0] - 1][fox[1] - 1] == 'H' && map[fox[0] + 1][fox[1] - 1] == 'H' &&
                    map[fox[0] - 1][fox[1] + 1] == 'H' && map[fox[0] + 1][fox[1] + 1] == 'H') {
                lose = true;
            } else {
                lose = false;
            }
        }
        return lose;
    }
}
