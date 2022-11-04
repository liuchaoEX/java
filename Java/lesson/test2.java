package lesson;

import java.util.Random;
import java.util.Scanner;
//导入函数
public class test2 {
    public static void main(String[] args){
        Random random = new Random();
        int answer = random.nextInt(100) + 1;
        Scanner scanner = new Scanner(System.in);
        int input = 0;
        int test2 = 0;
        do{
            System.out.println("请输入你猜的数字：");
            input = scanner.nextInt();
            if(input > answer)
                System.out.println("大了");
            else if(input < answer)
                System.out.println("小了");
            test2 ++;
        }while(input != answer);
        System.out.println("恭喜，你猜对了，一共猜了"+test2+"次");
    }
}
