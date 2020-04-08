package com.company;

import java.util.Scanner;

public class Main {

    static private int correctIntInput(){
        int n =0;
        Scanner in = new Scanner(System.in);
        boolean flag = true;
        while(flag) {
            if (in.hasNextInt()) {
                n = in.nextInt();
                if(n > 10 || n < 1){
                    System.out.println("Введите целое число от 1 до 10!");
                }else{
                    flag = false;
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
            mat[i] = correctIntInput();
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
        n1 = correctIntInput();

        System.out.println("Введите размер массива2(от 1 до 10): ");
        n2 = correctIntInput();

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
                arr1[i] = (int) (Math.random() * 100);
            }
        }
        showArr(arr1);

        System.out.println("Выберите метод заполнения массива2: ");
        System.out.println("Введите 1 для заполения вручную\nВведите любую строку для автозаполнения\n");
        String s2;
        s2 = in.next();
        if(s2.equals("1")){
            arr2 = setArr(n2);
        }else {
            for (int i = 0; i < n2; i++) {
                arr2[i] = (int) (Math.random() * 100);
            }
        }
        showArr(arr2);

        int max,min;

        if(arr2[0] > arr1[n1-1]){
            max = arr2[0];
            min = arr1[n1-1];
        }else{
            min = arr2[0];
            max = arr1[n1-1];
        }

        int[] temp = new int[n1+n2];
        int count = 0;
        for(int i=0; i<n1; i++){
            if(arr1[i] > max || arr1[i] < min)
                continue;
            temp[count] = arr1[i];
            count++;
        }
        for(int i=0; i<n2; i++){
            if(arr2[i] > max || arr2[i] < min)
                continue;
            temp[count] = arr2[i];
            count++;
        }
        showArr(temp);

        System.out.println("Найденые элементы: ");
        for(int i=0; i<n2; i++) {
            if (arr2[i] % temp[i] == 0) {
                System.out.print(temp[i] + " ");
            }
        }
    }
}
