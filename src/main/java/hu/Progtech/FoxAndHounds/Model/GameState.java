package hu.Progtech.FoxAndHounds.Model;

public class GameState {
    private MapVO mapVO;
    private boolean isMapExist;
    private boolean playerDontWantToExit;
    private int[] fox;
    private int[][] hounds;

    public GameState(MapVO mapVO, boolean isMapExist, boolean playerDontWantToExit, int[] fox, int[][] hounds) {
        this.mapVO = mapVO;
        this.isMapExist = isMapExist;
        this.playerDontWantToExit = playerDontWantToExit;
        this.fox = fox;
        this.hounds = hounds;
    }

    public int[] getFox() {
        return fox;
    }

    public void setFox(int[] fox) {
        this.fox = fox;
    }

    public int[][] getHounds() {
        return hounds;
    }

    public void setHounds(int[][] hounds) {
        this.hounds = hounds;
    }

    public boolean isMapExist() {
        return isMapExist;
    }

    public void setMapExist(boolean mapExist) {
        isMapExist = mapExist;
    }

    public MapVO getMapVO() {
        return mapVO;
    }

    public void setMapVO(MapVO mapVO) {
        this.mapVO = mapVO;
    }

    public boolean isPlayerDontWantToExit() {
        return playerDontWantToExit;
    }

    public void setPlayerDontWantToExit(boolean playerDontWantToExit) {
        this.playerDontWantToExit = playerDontWantToExit;
    }
}
