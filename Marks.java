package com.company;

import java.util.Scanner;

public class Marks {
    public void tasks(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть розмірність n (0-100): ");
        int n = in.nextInt();
        for(int i=0; i<n; i++){
            mark=in.nextInt();
            int mark1=mark%10, mark2=(mark/10)%10,mark3=(mark/100); //розкладання оцінки на цифри
            System.out.print(n+"\t");
            System.out.print(mark+"\t");
            System.out.print(mark1+" "+mark2+" "+mark3+"\t");
        }
        System.out.print("\n");
        for(int i=0; i<n; i++){
        }
        if(mark<40) mark=0; //неуспіх
        in.close();
    }
}
