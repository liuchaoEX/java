package lesson;

import java.util.Scanner;//导入要用的Scanner类到当前的程序中
public class Class03 {
    public static void main(String[] args){
        //这个程序会帮助用户判断输入的某一年是否是闰年


        // 1)用户输入一个要过询的年份,我们利用Scanner类提供的输入功能
    //产生Scanner类中产生一个对象
        Scanner scanner = new Scanner(System.in);
    //给出输入提示
        System.out.println("请输入要查询年份：");

        // 2)拿到年份数据，存起来
        int year = scanner.nextInt();
        // 3)判断该年份是否符合闰年的条件（使用if语句）
        //什么样的年份是闰年，能被400整除的一定是，或者能被4整除且不能被100整除
        // 4)根据if判断，告知用户结果
        if(year%400==0 || (year%4==0 && year % 100 != 0) )
            System.out.println(year + "年是闰年");
        else
            System.out.println(year + "年不是闰年");

    }
}
