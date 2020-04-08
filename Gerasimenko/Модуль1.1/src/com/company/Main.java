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
                flag = false;
            } else {
                System.out.println("Введите целое число!");
                flag = true;
                in.nextLine();
            }
        }
        return n;
    }

    static private int[][] setMat(int length){
        int[][] mat = new int[length][length];
        for(int i=0; i<length; i++){
            for(int j=0; j<length; j++) {
                mat[i][j] = correctIntInput();
            }
        }
        return mat;
    }

    static private void showMat(int [][]mat){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat.length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n;

        System.out.println("Введите размер матрицы: ");

        n = correctIntInput();

        int[][] mat = new int[n][n];

        System.out.println("Введите 1 для заполения вручную\nВведите любую строку для автозаполнения\n");
        String s;
        s = in.next();
        if(s.equals("1")){
            mat = setMat(n);
        }else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mat[i][j] = (int) (Math.random() * 200 - 100);
                }
            }
        }

        showMat(mat);

        int main = 0;
        for(int i=0; i<n; i++){
            System.out.print(mat[i][i] + " ");
                main += mat[i][i];
        }
        System.out.println("Сумма элементов главной диагонали: " + main);

        int secondary = 0;
        for(int i=0; i<n; i++){
            System.out.print(mat[i][n-i-1] + " ");
            secondary += mat[i][n-i-1];
        }
        System.out.println("Сумма элементов побочной диагонали: " + secondary);
        System.out.println("Абсолютная разница главной и побочной диагоналей: " + Math.abs(main-secondary));

    }
}
