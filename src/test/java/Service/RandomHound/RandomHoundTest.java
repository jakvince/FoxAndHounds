package Service.RandomHound;

import hu.Progtech.FoxAndHounds.Model.GameState;
import hu.Progtech.FoxAndHounds.Model.MapVO;
import hu.Progtech.FoxAndHounds.Service.RandomHound.RandomHound;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RandomHoundTest {

    private RandomHound underTest;

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
    private char[][] inOneLeftMap = {
            {'X', '_', 'X', 'H'},
            {'H', 'X', 'F', 'X'},
            {'X', '_', 'X', '_'},
            {'_', 'X', '_', 'X'},
    };
    private char[][] expectedLeftOneMap = {
            {'X', '_', 'X', 'H'},
            {'_', 'X', 'F', 'X'},
            {'X', 'H', 'X', '_'},
            {'_', 'X', '_', 'X'}
    };
    private MapVO inOneLeftMapVO = new MapVO(4, inOneLeftMap);
    private MapVO expectedOneLeftMapVO = new MapVO(4, expectedLeftOneMap);
    private int[] oneLeftFox = {1, 2};
    private int[][] inOneLeftHounds = {{1, 0}, {0, 3}};
    private int[][] expectedOneLeftHounds = {{2, 1}, {0, 3}};
    private GameState inOneLeftGameState = new GameState(inOneLeftMapVO, true, true, oneLeftFox, inOneLeftHounds);
    private GameState expectedOneLeftGameState = new GameState(expectedOneLeftMapVO, true, true, oneLeftFox, expectedOneLeftHounds);

    @Test
    public void testRandomHoundShouldReturnCorrectGameStateWhenHoundRightSideButCantStepLeft() {
        //given
        underTest = new RandomHound(inOneLeftGameState);

        //when
        GameState result = underTest.randomHound();

        //then
        assertEquals(expectedOneLeftGameState.getMapVO().toString(), result.getMapVO().toString());
    }
}
