package lesson;

import java.awt.Image;
public class Plane{
    //定义数据，成员变量
    //所有的数据被private修饰，对其他的类不可见，也就是把这些数据封存了
    private int x = 55, y =99 ;
    private int width , height;
    private Image prcture;
    private int speed = 15;
    private boolean isFire;
    private int lifeValue;
    //如果有些数据需要其他的类看到，或者修改，需要添加一些方法：getter和setter方法
    //比如要看到控制类要看到飞机的坐标和大小，添加getter方法
    public int getX(){
        //用户校验
        return x;
    }
    public int getY(){
        return y;
    }
    public int getWidth(){
        return width;
    }
    public int getHight(){
        return height;
    }
    //还要修改飞机的速度，添加getter方法，用来显示，setter方法用来修改
    public int getSpeed(){
        return speed;
    }
    //提供setter方法，提供修改被封装的数据的手段
    public void setSpeed(int speed){
        this.speed = speed;
    }
    //定义功能，成员方法
    //开火
    void fire(int fireKind){
        //面向过程的编程
    }
    void eat(int toolFood){
    }
    void move(int speed){
    }
    void paintSelf(){
    }

}