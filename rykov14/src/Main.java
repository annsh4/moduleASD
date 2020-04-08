import java.util.*;

import static java.lang.Math.abs;

public class Main {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        boolean ing = true;
        while (ing) {
            try {
                System.out.print("Введите номер задания(1,2) или 0 для выхода: ");
                int task = in.nextInt();
                switch (task) {
                    case 0:
                        ing = false;
                        break;
                    case 1:
                        task1();
                        break;
                    case 2:
                        task2();
                        break;
                    default:
                        System.out.println("неа)");
                }
            } catch (InputMismatchException e) {
                System.out.println("неа)");
            }
        }
    }

    public static void task1() {
        System.out.println("Рыков Владислав Сергеевич, ПП11, 14 номер в списке, 5ый вариант");

        System.out.print("введите длинну в масива: ");
        int n = in.nextInt();
        if (n < 1) {
            System.out.println("неа)");
            return;
        }
        int[][] matriks = new int[n][n];

        boolean b = true;
        while (b) {
            try {
                System.out.print("1 для автозаолнения, 2 для изер заполнения: ");
                int varia = in.nextInt();
                switch (varia) {
                    case 1:
                        randFilling(matriks);
                        b = false;

                        break;
                    case 2:
                        userFill(matriks);
                        b = false;

                        break;
                    default:
                        System.out.println("неа)");
                }
            } catch (InputMismatchException e) {
                System.out.println("неа)");
            }
        }
        System.out.println("\nматрица: ");
        for (int[] matrik : matriks) {
            {
                for (int i : matrik) {
                    System.out.print(i + "   ");
                }
                System.out.println();
            }
        }
        System.out.println("\nответ = " + ans(matriks));


    }

    public static double ans(int[][] matriks) {
        int a = 0;
        int b = 0;
        int c = matriks.length;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                if (i == j) {
                    a += matriks[i][j];
                }
                if (i == (c - j - 1)) {
                    b += matriks[i][j];
                }
            }
        }
        return abs(a - b);
    }

    public static void randFilling(int[][] matriks) {
        for (int i = 0; i < matriks.length; i++) {
            for (int j = 0; j < matriks[i].length; j++) {
                matriks[i][j] = (int) (Math.random() * 200 - 100);
            }
        }
    }

    public static void randFilling(int[] matriks) {
        for (int i = 0; i < matriks.length; i++) {
            matriks[i] = (int) (Math.random() * 100 + 1);
        }

    }

    public static void userFill(int[][] matriks) {
        try {
            for (int i = 0; i < matriks.length; i++) {
                for (int j = 0; j < matriks[i].length; j++) {
                    System.out.print("введите число: ");
                    matriks[i][j] = in.nextInt();

                }
            }
        } catch (InputMismatchException e) {
            System.out.println("ну зачем так делать... просили то число...");
        }
    }

    public static void userFill(int[] matriks) {
        try {
            for (int i = 0; i < matriks.length; i++) {

                System.out.print("введите число: ");
                matriks[i] = in.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("ну зачем так делать... просили то число...");
        }
    }

    public static void task2() {
        System.out.print("введите длинну в 1масива: ");
        int n = in.nextInt();
        if (n < 1 || n > 10) {
            System.out.println("неа)");
            return;
        }
        System.out.print("введите длинну в 2масива: ");
        int m = in.nextInt();
        if (m < 1 || m > 10) {
            System.out.println("неа)");
            return;
        }
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        boolean b = true;
        while (b) {
            try {
                System.out.print("1 для автозаолнения, 2 для изер заполнения : ");
                int varia = in.nextInt();
                switch (varia) {

                    case 1:
                        randFilling(arr1);
                        randFilling(arr2);

                        b = false;

                        break;
                    case 2:
                        userFill(arr1);
                        userFill(arr2);
                        b = false;

                        break;
                    default:
                        System.out.println("неа)");
                }
            } catch (InputMismatchException e) {
                System.out.println("неа)");
            }
        }
        secondAns(arr1, arr2);

    }

    public static void secondAns(int[] firstm, int[] secondm) {
        int min = firstm[firstm.length - 1];
        int max = secondm[0];

        Arrays.sort(firstm);
        Arrays.sort(secondm);

        System.out.println("ответ: ");
        for (int i = min; i < max; ++i) {
            if (checkFirstCond(i, firstm) && checkSecondCond(i, secondm)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    private static boolean checkFirstCond(int a, int[] firstm) {

        for (int i : firstm) {
            if (a % i != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkSecondCond(int a, int[] secondm) {
        for (int i : secondm) {
            if (i % a != 0) {
                return false;
            }
        }
        return true;
    }
}
