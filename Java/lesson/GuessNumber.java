package lesson;

import java.util.Random;
import java.util.Scanner;
public class GuessNumber {
    public static void main(String[] args){
    //猜数字小游戏，1-100
    //1.产生一个随机答案，存起来
        Random random = new Random(); //产生一个Random对象
        int answer = random.nextInt(100) + 1;

        Scanner scanner = new Scanner(System.in);
        int input = 0;//该变量保存玩家输入的猜测的数
        int GuessNumber = 0;//该变量保存猜的次数
        //2.判断如果猜错了，就重复下面的环节，才对循环结束
        do{
        //3.获得玩家猜测的数，存起来
            System.out.println("请输入你猜的数：");//输入前给输入的提示
            input = scanner.nextInt();
        //4.判断大小，并提示，每次猜完，次数加1
            if(input > answer)
                System.out.println("大了");
            else if(input < answer)
                System.out.println("小了");
            GuessNumber ++;
        }while(input != answer);
        //5.提示：恭喜，猜对了，你一共猜了n次
        System.out.println("恭喜，猜对了，你一共猜了"+GuessNumber+"次");
    }
}
