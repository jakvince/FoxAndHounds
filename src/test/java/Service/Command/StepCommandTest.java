package Service.Command;

import hu.Progtech.FoxAndHounds.Model.GameState;
import hu.Progtech.FoxAndHounds.Model.MapVO;
import hu.Progtech.FoxAndHounds.Service.Command.StepCommand;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepCommandTest {

    private StepCommand underTest;
    private String up = "up";
    private String down = "down";
    private String left = "left";
    private String right = "right";
    private String wrong = "asd";

    private char[][] upRightMap = {
            {'X', 'H', 'X', 'H'},
            {'_', 'X', '_', 'X'},
            {'X', '_', 'X', '_'},
            {'F', 'X', '_', 'X'},
    };
    private MapVO upRightMapVO = new MapVO(4, upRightMap);
    private int[] upRightFox = {3, 0};
    private int[][] hounds = {{0, 1}, {0, 3}};
    private GameState inputUpRightGameState = new GameState(upRightMapVO, true, true, upRightFox, hounds);
    private char[][] expectedUpRightMap = {
            {'X', 'H', 'X', 'H'},
            {'_', 'X', '_', 'X'},
            {'X', 'F', 'X', '_'},
            {'_', 'X', '_', 'X'},
    };
    private MapVO expectedUpRightMapVO = new MapVO(4, expectedUpRightMap);
    private int[] expectedUpRightFox = {2, 1};
    private GameState expectedInputUpRightGameState = new GameState(expectedUpRightMapVO, true, true, expectedUpRightFox, hounds);
    @Test
    public void testStepGameShouldReturnCorrectGameStateWhenUpRight() {
        //given
        underTest = new StepCommand(inputUpRightGameState, up, right);

        //when
        GameState result = underTest.stepGame();

        //then
        assertEquals(expectedInputUpRightGameState.getMapVO().toString(), result.getMapVO().toString());
    }
    private char[][] upLeftMap = {
            {'X', 'H', 'X', 'H'},
            {'_', 'X', '_', 'X'},
            {'X', '_', 'X', '_'},
            {'_', 'X', 'F', 'X'},
    };
    private MapVO upLeftMapVO = new MapVO(4, upLeftMap);
    private int[] upLeftFox = {3, 2};
    private GameState inputUpLeftGameState = new GameState(upLeftMapVO, true, true, upLeftFox, hounds);
    private GameState expectedInputUpLeftGameState = new GameState(expectedUpRightMapVO, true, true, expectedUpRightFox, hounds);
    @Test
    public void testStepGameShouldReturnCorrectGameStateWhenUpLeft() {
        //given
        underTest = new StepCommand(inputUpLeftGameState, up, left);

        //when
        GameState result = underTest.stepGame();

        //then
        assertEquals(expectedInputUpLeftGameState.getMapVO().toString(), result.getMapVO().toString());
    }

    private char[][] downRightMap = {
            {'X', 'H', 'X', 'H'},
            {'F', 'X', '_', 'X'},
            {'X', '_', 'X', '_'},
            {'_', 'X', '_', 'X'},
    };
    private MapVO downRightMapVO = new MapVO(4, downRightMap);
    private int[] downRightFox = {1, 0};
    private GameState inputDownRightGameState = new GameState(downRightMapVO, true, true, downRightFox, hounds);
    private GameState expectedInputDownRightGameState = new GameState(expectedUpRightMapVO, true, true, expectedUpRightFox, hounds);
    @Test
    public void testStepGameShouldReturnCorrectGameStateWhenDownRight() {
        //given
        underTest = new StepCommand(inputDownRightGameState, down, right);

        //when
        GameState result = underTest.stepGame();

        //then
        assertEquals(expectedInputDownRightGameState.getMapVO().toString(), result.getMapVO().toString());
    }

    private char[][] downLeftMap = {
            {'X', 'H', 'X', 'H'},
            {'_', 'X', 'F', 'X'},
            {'X', '_', 'X', '_'},
            {'_', 'X', '_', 'X'},
    };
    private MapVO downLeftMapVO = new MapVO(4, downLeftMap);
    private int[] downLeftFox = {1, 2};
    private GameState inputDownLeftGameState = new GameState(downLeftMapVO, true, true, downLeftFox, hounds);
    private GameState expectedInputDownLeftGameState = new GameState(expectedUpRightMapVO, true, true, expectedUpRightFox, hounds);
    @Test
    public void testStepGameShouldReturnCorrectGameStateWhenDownLeft() {
        //given
        underTest = new StepCommand(inputDownLeftGameState, down, left);

        //when
        GameState result = underTest.stepGame();

        //then
        assertEquals(expectedInputDownLeftGameState.getMapVO().toString(), result.getMapVO().toString());
    }

    private char[][] notLeftOrRightMap = {
            {'X', 'H', 'X', 'H'},
            {'F', 'X', '_', 'X'},
            {'X', '_', 'X', '_'},
            {'_', 'X', '_', 'X'},
    };
    private MapVO notLeftOrRightMapVO = new MapVO(4, notLeftOrRightMap);
    private int[] notLeftOrRightFox = {1, 0};
    private GameState inputNotLeftOrRightGameState = new GameState(notLeftOrRightMapVO, true, true, notLeftOrRightFox, hounds);
    @Test
    public void testStepGameShouldReturnSameGameStateWhenWrongTheDirection() {
        //given
        underTest = new StepCommand(inputNotLeftOrRightGameState, down, wrong);

        //when
        GameState result = underTest.stepGame();

        //then
        assertEquals(inputNotLeftOrRightGameState.getMapVO().toString(), result.getMapVO().toString());
    }

    private char[][] notUpOrDownMap = {
            {'X', 'H', 'X', 'H'},
            {'F', 'X', '_', 'X'},
            {'X', '_', 'X', '_'},
            {'_', 'X', '_', 'X'},
    };
    private MapVO notUpOrDownMapVO = new MapVO(4, notUpOrDownMap);
    private int[] notUpOrDownFox = {1, 0};
    private GameState inputNotUpOrDownGameState = new GameState(notUpOrDownMapVO, true, true, notUpOrDownFox, hounds);
    @Test
    public void testStepGameShouldReturnSameGameStateWhenUpOrDownIsWrong() {
        //given
        underTest = new StepCommand(inputNotUpOrDownGameState, wrong, right);

        //when
        GameState result = underTest.stepGame();

        //then
        assertEquals(inputNotUpOrDownGameState.getMapVO().toString(), result.getMapVO().toString());
    }
}
