/*
ПП-11
Бигдан Артемий
Вариант 4(2)
 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Реально непонятное задание. Мне кажется, оно никогда не выдаст ни одного результата");

            System.out.print("Введите размерность первого массива: ");
            int n = input.nextInt();
            System.out.print("Введите размерность второго массива: ");
            int m = input.nextInt();

            if (n < 1 || n > 10 || m < 1 || m > 10) {
                System.out.println("Не пытайтесь тестировать крайние случаи, вы разорвёте ткань реальности");
                return;
            }

            int[] arr1 = new int[n];
            int[] arr2 = new int[m];

            System.out.println("Заполняем вручную? [y/N]");

            char answer = input.next().toLowerCase().charAt(0);
            if (answer == 'y') {
                System.out.printf("Введите %d элементов первого массива:\n", n);
                for (int i=0; i < n; i++) {
                    int value = input.nextInt();
                    if (value < 1 || value > 100) {
                        System.out.println("У меня заканчиваются шутки, астанавитесь");
                        return;
                    }
                    arr1[i] = value;
                }
                System.out.printf("Введите %d элементов второго массива:\n", m);
                for (int i=0; i < m; i++) {
                    int value = input.nextInt();
                    if (value < 1 || value > 100) {
                        System.out.println("У меня заканчиваются шутки, астанавитесь");
                        return;
                    }
                    arr2[i] = value;
                }
            }
            else {
                Random random = new Random();
                for (int i=0; i < n; i++)
                    arr1[i] = random.nextInt(100) + 1;
                for (int i=0; i < m; i++)
                    arr2[i] = random.nextInt(100) + 1;
            }

            ArrayList<Integer> results = new ArrayList<Integer>();
            int cur = arr1[n-1];
            int end = arr2[0];
            for (; cur <= end; cur++) {
                boolean every = true;
                for (int i=0; i < n; i++)
                    if (cur % arr1[i] > 0) {
                        every = false;
                        break;
                    }
                if (!every)
                    continue;
                every = true;
                for (int i=0; i < m; i++)
                    if (arr2[i] % cur > 0) {
                        every = false;
                        break;
                    }
                if (!every)
                    continue;
                results.add(cur);
            }

            if (results.size() > 0) {
                System.out.println("А вот и числа, которые соответствуют условиям:");
                for (int v : results)
                    System.out.printf("%d ", v);
                System.out.println();
            } else {
                System.out.println("Чисел нет, но вы держитесь");
            }

            System.out.println("До побачення, телебачення");
        } catch (InputMismatchException e) {
            System.out.println("Та за шо");
            System.out.println("(неверный формат входных данных)");
        }
    }
}
