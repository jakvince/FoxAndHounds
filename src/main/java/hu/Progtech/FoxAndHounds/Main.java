package hu.Progtech.FoxAndHounds;

import java.util.Scanner;

import hu.Progtech.FoxAndHounds.Model.GameState;
import hu.Progtech.FoxAndHounds.Service.Command.GameCommands;
import hu.Progtech.FoxAndHounds.Service.Exception.ExitException;
import hu.Progtech.FoxAndHounds.Service.Exception.MapBuildingException;
import hu.Progtech.FoxAndHounds.Service.Validator.Validator;

public class Main {

    public static void main(String[] args) throws MapBuildingException, ExitException {
        String inCommand = "";
        Scanner input = new Scanner(System.in);
        GameState gameState = new GameState(null, false, true, null, null);
        boolean win = false;
        boolean lose = false;
        while (gameState.isPlayerDontWantToExit() && !win && !lose) {
            System.out.print("?: ");
            inCommand = input.nextLine();
            gameState = new GameCommands(inCommand, gameState).checkCommand();
            if (gameState.isPlayerDontWantToExit()) {
                System.out.println(gameState.getMapVO().toString());
                win = new Validator(gameState).didYouWin();
                if (win) {
                    System.out.println("You Won!");
                }
                lose = new Validator(gameState).didYouLose();
                if (lose) {
                    System.out.println("You Lost!");
                }
            }
        }
    }
}
