package lesson;

import java.util.Scanner;
public class DaysInMonth {
    public static void main(String[] args){
        //判断用户要查询的某年某月有多少天
        //1.获取用户要查询的年份和月份，并且存起来
        Scanner scanner = new Scanner(System.in);
        //提示
        System.out.println("请输入年份");
        int year = scanner.nextInt();
        System.out.println("请输入月份");
        int month = scanner.nextInt();
        //2.在switch中进行判断，并输出结果
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println(year + "年" + month + "月有31天。");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println(year + "年" + month + "月有30天。");
                break;
            case 2:
                if(year%400==0 || (year%4==0 && year % 100 != 0) )
                    System.out.println(year + "年" + month + "月有29天。");
                else
                    System.out.println(year + "年" + month + "月有28天。");
                break;
            default:
                System.out.println("输入月份有误，请重新输入！");
        }
    }
}
