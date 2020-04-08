// PP-11
// Dmytro Khylko
// Variant 4(17)
package com.Khylko_ASDmodul;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int taskNum;
        System.out.println("1 - first task\n" +
                "2 - second task\n" +
                "0 - close program");
        while (true) {
            try {
                taskNum = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong input");
                break;
            }
            if (taskNum == 0) {
                System.exit(0);
            } else if (taskNum == 1 || taskNum == 2) {
                switch (taskNum) {
                    case 1:
                        new Task1();
                        continue;
                    case 2:
                        new Task2();
                }
            } else {
                System.out.println("Incorrect number of operation\n" +
                        "Try again");
                System.out.println("1 - first task\n" +
                        "2 - second task\n" +
                        "0 - close program");
            }
        }
    }
}
