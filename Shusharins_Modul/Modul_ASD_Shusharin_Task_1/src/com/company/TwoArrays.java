package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class TwoArrays {

    public static int size_arr1;
    public static int size_arr2;
    public static int [] array1;
    public static int [] array2;
    public static boolean question;


    public static void menu()
    {
        do {
            question = false;
            System.out.print("Введите размер первого массива (от 1 до 10 включитьельно): ");
            size_arr1 = getInt();
            if (size_arr1 > 10 || size_arr1 < 1)
            {
                question = true;
            }
        }while (question);

        do {
            question = false;
            System.out.print("Введите размер второго массива (от 1 до 10 включитьельно): ");
            size_arr2 = getInt();
            if (size_arr2 > 10 || size_arr2 < 1)
            {
                question = true;
            }
        }while (question);

        array1 = new int[size_arr1];
        array2 = new int[size_arr2];
        System.out.println("Выберете способ заполнения первого массива.");
        System.out.println("1. Автоматический");
        System.out.println("2. В ручную");
        System.out.print("Ответ: ");
        Scanner input = new Scanner(System.in);
        int switch_number = input.nextInt();
        switch (switch_number) {
            case 1:
                autoFill1();
                break;
            case 2:
                handsFill1();
                break;
            default:
                autoFill1();
        }

        System.out.println("Выберете способ заполнения второго массива.");
        System.out.println("1. Автоматический");
        System.out.println("2. В ручную");
        System.out.print("Ответ: ");
        switch_number = input.nextInt();
        switch (switch_number) {
            case 1:
                autoFill2();
                break;
            case 2:
                handsFill2();
                break;
            default:
                autoFill2();
        }
        findArray();
    }

    public static void autoFill1(){
        for(int i=0; i<size_arr1; i++) {
            array1[i]=(int) (Math.random()*101)-1;
            if(array1[i]<=0)
                array1[i]=1;
        }
    }

    public static void autoFill2(){
        for(int i=0; i<size_arr2; i++) {
            array2[i]=(int) (Math.random()*101)-1;
            if(array2[i]<=0)
                array2[i]=1;
        }
    }

    public static void handsFill1(){
        for(int i=0; i<size_arr1; i++){
            do {
                question = false;
                System.out.print("Введите число "+(i+1)+" для первого массива: ");
                array1[i] = getInt();
                if (array1[i] > 100 || array1[i] < 1)
                {
                    question = true;
                }
            }while (question);
        }
    }
    public static void handsFill2(){
        for(int i=0; i<size_arr2; i++){
            do {
                question = false;
                System.out.print("Введите число "+(i+1)+" для второго массива: ");
                array2[i] = getInt();
                if (array2[i] > 100 || array2[i] < 1)
                {
                    question = true;
                }
            }while (question);
        }
    }

    public static void findArray()
    {
        ArrayList<Integer> resultArray = new ArrayList<>();
        int start = array1[size_arr1-1];
        int end = array2[0];

        for (; start < (end+1); start++) {
            question = true;
            for (int i=0; i < size_arr1; i++)
                if (start % array1[i] != 0) {
                    question = false;
                    break;
                }
            if (!question)
                continue;
            question = true;
            for (int i=0; i < size_arr2; i++)
                if (array2[i] % start != 0) {
                    question = false;
                    break;
                }
            if (!question)
                continue;
            resultArray.add(start);
        }

        if (resultArray.size() > 0) {
            System.out.println("Массив чисел подходящих под условия: ");
            for (int v : resultArray)
            {
                int i = 1;
                System.out.println(i + ") " + v);
                i++;
            }
            System.out.println();
        } else {
            System.out.println("Числа подходящие под условия не найдены");
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
