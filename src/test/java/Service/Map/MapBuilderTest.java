package Service.Map;

import hu.Progtech.FoxAndHounds.Service.Exception.MapBuildingException;
import hu.Progtech.FoxAndHounds.Model.MapVO;
import hu.Progtech.FoxAndHounds.Service.Map.MapBuilder;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapBuilderTest {
    private MapBuilder underTest;

    private static char[][] map={
            {'X','H','X','H'},
            {'_','X','_','X'},
            {'X','_','X','_'},
            {'F','X','_','X'}
    };

    private static MapVO exeptedMapVO = new MapVO(4,map);

    @Test
    public void testBuildShouldReturnNewParse() throws MapBuildingException {
        //given
        underTest = new MapBuilder(4);

        //then
        MapVO result = underTest.build();

        //when
        assertEquals(exeptedMapVO, result);
    }

    @Test
    public void testBuildShouldThrowMapParsingExeptionWhenGivenNumberLessThen4() {
        //given
        underTest = new MapBuilder(2);

        //when-then
        assertThrows(MapBuildingException.class, ()->{
            underTest.build();
        });
    }

    @Test
    public void testBuildShouldThrowMapParsingExeptionWhenGivenNumberMoreThen12() {
        //given
        underTest =new MapBuilder(14);

        //when-then
        assertThrows(MapBuildingException.class, ()->{
            underTest.build();
        });
    }

    @Test
    public void testBuildShouldThrowMapParsingExeptionWhenGivenNumberDoesntEvenNumber() {
        //given
        underTest =new MapBuilder(7);

        //when-then
        assertThrows(MapBuildingException.class, ()->{
            underTest.build();
        });
    }
}