package planWar5;

public class Play {
    public static void main(String[] args) {
        //创建游戏控制对象
        Control control = new Control();
        //利用Control对象创建一个线程，并且启动
        Thread t1 = new Thread(control);
        t1.start();
    }
}
