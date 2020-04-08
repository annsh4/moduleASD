package com.company;

import java.util.Scanner;

public class Main {

    static private int correctIntInput(int mode){
        int n =0;
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            if (in.hasNextInt()) {
                n = in.nextInt();
                if(mode == 1) {
                    if (n > 10 || n < 1) {
                        System.out.println("Введите целое число от 1 до 10!");
                    } else {
                        flag = false;
                    }
                }else{
                    if (n <= 0) {
                        System.out.println("Введите целое число от 1 до 100!");
                    } else {
                        flag = false;
                    }
                }
            } else {
                System.out.println("Введите целое число от 1 до 10!");
                flag = true;
                in.nextLine();
            }
        }
        return n;
    }

    static private int[] setArr(int length){
        int[] mat = new int[length];
        for(int i=0; i<length; i++) {
            mat[i] = correctIntInput(0);
        }
        return mat;
    }

    static private void showArr(int []mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.print(mat[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n1, n2;
        System.out.println("Введите размер массива1(от 1 до 10): ");
        n1 = correctIntInput(1);


        System.out.println("Введите размер массива2(от 1 до 10): ");
        n2 = correctIntInput(1);

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        System.out.println("Выберите метод заполнения массива1: ");
        System.out.println("Введите 1 для заполения вручную\nВведите любую строку для автозаполнения\n");
        String s;
        s = in.next();
        if(s.equals("1")){
            arr1 = setArr(n1);
        }else {
            for (int i = 0; i < n1; i++) {
                arr1[i] = (int) (Math.random() * 50);
            }
        }
        showArr(arr1);

        System.out.println("Выберите метод заполнения массива2(чтоб все работало, нужно чтоб элементы этого массива было больше первого): ");
        System.out.println("Введите 1 для заполения вручную\nВведите любую строку для автозаполнения\n");
        String s2;
        s2 = in.next();
        if(s2.equals("1")){
            arr2 = setArr(n2);
        }else {
            for (int i = 0; i < n2; i++) {
                arr2[i] = (int) (Math.random() * 50 + 50);
            }
        }
        showArr(arr2);
        int min = arr1[n1-1];
        int max = arr2[0];
        int [] temp = new int [(max-min)*n1];
        int count =0;
        boolean flag = true;
        for(int i=min; i<max; i++){
            flag = true;
            for(int j=0; j<n1; j++){
                if(i % arr1[j] != 0){
                    flag = false;
                }
            }
            if(flag){
                temp[count] = i;
                count++;
            }
        }

        for(int i=0; i<n2; i++){
            for(int j=0; j<count; j++){
                if(temp[j] == 0)
                    continue;
                if(arr2[i] % temp[j] != 0){
                    temp[j] = 0;
                }
            }
        }

        System.out.println("Найденые элементы: ");
        for(int i=0; i<temp.length; i++) {
            if(temp[i] == 0)
                continue;
            System.out.print(temp[i] + " ");
        }

    }

}
