package Service.RandomHound;

import hu.Progtech.FoxAndHounds.Model.GameState;
import hu.Progtech.FoxAndHounds.Model.MapVO;
import hu.Progtech.FoxAndHounds.Service.RandomHound.RandomHound;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomHoundTest {

    private RandomHound underTest;

    private char[][] map = {
            {'X', 'H', 'X', 'H'},
            {'_', 'X', '_', 'X'},
            {'X', '_', 'X', '_'},
            {'F', 'X', '_', 'X'},
    };
    private char[][] expectedMap = {
            {'X', '_', 'X', 'H'},
            {'_', 'X', 'H', 'X'},
            {'X', '_', 'X', '_'},
            {'F', 'X', '_', 'X'}
    };
    private MapVO mapVO = new MapVO(4, map);
    private MapVO expectedMapVO = new MapVO(4, expectedMap);
    private int[] fox = {3, 0};
    private int[][] hounds = {{0, 1}, {0, 3}};
    private int[][] expectedHounds = {{1, 2}, {0, 3}};
    private GameState inGameState = new GameState(mapVO, true, true, fox, hounds);
    private GameState expectedGameState = new GameState(expectedMapVO, true, true, fox, expectedHounds);

    @Test
    public void testRandomHoundShouldReturnCorrectGameStateWhenHoundInUpRightCorner() {
        //given
        underTest = new RandomHound(inGameState);

        //when
        GameState result = underTest.randomHound();

        //then
        assertEquals(expectedGameState.getMapVO().toString(), result.getMapVO().toString());
    };
    private char[][] inOneMap = {
            {'X', '_', 'X', 'H'},
            {'H', 'X', '_', 'X'},
            {'X', '_', 'X', '_'},
            {'F', 'X', '_', 'X'},
    };
    private char[][] expectedOneMap = {
            {'X', '_', 'X', 'H'},
            {'_', 'X', '_', 'X'},
            {'X', 'H', 'X', '_'},
            {'F', 'X', '_', 'X'}
    };
    private MapVO inOneMapVO = new MapVO(4, inOneMap);
    private MapVO expectedOneMapVO = new MapVO(4, expectedOneMap);
    private int[][] inOneHounds = {{1, 0}, {0, 3}};
    private int[][] expectedOneHounds = {{2, 1}, {0, 3}};
    private GameState inOneGameState = new GameState(inOneMapVO, true, true, fox, inOneHounds);
    private GameState expectedOneGameState = new GameState(expectedOneMapVO, true, true, fox, expectedOneHounds);

    @Test
    public void testRandomHoundShouldReturnCorrectGameStateWhenHoundLeftSide() {
        //given
        underTest = new RandomHound(inOneGameState);

        //when
        GameState result = underTest.randomHound();

        //then
        assertEquals(expectedOneGameState.getMapVO().toString(), result.getMapVO().toString());
    }
    private char[][] inOneRightMap = {
            {'X', '_', 'X', 'H'},
            {'H', 'X', '_', 'X'},
            {'X', 'F', 'X', '_'},
            {'_', 'X', '_', 'X'},
    };
    private char[][] expectedRightOneMap = {
            {'X', '_', 'X', '_'},
            {'H', 'X', 'H', 'X'},
            {'X', 'F', 'X', '_'},
            {'_', 'X', '_', 'X'}
    };
    private MapVO inOneRightMapVO = new MapVO(4, inOneRightMap);
    private MapVO expectedOneRightMapVO = new MapVO(4, expectedRightOneMap);
    private int[] oneRightFox = {2, 1};
    private int[][] inOneRightHounds = {{1, 0}, {0, 3}};
    private int[][] expectedOneRightHounds = {{1, 0}, {1, 2}};
    private GameState inOneRightGameState = new GameState(inOneRightMapVO, true, true, oneRightFox, inOneRightHounds);
    private GameState expectedOneRightGameState = new GameState(expectedOneRightMapVO, true, true, oneRightFox, expectedOneRightHounds);

    @Test
    public void testRandomHoundShouldReturnCorrectGameStateWhenHoundLeftSideButCantStepRight() {
        //given
        underTest = new RandomHound(inOneRightGameState);

        //when
        GameState result = underTest.randomHound();

        //then
        assertEquals(expectedOneRightGameState.getMapVO().toString(), result.getMapVO().toString());
    }
}
