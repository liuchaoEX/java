package planWar1;

import javax.swing.JFrame;

public class GameWindow extends JFrame{
    //声明一个接受飞机的空间变量
    PlayerPlane playerPlane;

    GamePanel gamePanel;
    //构造方法初始化窗口对象
    public GameWindow(){
        //初始化标题
        this.setTitle("飞机大战");
        //初始化可见性
        this.setVisible(true);
        //生成游戏面板
        gamePanel = new GamePanel();
        //初始化大小
        this.add(gamePanel);
        //初始化位置
        this.setSize(gamePanel.width,gamePanel.height);
        //添加游戏面板
        this.setLocationRelativeTo(null);
        //设置游戏的窗口，根据内容自适应大小
        this.pack();
    }
    //拿到玩家飞机
    public void setPlayerPlane(PlayerPlane playerPlane){
        this.playerPlane = playerPlane;
        //传给内部的gamePanel
        gamePanel.playerPlane = playerPlane;
    }

}
