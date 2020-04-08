//Варіант №1
package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


        //Завдання №1
        boolean f1 = false;
        while (!f1) {
            try {


                Scanner in = new Scanner(System.in);

                System.out.print("Введіть розмір масивів: ");

                int N = in.nextInt();

                int[][] A = new int[N][N];

                System.out.println("Можливі два варіанти заповнення масиву:");
                System.out.println("1. Ввід даних вручну з консолі");
                System.out.println("2. Рандомне заповнення масиву");

                int x = 0;
                boolean p = false;
                while (!p) {
                    System.out.print("Ваш вибір:");
                    x = in.nextInt();
                    if (x != 1 && x != 2 ) {
                        System.out.println("Помилка!!! Введіть ще раз");
                        p = false;
                    } else p = true;
                }


                switch (x) {
                    case 1:
                        for (int i = 0; i < N; i++) {
                            for (int j = 0; j < N; j++) {

                                System.out.print((i + 1) + " " + (j + 1) + ". ");
                                A[i][j] = in.nextInt();
                            }
                        }
                        break;
                    case 2:
                        for (int i = 0; i < N; i++) {
                            for (int j = 0; j < N; j++) {
                                A[i][j] = (int) ((Math.random() * 200) - 100);
                            }
                        }
                        break;
                    default:
                        break;
                }


                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        System.out.printf("%4s", A[i][j] +" ");
                    }
                    System.out.print("\n");
                }

                int sum_1 = 0;

                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {

                        sum_1 = sum_1 + A[i][j];
                        i++;

                    }
                }
                System.out.println(sum_1);

                int sum_2 = 0;

                for (int i = N - 1; i >= 0; i--) {
                    for (int j = 0; j < N; j++) {

                        sum_2 = sum_2 + A[i][j];
                        i--;

                    }
                }
                System.out.println(sum_2);

                int a = sum_1 - sum_2;

                System.out.println(Math.abs(a));
                f1 = true;
            } catch (InputMismatchException e) {
                f1 = false;
                System.out.println("Помилка! Введіть дані ще раз!");
            }
        }

        //Завдання №2

        boolean f2 = false;
        System.out.print("Введіть кількість студентів: ");
        while (!f2) {
            try {

                Scanner in = new Scanner(System.in);
                boolean b;
                int size = in.nextInt();
                if (size <= 0) {
                    f2 = false;
                    System.out.println("Помилка! Введіть кількість студентів ще раз!");
                } else {
                    int[] Array = new int[size];
                    for (int i = 0; i < size; ) {

                        b = false;
                        while (!b) {
                            System.out.print((i + 1) + ". ");
                            Array[i] = in.nextInt();
                            if (Array[i] < 0 || Array[i] > 100) {
                                b = false;
                                System.out.println("Помилка!Введіть ще раз");

                            } else b = true;
                        }
                        i++;
                    }

                    int t;
                    System.out.println("|——————————————————————————————————————|");
                    System.out.printf("|%6s|%15s|%15s|\n", "№ з/п", "Вхідний бал", "Округлений бал");
                    System.out.printf("|%6s|%15s|%15s| \n", "——————", "———————————————", "———————————————");
                    for (int i = 0; i < size; i++) {

                        if (Array[i] >= 37) {
                            int decade = Array[i] / 10;
                            int ones = Array[i] % 10;
                            if (ones <= 2) {
                                ones = 0;
                            } else if (ones <= 6) {
                                ones = 5;
                            } else {
                                ones = 10;
                            }
                            t = decade * 10 + ones;

                        } else {
                            t = Array[i];

                        }
                        System.out.printf("|%6d|%15d|%15d| \n", (i + 1), Array[i], t);
                        System.out.printf("|%6s|%15s|%15s| \n", "——————", "———————————————", "———————————————");
                    }
                    f2 = true;
                }
            }catch(InputMismatchException e){
                f2 = false;
                System.out.println("Помилка! Введіть кількість студентів ще раз!");
            }
        }

    }

}