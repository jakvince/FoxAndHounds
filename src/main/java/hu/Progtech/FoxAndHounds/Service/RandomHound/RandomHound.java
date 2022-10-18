package hu.Progtech.FoxAndHounds.Service.RandomHound;

import hu.Progtech.FoxAndHounds.Model.GameState;

public class RandomHound {

    private GameState gameState;

    public RandomHound(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState randomHound() {
        int size = gameState.getMapVO().getMapSize();
        int[][] hound = gameState.getHounds();
        char[][] map = gameState.getMapVO().getMap();
        int houndNumber = 0;
        int randomStep = 0;
        boolean wrong;
        do {
            wrong = false;
            if (hound[houndNumber][0] != size - 1) {
                if (hound[houndNumber][1] == 0) {
                    if (map[hound[houndNumber][0] + 1][hound[houndNumber][1] + 1] == '_') {
                        randomStep = 1;
                    } else {
                        wrong = true;
                    }
                } else if (hound[houndNumber][1] == size - 1) {
                    if (map[hound[houndNumber][0] + 1][hound[houndNumber][1] - 1] == '_') {
                        randomStep = 0;
                    } else {
                        wrong = true;
                    }
                } else if (map[hound[houndNumber][0] + 1][hound[houndNumber][1] + 1] == '_') {
                    randomStep = 1;
                } else if (map[hound[houndNumber][0] + 1][hound[houndNumber][1] - 1] == '_') {
                    randomStep = 0;
                } else {
                    wrong = true;
                }
            } else {
                wrong = true;
            }
            if (wrong) {
                houndNumber += 1;
            }
        } while (wrong && houndNumber < size / 2);

        if (houndNumber < size / 2) {
            switch (randomStep) {
                case 0:
                    map[hound[houndNumber][0]][hound[houndNumber][1]] = '_';
                    hound[houndNumber][0] += 1;
                    hound[houndNumber][1] -= 1;
                    map[hound[houndNumber][0]][hound[houndNumber][1]] = 'H';
                    gameState.getMapVO().setMap(map);
                    gameState.setHounds(hound);
                    return gameState;
                case 1:
                    map[hound[houndNumber][0]][hound[houndNumber][1]] = '_';
                    hound[houndNumber][0] += 1;
                    hound[houndNumber][1] += 1;
                    map[hound[houndNumber][0]][hound[houndNumber][1]] = 'H';
                    gameState.getMapVO().setMap(map);
                    gameState.setHounds(hound);
                    return gameState;
                default:
                    return gameState;
            }
        } else {
            return gameState;
        }
    }
}