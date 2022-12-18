package hu.Progtech.FoxAndHounds.Service.Command;

import hu.Progtech.FoxAndHounds.Model.GameState;
import hu.Progtech.FoxAndHounds.Service.Exception.ExitException;
import hu.Progtech.FoxAndHounds.Service.Exception.MapBuildingException;
import hu.Progtech.FoxAndHounds.Service.RandomHound.RandomHound;

public class GameCommands {

    private String command;
    private GameState gameState;
    private String[] splitCommand;

    public GameCommands(String command, GameState gameState) {
        this.command = command;
        this.gameState = gameState;
    }

    public String[] splitCommand() {
        splitCommand = command.split(" ");
        return splitCommand;
    }

    public GameState checkCommand() throws MapBuildingException, ExitException {
        String[] splitedCommand = splitCommand();
        switch (splitedCommand[0]) {
            case "start":
                return gameState = new StartCommand().startGame();
            case "step":
                if (splitedCommand.length == 3) {
                    int[] beforeStep = gameState.getFox();
                    gameState = new StepCommand(gameState, splitedCommand[1], splitedCommand[2]).stepGame();
                    if (beforeStep[0] != gameState.getFox()[0] && beforeStep[1] != gameState.getFox()[1]) {
                        gameState = new RandomHound(gameState).randomHound();
                    }
                    return gameState;
                }
                else {
                    System.out.println("Wrong step command!");
                    return gameState;
                }
            case "exit":
                return gameState = new ExitCommand(gameState).exitGame();
            default:
                System.out.println("Unknown command " + splitedCommand[0]);
                return gameState;
        }
    }

}