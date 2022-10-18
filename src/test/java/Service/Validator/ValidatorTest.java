package Service.Validator;

import hu.Progtech.FoxAndHounds.Model.GameState;
import hu.Progtech.FoxAndHounds.Model.MapVO;
import hu.Progtech.FoxAndHounds.Service.Validator.Validator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatorTest {

    private Validator underTest;
    private static final char[][] map={
            {'X','H','X','H'},
            {'_','X','_','X'},
            {'X','_','X','_'},
            {'F','X','_','X'}
    };

    private static final MapVO mapVO = new MapVO(4,map);
    private static final int[] winFox = {0,1};
    private static final int[] notWinFox = {1,0};
    private static final int[][] hounds = {{2, 1}, {0, 3}};
    private static final GameState winGameState = new GameState(mapVO, true, true, winFox, hounds);

    @Test
    public void testDidYouWinShouldGiveTrue() {
        //given
        underTest = new Validator(winGameState);

        //when
        boolean result = underTest.didYouWin();

        //then
        assertEquals(true, result);
    }

    private static final GameState notWinGameState = new GameState(mapVO, true, true, notWinFox, hounds);
    @Test
    public void testDidYouWinShouldGiveFalse() {
        //given
        underTest = new Validator(notWinGameState);

        //when
        boolean result = underTest.didYouWin();

        //then
        assertEquals(false, result);
    }

    private static final char[][] loseOneMap={
            {'X','_','X','H'},
            {'_','X','_','X'},
            {'X','H','X','_'},
            {'F','X','_','X'}
    };
    private static final MapVO loseOneMapVO = new MapVO(4,loseOneMap);
    private static final int[] loseOneFox = {3,0};
    private static final GameState loseOneGameState = new GameState(loseOneMapVO, true, true, loseOneFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveTrueOne() {
        //given
        underTest = new Validator(loseOneGameState);

        //when
        boolean result = underTest.didYouLose();

        //then
        assertEquals(true, result);
    }

    private static final char[][] notLoseOneMap={
            {'X','H','X','H'},
            {'_','X','_','X'},
            {'X','_','X','_'},
            {'F','X','_','X'}
    };
    private static final MapVO notLoseOneMapVO = new MapVO(4,notLoseOneMap);
    private static final GameState notLoseOneGameState = new GameState(notLoseOneMapVO, true, true, loseOneFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveFalseOne() {
        //given
        underTest = new Validator(notLoseOneGameState);

        //when
        boolean result = underTest.didYouLose();

        //then
        assertEquals(false, result);
    }

    private static final char[][] loseTwoMap={
            {'X','H','X','_'},
            {'F','X','_','X'},
            {'X','H','X','_'},
            {'_','X','_','X'}
    };
    private static final MapVO loseTwoMapVO = new MapVO(4,loseTwoMap);
    private static final int[] loseTwoFox = {1,0};
    private static final GameState loseTwoGameState = new GameState(loseTwoMapVO, true, true, loseTwoFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveTrueTwo() {
        //given
        underTest = new Validator(loseTwoGameState);

        //when
        boolean result = underTest.didYouLose();

        //then
        assertEquals(true, result);
    }

    private static final char[][] notLoseTwoMap={
            {'X','_','X','H'},
            {'F','X','_','X'},
            {'X','H','X','_'},
            {'_','X','_','X'}
    };
    private static final MapVO notLoseTwoMapVO = new MapVO(4,notLoseTwoMap);
    private static final GameState notLoseTwoGameState = new GameState(notLoseTwoMapVO, true, true, loseTwoFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveFalseTwo() {
        //given
        underTest = new Validator(notLoseTwoGameState);

        //when
        boolean result = underTest.didYouLose();

        //then
        assertEquals(false, result);
    }

    private static final char[][] notLoseUpRightMap ={
            {'X','_','X','F'},
            {'_','X','H','X'},
            {'X','H','X','_'},
            {'_','X','_','X'}
    };
    private static final MapVO notLoseUpRightMapVO = new MapVO(4, notLoseUpRightMap);
    private static final int[] notLoseUpRightFox = {0,3};
    private static final GameState notLoseUpRightGameState = new GameState(notLoseUpRightMapVO, true, true, notLoseUpRightFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveFalseUpRight() {
        //given
        underTest = new Validator(notLoseUpRightGameState);

        //when
        boolean result = underTest.didYouLose();

        //then
        assertEquals(false, result);
    }
    private static final char[][] notLoseUpMap={
            {'X','F','X','_'},
            {'H','X','H','X'},
            {'X','_','X','_'},
            {'_','X','_','X'}
    };
    private static final MapVO notLoseUpMapVO = new MapVO(4, notLoseUpMap);
    private static final int[] notLoseUpFox = {0,1};
    private static final GameState notLoseUpGameState = new GameState(notLoseUpMapVO, true, true, notLoseUpFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveFalseUp() {
        //given
        underTest = new Validator(notLoseUpGameState);

        //when
        boolean result = underTest.didYouLose();

        //then
        assertEquals(false, result);
    }
    private static final char[][] loseThreeMap={
            {'X','_','X','_'},
            {'_','X','H','X'},
            {'X','_','X','F'},
            {'_','X','H','X'}
    };
    private static final MapVO loseThreeMapVO = new MapVO(4, loseThreeMap);
    private static final int[] loseThreeFox = {2,3};
    private static final GameState loseThreeGameState = new GameState(loseThreeMapVO, true, true, loseThreeFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveTrueThree() {
        //given
        underTest = new Validator(loseThreeGameState);

        //when
        boolean result = underTest.didYouLose();

        //then
        assertEquals(true, result);
    }
    private static final char[][] notLoseThreeMap={
            {'X','H','X','_'},
            {'_','X','_','X'},
            {'X','_','X','F'},
            {'_','X','H','X'}
    };
    private static final MapVO notLoseThreeMapVO = new MapVO(4, notLoseThreeMap);
    private static final GameState notLoseThreeGameState = new GameState(notLoseThreeMapVO, true, true, loseThreeFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveFalseThree() {
        //given
        underTest = new Validator(notLoseThreeGameState);

        //when
        boolean result = underTest.didYouLose();

        //then
        assertEquals(false, result);
    }
    private static final char[][] loseFourMap={
            {'X','_','X','_'},
            {'_','X','_','X'},
            {'X','H','X','H'},
            {'_','X','F','X'}
    };
    private static final MapVO loseFourMapVO = new MapVO(4, loseFourMap);
    private static final int[] loseFourFox = {3,2};
    private static final GameState loseFourGameState = new GameState(loseFourMapVO, true, true, loseFourFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveTrueFour() {
        //given
        underTest = new Validator(loseFourGameState);

        //when
        boolean result = underTest.didYouLose();

        //then
        assertEquals(true, result);
    }
    private static final char[][] notLoseFourMap={
            {'X','_','X','_'},
            {'_','X','H','X'},
            {'X','_','X','H'},
            {'_','X','F','X'}
    };
    private static final MapVO notLoseFourMapVO = new MapVO(4, notLoseFourMap);
    private static final GameState notLoseFourGameState = new GameState(notLoseFourMapVO, true, true, loseFourFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveFalseFour() {
        //given
        underTest = new Validator(notLoseFourGameState);

        //when
        boolean result = underTest.didYouLose();

        //then
        assertEquals(false, result);
    }
    private static final char[][] loseFiveMap={
            {'X','H','X','H'},
            {'_','X','F','X'},
            {'X','H','X','H'},
            {'_','X','_','X'}
    };
    private static final MapVO loseFiveMapVO = new MapVO(4, loseFiveMap);
    private static final int[] loseFiveFox = {1,2};
    private static final GameState loseFiveGameState = new GameState(loseFiveMapVO, true, true, loseFiveFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveTrueFive() {
        //given
        underTest = new Validator(loseFiveGameState);

        //when
        boolean result = underTest.didYouLose();

        //then
        assertEquals(true, result);
    }
    private static final char[][] notLoseFiveMap={
            {'X','H','X','H'},
            {'_','X','F','X'},
            {'X','_','X','H'},
            {'_','X','_','X'}
    };
    private static final MapVO notLoseFiveMapVO = new MapVO(4, notLoseFiveMap);
    private static final GameState notLoseFiveGameState = new GameState(notLoseFiveMapVO, true, true, loseFiveFox, hounds);
    @Test
    public void testDidYouLoseShouldGiveFalseFive() {
        //given
        underTest = new Validator(notLoseFiveGameState);

        //when
        boolean result = underTest.didYouLose();

        //then
        assertEquals(false, result);
    }
}
