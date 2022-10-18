package hu.Progtech.FoxAndHounds.Service.Command;

import java.util.Scanner;

import hu.Progtech.FoxAndHounds.Model.GameState;
import hu.Progtech.FoxAndHounds.Model.MapVO;
import hu.Progtech.FoxAndHounds.Service.Exception.MapBuildingException;
import hu.Progtech.FoxAndHounds.Service.Map.MapBuilder;

public class StartCommand {

    public GameState startGame() throws MapBuildingException {
        int size;
        size = 0;
        GameState startGameMap;
        startGameMap = new GameState(null, true, true, null, null);
        MapVO createdMap;
        createdMap = null;
        int[] fox;
        fox = new int[2];
        int[][] hounds;
        Scanner input = new Scanner(System.in);
        System.out.println("?Size?: ");
        size = Integer.parseInt(input.nextLine());
        hounds = new int[size / 2][2];
        for (int i = 1; i < size; i += 2) {
            hounds[i / 2][0] = 0;
            hounds[i / 2][1] = i;
        }
        fox[0] = size - 1;
        fox[1] = 0;
        createdMap = new MapBuilder(size).build();
        startGameMap.setFox(fox);
        startGameMap.setHounds(hounds);
        startGameMap.setMapVO(createdMap);
        return startGameMap;
    }
}