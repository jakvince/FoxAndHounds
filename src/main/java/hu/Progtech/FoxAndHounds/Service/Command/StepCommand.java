package hu.Progtech.FoxAndHounds.Service.Command;

import hu.Progtech.FoxAndHounds.Model.GameState;
import hu.Progtech.FoxAndHounds.Model.MapVO;

public class StepCommand {

    private GameState gameState;
    private String upRoDownFox;
    private String rightRoLeftFox;

    public StepCommand(GameState gameState, String upRoDownFox, String rightRoLeftFox) {
        this.gameState = gameState;
        this.upRoDownFox = upRoDownFox;
        this.rightRoLeftFox = rightRoLeftFox;
    }

    public GameState stepGame() {
        char[][] map = gameState.getMapVO().getMap();
        MapVO mapVO = gameState.getMapVO();
        int[] fox = new int[2];
        fox[0] = gameState.getFox()[0];
        fox[1] = gameState.getFox()[1];
        switch (upRoDownFox) {
            case "up":
                switch (rightRoLeftFox) {
                    case "right":
                        if (gameState.getFox()[1] < gameState.getMapVO().getMapSize() - 1 && map[fox[0] - 1][fox[1] + 1] == '_') {
                            map[fox[0]][fox[1]] = '_';
                            fox[0] -= 1;
                            fox[1] += 1;
                            map[fox[0]][fox[1]] = 'F';
                            gameState.getMapVO().setMap(map);
                            gameState.setFox(fox);
                        }
                        return gameState;
                    case "left":
                        if (gameState.getFox()[1] > 0 && map[fox[0] - 1][fox[1] - 1] == '_') {
                            map[fox[0]][fox[1]] = '_';
                            fox[0] -= 1;
                            fox[1] -= 1;
                            map[fox[0]][fox[1]] = 'F';
                            gameState.getMapVO().setMap(map);
                            gameState.setFox(fox);
                        }
                        return gameState;
                    default:
                        return gameState;
                }
            case "down":
                if (gameState.getFox()[0] < gameState.getMapVO().getMapSize() - 1) {
                    switch (rightRoLeftFox) {
                        case "right":
                            if (gameState.getFox()[1] < gameState.getMapVO().getMapSize() - 1 && map[fox[0] + 1][fox[1] + 1] == '_') {
                                map[fox[0]][fox[1]] = '_';
                                fox[0] += 1;
                                fox[1] += 1;
                                map[fox[0]][fox[1]] = 'F';
                                gameState.getMapVO().setMap(map);
                                gameState.setFox(fox);
                            }
                            return gameState;
                        case "left":
                            if (gameState.getFox()[1] > 0 && map[fox[0] + 1][fox[1] - 1] == '_') {
                                map[fox[0]][fox[1]] = '_';
                                fox[0] += 1;
                                fox[1] -= 1;
                                map[fox[0]][fox[1]] = 'F';
                                gameState.getMapVO().setMap(map);
                                gameState.setFox(fox);
                            }
                            return gameState;
                        default:
                            return gameState;
                    }
                }
                break;
            default:
                break;
        }
        return gameState;
    }
}