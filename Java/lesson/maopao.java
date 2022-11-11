package lesson;

import java.util.Random;
import java.util.Scanner;
public class maopao {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");
        int number = scanner.nextInt();
        int array[] = new int[number];
        Random random = new Random();
        for (int i = 0;i < array.length;i++){
            array[i] = random.nextInt(1000)+1;
        }
        for(int element : array){
            System.out.print(element + "   ");
        }
        System.out.println();
        int index = 0;
        int tmp = 0;
        for(int i=array.length-1;i>0;i--){
            index = 0;
            for(int j=0;j<i;j++){
                if(array[index] > array[index+1]){
                    tmp = array[index+1];
                    array[index + 1] = array[index];
                    array[index] = tmp;
                }
                index ++;
            }
        }
        for(int element : array){
            System.out.print(element + "   ");
        }
    }
}
