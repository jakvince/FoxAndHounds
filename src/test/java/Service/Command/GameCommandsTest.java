package Service.Command;

import hu.Progtech.FoxAndHounds.Model.GameState;
import hu.Progtech.FoxAndHounds.Model.MapVO;
import hu.Progtech.FoxAndHounds.Service.Command.GameCommands;
import hu.Progtech.FoxAndHounds.Service.Exception.ExitException;
import hu.Progtech.FoxAndHounds.Service.Exception.MapBuildingException;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameCommandsTest {

    private GameCommands underTest;

    private GameState inputGameState = new GameState(null, false, true, null, null);
    private String startCommand = "start";
    private String wrongStepCommand = "step";
    private String badStepCommand = "step up felt";
    private String goodStepCommand = "step up right";
    private String exitCommand = "exit";
    private String wrongCommand = "asd";
    private char[][] map = {
            {'X', 'H', 'X', 'H'},
            {'_', 'X', '_', 'X'},
            {'X', '_', 'X', '_'},
            {'F', 'X', '_', 'X'}
    };
    private char[][] randomHoundMap = {
            {'X', '_', 'X', 'H'},
            {'_', 'X', 'H', 'X'},
            {'X', 'F', 'X', '_'},
            {'_', 'X', '_', 'X'}
    };
    private MapVO mapVO = new MapVO(4, map);
    private MapVO randomHoundMapVO = new MapVO(4, randomHoundMap);
    private int[] fox = {3, 0};
    private int[] randomHoundFox = {2, 1};
    private int[][] hounds = {{0, 1}, {0, 3}};
    private int[][] randomHoundHounds = {{1, 2}, {0, 3}};
    private GameState expectedGameState = new GameState(mapVO, true, true, fox, hounds);
    private GameState randomHoundGameState = new GameState(randomHoundMapVO, true, true, randomHoundFox, randomHoundHounds);


    @Test
    public void testCheckCommandShouldGiveNewGameStateWhenCommandIsStart() throws MapBuildingException, ExitException {
        //given
        underTest = new GameCommands(startCommand, inputGameState);
        String input = "4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        GameState result = underTest.checkCommand();

        //then
        assertEquals(expectedGameState.getMapVO().toString(), result.getMapVO().toString());
    }

    @Test
    public void testCheckCommandShouldGiveBackTheSameGameStateWhenStepCommandNotThreeWords() throws MapBuildingException, ExitException {
        //given
        underTest = new GameCommands(wrongStepCommand, expectedGameState);

        //when
        GameState result = underTest.checkCommand();

        //then
        assertEquals(expectedGameState.getMapVO().toString(), result.getMapVO().toString());
    }

    @Test
    public void testCheckCommandShouldGiveGameStateWithFalseWhenCommandIsExit() throws MapBuildingException, ExitException {
        //given
        underTest = new GameCommands(exitCommand, expectedGameState);

        //when
        GameState result = underTest.checkCommand();

        //then
        assertEquals(expectedGameState.isPlayerDontWantToExit(), false);
    }

    @Test
    public void testCheckCommandShouldGiveBackSameGameStateWhenWrongCommand() throws MapBuildingException, ExitException {
        //given
        underTest = new GameCommands(wrongCommand, expectedGameState);

        //when
        GameState result = underTest.checkCommand();

        //then
        assertEquals(expectedGameState.toString(), result.toString());
    }

    @Test
    public void testCheckCommandShouldGiveBackSameGameStateWhenStepCommandIsWrong() throws MapBuildingException, ExitException {
        //given
        underTest = new GameCommands(badStepCommand, expectedGameState);

        //when
        GameState result = underTest.checkCommand();

        //then
        assertEquals(expectedGameState.toString(), result.toString());
    }
    @Test
    public void testCheckCommandShouldGiveBackGameStateAfterRandomHound() throws MapBuildingException, ExitException {
        //given
        underTest = new GameCommands(goodStepCommand, expectedGameState);

        //when
        GameState result = underTest.checkCommand();

        //then
        assertEquals(randomHoundGameState.getMapVO().toString(), result.getMapVO().toString());
    }
}