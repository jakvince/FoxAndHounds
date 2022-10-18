package Service.Command;

import hu.Progtech.FoxAndHounds.Model.GameState;
import hu.Progtech.FoxAndHounds.Model.MapVO;
import hu.Progtech.FoxAndHounds.Service.Command.ExitCommand;
import hu.Progtech.FoxAndHounds.Service.Exception.ExitException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExitCommandTest {

    private ExitCommand underTest;

    private static char[][] map={
            {'X','H','X','H'},
            {'_','X','_','X'},
            {'X','_','X','_'},
            {'F','X','_','X'}
    };
    private static MapVO mapVO = new MapVO(4, map);
    private static int[] fox = {3,0};
    private static int[][] hounds = {{0, 1}, {0, 3}};
    private static GameState inputGameState = new GameState(mapVO, true, true, fox, hounds);
    private static GameState inputTwoGameState = new GameState(mapVO, false, true, fox, hounds);
    private static GameState expectedGameState = new GameState(mapVO, true, false, fox, hounds);

    @Test
    public void testExitGameShouldGiveBackGameStateWithPlayerDontWantToExitBeingFalse() throws ExitException {
        //given
        underTest = new ExitCommand(inputGameState);

        //when
        GameState result = underTest.exitGame();

        //then
        assertEquals(expectedGameState.isPlayerDontWantToExit(), result.isPlayerDontWantToExit());
    }

    @Test
    public void testExitGameShouldThrowExceptionWhenMapNotExist() {
        //given
        underTest = new ExitCommand(inputTwoGameState);

        //when - then
        assertThrows(ExitException.class, ()->{
            underTest.exitGame();
        });
    }
}