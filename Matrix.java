package com.company;

import java.util.Scanner;
import java.util.*;

public class Matrix {
    public void filling(){
        int sum1=0,sum2=0, abs_diff=0;
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть розмірність матриці: ");
        int len = in.nextInt();
        in.close();
        int arr[][]=new int[len][len];
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                arr[i][j] = (int)(Math.random()*(200+1)-100);
                System.out.print(arr[i][j] + "\t");
                if(i==j) sum1 += arr[i][j];
                if (i==len-j+1) sum2 +=arr[i][j];
            }
            System.out.println("\n");
        }
        System.out.println("Сума елементів головної діагоналі= "+sum1);
        System.out.println("Сума елементів побічної діагоналі= "+sum2);
        abs_diff=Math.abs(sum1-sum2);
        System.out.println("Абсолютна різниця= "+abs_diff);

    }
}
