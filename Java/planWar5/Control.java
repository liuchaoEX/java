package planWar5;

import java.util.LinkedList;
import java.awt.Rectangle;

public class Control implements Runnable{
    GameWindow gameWindow;
    PlayerPlane playerPlane;
    //创建一个显示接口的集合：LinkedList
    LinkedList<Display> disList = new LinkedList<Display>();
    //创建一个敌机的集合
    LinkedList<AbstractEnemy> enemyList = new LinkedList<AbstractEnemy>();
    public static final int OVER = 2;
    public static final int PAUSE = 1;
    public static final int NORMAL = 0;

    //定义游戏的状态值
    public static int gameState = NORMAL;   //如果等于0，游戏正常；值为1，游戏暂停，如果值为2，则游戏结束
    //定义游戏的得分
    public static int gameScore = 0;

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
    //游戏的再次初始化
    public  void init(){
        this.playerPlane.init();
        disList.add(playerPlane);
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

            //游戏正常的状态下
        if(Control.gameState == Control.NORMAL){
            
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
                AbstractBullet bullet = new SimpleBullet(this.playerPlane.x + 35,
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
                    if((this.playerPlane.bulletList.get(i)).y < -30){
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
                
                //做碰撞检测--------------------------------------------------------------
                if(timer %5 ==0){
                    //子弹和敌机的碰撞检测
                    for(int i=0; i<this.playerPlane.bulletList.size();i++){//拿到所有的子弹
                        AbstractBullet bullet = this.playerPlane.bulletList.get(i);
                        //将子弹对应的长方形找出来
                        Rectangle bulletRectangle = new Rectangle(bullet.x,bullet.y,bullet.width,bullet.height);
                        for(int j=0; j<this.enemyList.size();j++){  //拿到所有的敌机
                            AbstractEnemy enemy = this.enemyList.get(j);
                            //生成与敌机对应的长方形
                            Rectangle enemyRectangle = new Rectangle(enemy.x,enemy.y,enemy.width,enemy.height);
                            //如果子弹碰到了敌机
                            if(bulletRectangle.intersects(enemyRectangle)){
                                enemy.lifeValue -= bullet.hurtValue;
                                if(enemy.lifeValue <= 0){
                                //1.得分
                                Control.gameScore += 1;
                                //2.爆炸效果
        
                                //3.删除敌机:双删，不仅要从敌机列表中删除，还要从显示列表中删除
                                this.disList.remove(enemy);
                                this.enemyList.remove(enemy);
                                }            
                                //4.删除子弹：也是双删：从子弹列表和显示列表中删除
                                this.disList.remove(bullet);
                                this.playerPlane.bulletList.remove(bullet);
                                //子弹删除后就不能与其他的敌机在进行碰撞检测了，所以要结束内层的循环
                                continue;
                            }
                        }
                    }
                    //敌机和玩家飞机的碰撞检测
                    //遍历每一架敌机，与玩家飞机进行碰撞检测
                    for(int i=0; i<this.enemyList.size();i++){
                        AbstractEnemy enemy = this.enemyList.get(i);
                            //生成与敌机对应的长方形
                        Rectangle enemyRectangle = new Rectangle(enemy.x,enemy.y,enemy.width,enemy.height);

                        //生产玩家飞机对应的长方形
                        Rectangle playerRectangle = new Rectangle(this.playerPlane.x,this.playerPlane.y,
                                this.playerPlane.width,this.playerPlane.height);
                        //开始碰撞检测
                        if(enemyRectangle.intersects(playerRectangle)){
                            //游戏结束
                            this.gameWindow.gamePanel.repaint();
                            Control.gameState = Control.OVER;
                            
                            //清空显示列表
                            this.disList.clear();
                            //清空子弹列表
                            this.playerPlane.bulletList.clear();
                            //清空敌机列表
                            this.enemyList.clear();
                            //玩家飞机初始化
                            this.init();
                        }
                    }

                }
                //************************************************************ 
            }
        }
        //---------------------------------------------------------
    }
}