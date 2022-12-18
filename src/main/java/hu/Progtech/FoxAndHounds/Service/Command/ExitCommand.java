package hu.Progtech.FoxAndHounds.Service.Command;

import hu.Progtech.FoxAndHounds.Service.Exception.ExitException;
import hu.Progtech.FoxAndHounds.Model.GameState;
import org.springframework.stereotype.Component;

@Component
public class ExitCommand {

    private GameState gameState;

    public ExitCommand(GameState gameState) {
        this.gameState = gameState;
    }

    public GameState exitGame() throws ExitException {
        if (gameState.isMapExist()) {
            gameState.setPlayerDontWantToExit(false);
            return gameState;
        } else {
            throw new ExitException("ok bye :)");
        }
    }
}
