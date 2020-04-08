package com.company;

import java.util.Scanner;

public class Marks {
    public void tasks(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть розмірність n (0-100): ");
        int n = in.nextInt();
        int[] mark = new int[n]; //оцінки
        int[] markE = new int[n]; //відкориговані оцінки
        for(int i=0; i<n; i++){
            System.out.print("Введіть оцінку. mark= ");
            mark[i]=in.nextInt();
            //int mark1=mark%10, mark2=(mark/10)%10,mark3=(mark/100); //розкладання оцінки на цифри
            if (mark[i]<=40)
                    markE=mark;
            else markE[i] = 5 *(int)Math.round(mark[i]/5.0);
        }

        for(int i=0; i<n; i++){ //виведення результату
            System.out.printf("%d\t%d\t%d\n", i+1, mark[i], markE[i]);
        }
        System.out.print("\n");
        in.close();
    }
}
