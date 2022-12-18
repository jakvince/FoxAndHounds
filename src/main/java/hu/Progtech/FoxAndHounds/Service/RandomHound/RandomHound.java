package hu.Progtech.FoxAndHounds.Service.RandomHound;

import java.util.Random;
import hu.Progtech.FoxAndHounds.Model.GameState;
import hu.Progtech.FoxAndHounds.Service.Validator.Validator;

public class RandomHound {

    private GameState gameState;
    private int randomHound;
    private int randomStep;
    private int max;
    private int size;

    public RandomHound(GameState gameState) {
        this.gameState = gameState;
        this.size = gameState.getMapVO().getMapSize();
    }

    public GameState randomHound() {
        int size = gameState.getMapVO().getMapSize();
        int[][] hound = gameState.getHounds();
        char[][] map = gameState.getMapVO().getMap();
        randomNumber();

        if (max < 30) {
            switch (randomStep) {
                case 0:
                    map[hound[randomHound][0]][hound[randomHound][1]] = '_';
                    hound[randomHound][0] += 1;
                    hound[randomHound][1] -= 1;
                    map[hound[randomHound][0]][hound[randomHound][1]] = 'H';
                    gameState.getMapVO().setMap(map);
                    gameState.setHounds(hound);
                    return gameState;
                case 1:
                    map[hound[randomHound][0]][hound[randomHound][1]] = '_';
                    hound[randomHound][0] += 1;
                    hound[randomHound][1] += 1;
                    map[hound[randomHound][0]][hound[randomHound][1]] = 'H';
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

    public void randomNumber() {
        Random rand = new Random();
        max = 0;
        do {
            randomHound = rand.nextInt(size / 2);
            randomStep = rand.nextInt(2);
            max++;
        } while (!new Validator(gameState, randomHound, randomStep).houndCanStep() && max < 30);
        if (max == 30) {
            System.out.println("Hounds can't step!");
        }
    }
}