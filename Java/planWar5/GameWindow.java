package planWar5;

import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.event.MouseInputListener;



public class GameWindow extends JFrame implements MouseInputListener,KeyListener{
    //声明一个接受飞机的空间变量
    PlayerPlane playerPlane;
    //让window拿到显示物集合
    LinkedList<Display> disList;

    //拿到被显示物的集合
    public void setDisList(LinkedList<Display> disList){
        this.disList = disList;
        this.gamePanel.disList = disList;
    }

    GamePanel gamePanel;
    //构造方法初始化窗口对象
    public GameWindow(){
        //初始化标题
        this.setTitle("飞机大战");
        //设置窗口的关闭方式
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        this.setResizable(false);
        this.pack();
        //绑定鼠标事件的监听器
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        //绑定键盘监听器
        this.addKeyListener(this);
    }
    //拿到玩家飞机
    public void setPlayerPlane(PlayerPlane playerPlane){
        this.playerPlane = playerPlane;
        //传给内部的gamePanel
        gamePanel.playerPlane = playerPlane;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        // 处理鼠标拖动事件
        this.playerPlane.x = e.getX() - (this.playerPlane.image.getWidth(null))/2;
        this.playerPlane.y = e.getY() - (this.playerPlane.image.getHeight(null))/2 - 30;
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        this.playerPlane.x = e.getX() - (this.playerPlane.image.getWidth(null))/2;
        this.playerPlane.y = e.getY() - (this.playerPlane.image.getHeight(null))/2 - 30;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mousePressed(MouseEvent e) {
        //this.playerPlane.isFire = true;
        
        
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        //this.playerPlane.isFire = false;
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void keyPressed(KeyEvent e) {
        // 键盘被按下
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(Control.gameState == Control.NORMAL){//游戏在正常状态，就然游戏进入暂停状态
                Control.gameState = Control.PAUSE;
                this.gamePanel.repaint();
            }
            else if(Control.gameState == Control.PAUSE){
                Control.gameState = Control.NORMAL;
            }
            else if(Control.gameState == Control.OVER){
                //清空成绩
                Control.gameScore = 0;
                Control.gameState = Control.NORMAL;
            }
        }
        
    }
    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

}
