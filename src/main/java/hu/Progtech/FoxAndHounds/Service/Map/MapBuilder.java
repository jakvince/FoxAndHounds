package hu.Progtech.FoxAndHounds.Service.Map;

import hu.Progtech.FoxAndHounds.Model.MapVO;
import hu.Progtech.FoxAndHounds.Service.Exception.MapBuildingException;

public class MapBuilder {

    private final int mapSize;

    public MapBuilder(int mapSize) {

        this.mapSize = mapSize;
    }

    public MapVO build() throws MapBuildingException {

        checkSize(mapSize);

        char[][] map = getMap();

        return new MapVO(mapSize, map);
    }

    public void checkSize(int mapSize) throws MapBuildingException {
        if (mapSize < 4) {
            throw new MapBuildingException("Size of map has to be minimum 4!");
        }
        if (mapSize > 12) {
            throw new MapBuildingException("Size of map has to be maximum 12!");
        }
        if (mapSize % 2 != 0) {
            throw new MapBuildingException("Size of map has to be even number!");
        }
    }

    public char[][] getMap() {
        char[][] map = new char[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            if (i == 0) {
                for (int j = 0; j < mapSize; j++) {
                    if (j % 2 != 0) {
                        map[i][j] = 'H';
                    } else {
                        map[i][j] = 'X';
                    }
                }
            } else {
                for (int j = 0; j < mapSize; j++) {
                    if (i % 2 != 0) {
                        if (j % 2 == 0) {
                            map[i][j] = '_';
                        } else {
                            map[i][j] = 'X';
                        }
                    } else {
                        if (j % 2 != 0) {
                            map[i][j] = '_';
                        } else {
                            map[i][j] = 'X';
                        }
                    }
                }
            }
        }
        map[mapSize - 1][0] = 'F';
        return map;
    }
}