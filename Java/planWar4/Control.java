package planWar4;

import java.util.LinkedList;

public class Control implements Runnable{
    GameWindow gameWindow;
    PlayerPlane playerPlane;
    //创建一个显示接口的集合：LinkedList
    LinkedList<Display> disList = new LinkedList<Display>();
    //创建一个敌机的集合
    LinkedList<AbstractEnemy> enemyList = new LinkedList<AbstractEnemy>();

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


            //对于子弹的管理:---------------------------------------
            // 鼠标被按下,就飞机头的中间位置产生一颗新子弹并且将这颗子弹加入玩家飞机的子弹列表
            if (this.playerPlane.isFire == true && timer %100 == 0){
            Bullet bullet = new SimpleBullet(this.playerPlane.x + 35 + this.playerPlane.width/2,
                    this.playerPlane.y);
            this.playerPlane.bulletList.add(bullet);
            this.disList.add(bullet);
            System.out.println(this.playerPlane.bulletList.size());
            }
            //让子弹飞
            
            if(timer %3 == 0){
                for(int i = 0;i<this.playerPlane.bulletList.size(); i++){
                    this.playerPlane.bulletList.get(i).move();
                }
            }

            //删除飞出游戏界面的子弹
                for(int i = 0; i<this.playerPlane.bulletList.size();i++){
                    //判断子弹位置，如果飞出界面，则删除子弹(不仅要从子弹集合中删除，还要从显示物集合中删除)
                    if(((SimpleBullet)this.playerPlane.bulletList.get(i)).y < -30){
                        this.disList.remove(this.playerPlane.bulletList.get(i));
                        this.playerPlane.bulletList.remove(i);
                    }
                }

                //对敌机进行管理-----------------------------------------------
                // a）	每隔一定的时间，敌机的产生，添加到敌机集合中，添加到显示物集合中
                if(timer % 200 == 0){
                    //产生敌机
                    Enemy1 enemy1= new Enemy1();
                    //添加到敌机的集合中
                    this.enemyList.add(enemy1);
                    //添加到显示物集合中
                    this.disList.add(enemy1);
                }
                // b）	敌机的移动
                if(timer % 5 ==0){
                    for(int i = 0;i < this.enemyList.size(); i++){
                        this.enemyList.get(i).move();
                    // c）	敌机的死亡
                        if(this.enemyList.get(i).y > this.gameWindow.gamePanel.height
                        ){//敌机飞出游戏界面
                            //从显示物列表中删除敌机
                            this.disList.remove(this.enemyList.get(i));
                            //从敌机列表中删除敌机
                            this.enemyList.remove(i);
                        }
                    }
                    System.out.println(this.enemyList.size());
                }
               



            //************************************************************ 
        }
        //---------------------------------------------------------
    }
}
