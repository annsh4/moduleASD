package module;

import java.util.Scanner;

public class secondTask {
    private  static int Arr[];
    private  static int Ar2[];
    private static int m,n;
    secondTask(){
        createArray();
    }
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
        n = check();
        //System.out.println("введіть висоту масиву");
        Arr= new int[n];
        Ar2= new int[n];
        FillArray();
    }
    public static void FillArray() {
        int counter=0;
        for (int i = 0; i < n; i++) {
                System.out.println("Введите " + (counter += 1) + "-й элемент массива");
                Arr[i]=check();
                Ar2[i]=Arr[i];
            }
        PrintArray();
        result();
    }
    public static void PrintArray(){
        for (int i = 0; i < n; i++) {
            System.out.print(Ar2[i]+" ");
        }
        System.out.println("\n");
    }
    public static void round(){
      double doubleValue;
        for (int i = 0; i < n; i++) {
            double result;
            result=Ar2[i];
            if(result>40){
              doubleValue=result/5;
              int c = (int) Math.round(doubleValue);
              c=c*5;
              Ar2[i]=c;
            }
        }
    }
    public  static  void  result(){
        round();
       System.out.println("Вхідний бал"+"  Результат округлення");
        for (int i = 0; i < n; i++) {
            System.out.print(Arr[i]+"           "+Ar2[i]);
            System.out.print("\n");
        }
    }
}
