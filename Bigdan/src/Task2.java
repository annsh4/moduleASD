/*
ПП-11
Бигдан Артемий
Вариант 4(2)
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Округление значений [0..100] до ближайшего кратного 5, если это кратное не ниже 40");

            System.out.print("Введите количество значений: ");
            int n = input.nextInt();

            System.out.printf("Введите %d значений(я):\n", n);
            int[] values = new int[n];
            int[] results = new int[n];
            for (int i = 0; i < n; i++) {
                int value = input.nextInt();
                if (value < 0 || value > 100) {
                    System.out.println("В условии обещали, что значения будут в диапазоне [0..100], до свидания");
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
            for (int i = 0; i < n; i++)
                System.out.printf("%d\t%d\t%d\n", i + 1, values[i], results[i]);
            System.out.println("Спасибо за использование, приходите ещё");
        } catch (InputMismatchException e) {
            System.out.println("Как говорил мне мой врач: \"Зачем же ты расковырял?\"");
            System.out.println("(неверный формат входных данных)");
        }
    }
}
