package hu.Progtech.FoxAndHounds;

import java.sql.SQLException;
import java.util.Scanner;

import hu.Progtech.FoxAndHounds.Model.GameState;
import hu.Progtech.FoxAndHounds.Service.Command.GameCommands;
import hu.Progtech.FoxAndHounds.Service.Exception.ExitException;
import hu.Progtech.FoxAndHounds.Service.Exception.MapBuildingException;
import hu.Progtech.FoxAndHounds.Service.Players.Players;
import hu.Progtech.FoxAndHounds.Service.Validator.Validator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) throws MapBuildingException, ExitException, SQLException {
        ApplicationContext applicationContext;
        applicationContext = new AnnotationConfigApplicationContext("hu.Progtech.FoxAndHounds");
        String inCommand = "";
        String username = "";
        Scanner input = new Scanner(System.in);
        System.out.print("Username: ");
        username = input.nextLine();
        int score = new Players(username).playerScore();
        new Players().showHighScore();
        GameState gameState = applicationContext.getBean(GameState.class);
        boolean win = false;
        boolean lose = false;
        while (gameState.isPlayerDontWantToExit() && !win && !lose) {
            System.out.print("?: ");
            inCommand = input.nextLine();
            gameState = new GameCommands(inCommand, gameState).checkCommand();
            if (gameState.isPlayerDontWantToExit()) {
                System.out.println(username + "\t" + score);
                System.out.println(gameState.getMapVO().toString());
                win = new Validator(gameState).didYouWin();
                if (win) {
                    System.out.println("You Won!");
                    score = new Players(username).updateScore();
                    System.out.println("+" + score + " score saved!");
                }
                lose = new Validator(gameState).didYouLose();
                if (lose) {
                    System.out.println("You Lost!");
                }
            }
        }
    }
}
