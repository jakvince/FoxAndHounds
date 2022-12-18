package hu.Progtech.FoxAndHounds.Service.Validator;

import  hu.Progtech.FoxAndHounds.Model.GameState;

public class Validator {
    private GameState gameState;
    private boolean win = false;
    private boolean lose = false;
    private int[] fox;
    private int[][] hound;
    private int size;
    private char[][] map;
    private int randomHound;
    private int randomStep;

    public Validator(GameState gameState) {
        this.gameState = gameState;
        this.fox = gameState.getFox();
        this.hound = gameState.getHounds();
        this.size = gameState.getMapVO().getMapSize();
        this.map = gameState.getMapVO().getMap();
    }

    public Validator(GameState gameState, int randomHound, int randomStep) {
        this.gameState = gameState;
        this.fox = gameState.getFox();
        this.hound = gameState.getHounds();
        this.size = gameState.getMapVO().getMapSize();
        this.map = gameState.getMapVO().getMap();
        this.randomHound = randomHound;
        this.randomStep = randomStep;
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

    public boolean fromLeftEdgeToRight() {
        if (hound[randomHound][0] != size - 1) {
            if (hound[randomHound][1] == 0) {
                if (map[hound[randomHound][0] + 1][hound[randomHound][1] + 1] == '_' && randomStep == 1) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean fromRightEdgeToLeft() {
        if (hound[randomHound][0] != size - 1) {
            if (hound[randomHound][1] == size - 1) {
                if (map[hound[randomHound][0] + 1][hound[randomHound][1] - 1] == '_' && randomStep == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean leftOrRight() {
        if (hound[randomHound][0] != size - 1) {
            if (hound[randomHound][1] != 0 && hound[randomHound][1] != size - 1) {
                if (randomStep == 0) {
                    if (map[hound[randomHound][0] + 1][hound[randomHound][1] - 1] == '_') {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    if (map[hound[randomHound][0] + 1][hound[randomHound][1] + 1] == '_') {
                        return true;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean houndCanStep() {
        if (fromLeftEdgeToRight() || fromRightEdgeToLeft() || leftOrRight()) {
            return true;
        } else {
            return false;
        }
    }
}
