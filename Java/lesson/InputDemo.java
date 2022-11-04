package lesson;

import java.util.Scanner;//导入
public class InputDemo {
    public static void main(String[] args){
        //让用户把名字和学号输入进程序
        //产生Scanner的对象
        Scanner scanner = new Scanner(System.in);
        //使用scanner调用输入方法
        //在让用户输入数据的时候，要有输入提示
        System.out.println("请输入你的姓名：");
        String name = scanner.nextLine();
        //给一个输入成功的提示：
        System.out.println("欢迎您" + name);
    }
}
