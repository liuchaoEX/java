package lesson;

import java.util.Scanner;
public class Example3_4 {
    //这个程序可以从键盘输入一个人的姓名和体重，输入完毕后将输入的姓名和体重显示到屏幕上
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name = reader.nextLine();
        System.out.println("请输入年龄");
        int age = reader.nextInt();
        System.out.println("输入体重");
        Double weight = reader.nextDouble();
        //输入接收到的数据
        System.out.println("欢迎您：" + name);
        System.out.println("你的年龄是：" + age);
        System.out.println("你的体重是：" + weight);
    }
}
