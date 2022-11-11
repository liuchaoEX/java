package planWar2;

public class Control implements Runnable{
    GameWindow gameWindow;
    PlayerPlane playerPlane;

    int timer = 1;

    public Control(){
        //创建游戏窗口——游戏面板
        gameWindow = new GameWindow();
        //创建玩家飞机
        playerPlane = new PlayerPlane();
        //将玩家飞机传入游戏窗口
        gameWindow.setPlayerPlane(playerPlane);
    }

    @Override
    public void run() {
        //----------------------------------------------
        //实现定时
        while(true){
            //*************************************************
            //每隔1ms停一次
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        if(timer < 10000)
            timer ++;
            else
            timer = 1;

            //每隔10ms背景图片移动一次
            if(timer % 1 == 0){
                this.gameWindow.gamePanel.bgMove();
            }

            //每隔10ms屏幕刷新一次，实现显示频率100HZ
            if(timer % 10 == 0)
                this.gameWindow.gamePanel.repaint();

            //************************************************************ 
        }
        //---------------------------------------------------------
    }
}
