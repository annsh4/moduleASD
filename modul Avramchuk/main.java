package module;

import java.util.Scanner;

public class main {
    private  static int Arr[][];
    private static int n,m;
    private static double d;

    public static int  check(){
        try {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            return a;
        } catch (java.util.InputMismatchException e) {
            System.out.println("Ви ввели невірні дані!");
            int b=10;
            return b;
        }
    }
    public static void createArray(){
            System.out.println("введіть довжину масиву");
            m = check();
            //System.out.println("введіть висоту масиву");
            n = m;
            Arr= new int[n][m];
            menu();
    }
    public static void FillArray() {
        int counter=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Введите " + (counter += 1) + "-й элемент массива");
                Arr[i][j]=check();
            }
        }
       result();
    }
    public static void Random(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arr[i][j] = (int) Math.round((Math.random() * 200) - 100);
            }
        }
    result();
    }
    public static void PrintArray(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(Arr[i][j]+" ");
            }
            System.out.print("\n");
        }
    }
    public static void Diagonal(){
    int a=Arr.length;
    d=a*Math.sqrt(2);
    }
    public static void main(String[] args) {
    createArray();

    }
    public static void result(){
        PrintArray();
        Diagonal();
        System.out.print("діагональ"+d );
        System.out.print("\n");
        System.out.println("Задача 2.");
        secondTask secondTask =new secondTask();
    }
    public static void menu() {
        try {
            System.out.println("1- заповнення ручками . 2-заповнення автоматично  4-Exit");
            Scanner sca = new Scanner(System.in);
            int chose = 0;
            chose = sca.nextInt();

            switch (chose) {
                case 1:
                    FillArray();
                    break;
                case 2:
                    Random();
                    break;
                case 3:
                    PrintArray();
                    break;
                case 4:
                    System.exit(0);
                default:
                    menu();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Ви ввели невірні дані!");
            menu();
        }
    }
}
