package planWar3;

import java.util.LinkedList;

public class Control implements Runnable{
    GameWindow gameWindow;
    PlayerPlane playerPlane;
    //创建一个显示接口的集合：LinkedList
    LinkedList<Display> disList = new LinkedList<Display>();

    //设置一个计时器
    int timer = 1;

    public Control(){
        //创建游戏窗口——游戏面板
        gameWindow = new GameWindow();
        //创建玩家飞机
        playerPlane = new PlayerPlane();
        //把玩家飞机添加到显示集合中
        disList.add(playerPlane);

        //将玩家飞机传入游戏窗口
        gameWindow.setPlayerPlane(playerPlane);
        //将被显示物集合传入游戏窗口
        gameWindow.setDisList(disList);
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
            if(timer % 10 == 0){
                this.gameWindow.gamePanel.bgMove();
            }

            //每隔10ms屏幕刷新一次，实现显示频率100HZ
            if(timer % 10 == 0)
                this.gameWindow.gamePanel.repaint();


            //对于子弹的管理:
            // 鼠标被按下,就飞机头的中间位置产生一颗新子弹并且将这颗子弹加入玩家飞机的子弹列表
            if (this.playerPlane.isFire == true && timer %100 == 0){
            Bullet bullet = new SimpleBullet(this.playerPlane.x + 35 + this.playerPlane.width/2,
                    this.playerPlane.y);
            this.playerPlane.bulletList.add(bullet);
            this.disList.add(bullet);
            }
            //让子弹飞
            
            if(timer %3 == 0){
                for(int i = 0;i<this.playerPlane.bulletList.size(); i++){
                    this.playerPlane.bulletList.get(i).move();
                }
            }
            //************************************************************ 
        }
        //---------------------------------------------------------
    }
}
