package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("Введите количество значений: ");
            int n = input.nextInt();
            System.out.printf("Введите %d значений(я):\n", n);
            int[] values = new int[n];
            int[] results = new int[n];
            for (int i = 0; i < n; i++) {
                int value = input.nextInt();
                if (value < 0 || value > 100) {
                    System.out.println("Не не больше 100 нельзя");
                    return;
                }
                values[i] = value;
                int rounded = 5 * (int) Math.round(value / 5.0);
                if (rounded >= 40)
                    results[i] = rounded;
                else
                    results[i] = value;
            }
            System.out.println("Результат:");
            System.out.print("--------------------\n");
            System.out.print("|№  |Ввод|Результат|\n");
            for (int i = 0; i < n; i++)
                System.out.printf("|%d\t|%d\t |%d       |\n", i + 1, values[i], results[i]);
        } catch (InputMismatchException e) {
            System.out.println("Не правильно введенные данные!");
        }
    }
}