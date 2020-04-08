package com.Khylko_ASDmodul;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task2 {
    static Scanner sc = new Scanner(System.in);
    public Task2(){
        List<Integer> realMarks = new LinkedList<>();
        List<Integer> roundedMarks = new LinkedList<>();
        int amountOfStudents = 0;
        try{
            System.out.println("Input number of students");
            amountOfStudents = sc.nextInt();
        }catch (Exception e) {
            System.out.println("Wrong input");
            System.exit(0);
        }
        int[] studentMarks = new int[amountOfStudents];
        for(int i = 0; i < amountOfStudents; i++){
            while (true){
                try{
                    System.out.println("Input mark of student " + (i + 1));
                    studentMarks[i] = sc.nextInt();
                    if(studentMarks[i] >= 1 && studentMarks[i] <= 100) {
                        if(roundIntegerToNearestFive(studentMarks[i]) >= 40){
                            realMarks.add(studentMarks[i]);
                            roundedMarks.add(roundIntegerToNearestFive(studentMarks[i]));
                        }else{
                            realMarks.add(studentMarks[i]);
                            roundedMarks.add(studentMarks[i]);
                        }
                        break;
                    }
                    else {
                        System.out.println("Mark must be in a range from 1 to 100 including");
                    }
                }catch (Exception e) {
                    System.out.println("Wrong input");
                    System.exit(0);
                }
            }
        }
        System.out.println("#\treal mark\trounded mark");
        for(int i = 0; i < realMarks.size(); i++){
            System.out.println((i+1) + "\t" + realMarks.get(i) + "\t\t\t" + roundedMarks.get(i));
        }
        System.out.println("1 - first task\n" +
                "2 - second task\n" +
                "0 - close program");
    }
    public static int roundIntegerToNearestFive(int num){
        if(num % 10 <= 2){
            return (int)Math.floor(num/10.0)*10;
        }
        else if(num % 10 <= 6){
            return (int)((Math.floor(num / 10.0) + 0.5)*10);
        }
        else return (int)(Math.ceil(num/10.0))*10;
    }
}
