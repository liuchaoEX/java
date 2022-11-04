package planWar1;

public class Control {
    GameWindow gameWindow;
    PlayerPlane playerPlane;

    public Control(){
        //创建游戏窗口——游戏面板
        gameWindow = new GameWindow();
        //创建玩家飞机
        playerPlane = new PlayerPlane();
        //将玩家飞机传入游戏窗口
        gameWindow.setPlayerPlane(playerPlane);
    }
}
