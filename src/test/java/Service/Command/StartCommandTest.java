package Service.Command;

import hu.Progtech.FoxAndHounds.Model.GameState;
import hu.Progtech.FoxAndHounds.Model.MapVO;
import hu.Progtech.FoxAndHounds.Service.Command.StartCommand;
import hu.Progtech.FoxAndHounds.Service.Exception.MapBuildingException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;

public class StartCommandTest {

    private StartCommand underTest;
    private static char[][] map={
            {'X','H','X','H'},
            {'_','X','_','X'},
            {'X','_','X','_'},
            {'F','X','_','X'}
    };
    private static MapVO mapVO = new MapVO(4,map);
    private static int[] fox = {3,0};
    private static int[][] hounds = {{0, 1}, {0, 3}};
    private static GameState expectedGameState = new GameState(mapVO, true, true, fox, hounds);
    private static String input = "4";


    @Test
    public void testStartGameShouldGiveBackCorrectGameState() throws MapBuildingException {
        //given
        underTest = new StartCommand();
        String input = "4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        GameState result = underTest.startGame();

        //then
        assertEquals(expectedGameState.getMapVO().toString(), result.getMapVO().toString());
    }
}
