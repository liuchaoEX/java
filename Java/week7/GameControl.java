package week7;
public class GameControl {
    public static void main(String[] args) {
        //完成游戏的控制
        //创建一个游戏的界面
        GameWindow gameWindow = new GameWindow();
        //创建一个飞机对象
        Plane plane = new Plane();
        //调用gameWindow中的setPlane()方法,是gameWindow得到plane对象
        gameWindow.setPlane(plane);
        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        
        plane.move(400, 400);
        gameWindow.repaint();
    }
}
