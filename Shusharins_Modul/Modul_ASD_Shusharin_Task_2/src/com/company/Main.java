package com.company;
//Вариант 4, Задание 2, Шушарина Андрея.
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int n;
        boolean question;
	    System.out.print("Введите количество оценок: ");
	    n = getInt();
        int[] marksArray = new int[n];

        for (int i = 0;i < n; i++)
        {
            do {
                question = false;
                System.out.print("Введите "+(i+1)+" оценку: ");
                marksArray[i] = getInt();
                if (marksArray[i] > 100 || marksArray[i] < 0)
                {
                    System.out.println("Оценка задана в неверном диапозоне.");
                    question = true;
                }
            }while (question);
        }

        int[] newMarksArray = new int[n];

        for (int i = 0;i < n;i++)
        {
            newMarksArray[i] = marksArray[i];
        }

        for (int i = 0;i < n;i++)
        {
            if (newMarksArray[i] % 10 != 0 && newMarksArray[i] % 5 != 0 && newMarksArray[i] > 40)
            {
                if (newMarksArray[i] % 10 == 1 || newMarksArray[i] % 10 == 2)
                {
                    newMarksArray[i] = newMarksArray[i] - newMarksArray[i] % 10;
                }
                else if (newMarksArray[i] % 10 == 3 || newMarksArray[i] % 10 == 4 || newMarksArray[i] % 10 == 6 ||
                        newMarksArray[i] % 10 == 7)
                {
                    newMarksArray[i] = (newMarksArray[i] / 10) * 10 + 5;
                }
                else if (newMarksArray[i] % 10 == 8 || newMarksArray[i] % 10 == 9)
                {
                    newMarksArray[i] = (newMarksArray[i] - newMarksArray[i] % 10) + 10;
                }
            }
        }
        System.out.println("-----------------------------------------");
        System.out.println("| № з/п |Вхідний бал|Рзультат округлення|");
        System.out.println("-----------------------------------------");
        for (int i = 0; i < n; i++)
        {
            System.out.println("|"+ (i+1) +"      |"+marksArray[i]+"         |"+newMarksArray[i]+"                 |");
            System.out.println("-----------------------------------------");
        }

    }

    public static int getInt(){
        while(true)
        {
            int a;
            Scanner num = new Scanner(System.in);
            if (num.hasNextInt())
            {
                a = num.nextInt();
                return a;
            }
            else {
                System.out.print("Введённые вами данные не верны, пожалуйста повторите попытку: ");
            }
        }
    }
}
