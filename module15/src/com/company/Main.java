package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

//ПП-11
//Терещук Анна
//Варіант 1 (15)
public class Main {

    public static void main(String[] args) {
        System.out.print("Введіть номер завдання: ");
        Scanner in = new Scanner(System.in);
        boolean input = true;
        try {
            while (input) {
                int task = in.nextInt();
                switch (task) {
                    case 1:
                        task1();
                        System.out.println("\nВведіть номер завдання: " +
                                "\nАбо вийдіть, натиснувши будь-яку клавішу");
                        break;
                    case 2:
                        task2();
                        System.out.println("Введіть номер завдання: " +
                                "\nАбо вийдіть, натиснувши будь-яку клавішу");
                        break;
                    default:
                        System.out.println("Завдання з таким номером не існує!");
                        input = false;
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Помилка! \nСпробуйте знову!");
        }
    }

    public static void task1() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть розмір матриці: ");
        try {
            int N = in.nextInt();
            if (N <= 0) {
                System.out.println("Розмір матриці не може бути від'ємним!");
            } else {
                int[][] arr = new int[N][N];
                System.out.println("Введіть номер меню: " +
                        "\n(1)Автозаповнення матриці" +
                        "\n(2)Ручне заповнення матриці");
                int number = in.nextInt();
                switch (number) {
                    case 1:
                        for (int i = 0; i < N; ++i) {
                            for (int j = 0; j < N; ++j) {
                                arr[i][j] = (int) ((Math.random() * 200) - 100);
                            }
                        }
                        for (int i = 0; i < N; ++i) {
                            for (int j = 0; j < N; ++j) {
                                System.out.print(arr[i][j] + "\t");
                            }
                            System.out.println();
                        }
                        absoluteDifference(arr);
                        break;
                    case 2:
                        for (int i = 0; i < N; i++) {
                            for (int j = 0; j < N; j++) {
                                System.out.print((i+1) + " " + (j +1) + " ");
                                arr[i][j] = in.nextInt();
                            }
                        }
                        for (int i = 0; i < N; ++i) {
                            for (int j = 0; j < N; ++j) {
                                System.out.print(arr[i][j] + "\t");
                            }
                            System.out.println();
                        }
                        absoluteDifference(arr);
                        break;
                    default:
                        System.out.println("Меню з таким номером не існує!");
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Помилка! \nСпробуйте знову!");
        }
    }

    public static void absoluteDifference(int[][] arr) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < arr.length; i++) {
            sum1 = sum1 + arr[i][i];
            sum2 = sum2 + arr[arr.length - i - 1][i];
        }
        int diff = sum2 - sum1;
        System.out.println("Абсолютна різниця сум діагоналей матриці: " + Math.abs(diff));
    }

    public static void task2() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введіть кількість студентів: ");
        int size = in.nextInt();
        int[] studentsArray = new int[size];
        System.out.print("Введіть бали студентів від 0 до 100: ");
        boolean input;
        for (int i = 0; i < size; i++) {
            System.out.print((i + 1) + ". ");
            input = false;
            while (!input) {
                studentsArray[i] = in.nextInt();
                if (studentsArray[i] < 0 || studentsArray[i] > 100) {
                    input = false;
                    System.out.println("Помилка! \nСпробуйте знову!");
                } else input = true;
            }
        }
        System.out.println("+------+------------+--------------------+");
        System.out.printf("|%-6s|%-12s|%-12s|\n", "№ з/п", "Вхідний бал", "Результат округлення");
        System.out.println("+------+------------+--------------------+");
        for (int i = 0; i < size; i++) {
            if (studentsArray[i] >= 37) {
                int dozens = studentsArray[i] / 10;
                int ones = studentsArray[i] % 10;
                if (ones <= 2) {
                    ones = 0;
                } else if (ones <= 6) {
                    ones = 5;
                } else {
                    ones = 10;
                }
                int rounding = dozens * 10 + ones;
                System.out.printf("|%-6d|%-12d|%-20d|\n", (i + 1), studentsArray[i], rounding);
            } else {
                int rounding = studentsArray[i];
                System.out.printf("|%-6d|%-12d|%-20d|\n", (i + 1), studentsArray[i], rounding);
            }
        }
        System.out.println("+------+------------+--------------------+");
    }
}
