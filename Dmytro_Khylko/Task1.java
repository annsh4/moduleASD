package com.Khylko_ASDmodul;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Task1 {
    static Scanner sc = new Scanner(System.in);
    public Task1(){
        fillArrays();
    }
    public static void fillArrays(){
        //// deal with first array /////
        System.out.println("Input size of first array");
        int firstArrSize;
        while (true){
            try{
                firstArrSize = sc.nextInt();
                if(firstArrSize >= 1 && firstArrSize <= 10) break;
                else System.out.println("Size must be in a range from 1 to 10 including");
            }catch (Exception e) {
                System.out.println("Wrong input");
                System.exit(0);
            }
        }
        int[] firstArr = new int[firstArrSize];
        System.out.println("Would you like to fill first array manually? (Y/N)");
        String answer;
        while (true) {
            try {
                answer = sc.next();
                if(answer.equalsIgnoreCase("y")){
                    System.out.println("Input array elements");
                    fillArray(firstArr, firstArrSize);
                    break;
                }
                else if(answer.equalsIgnoreCase("n")){
                    for(int i = 0; i < firstArrSize; i++){
                        firstArr[i] = (int)(Math.random()*((100 -1)+1))+1;
                    }
                    System.out.println(Arrays.toString(firstArr));
                    break;
                }else System.out.println("Incorrect answer. Type again");
            } catch (Exception e) {
                System.out.println("Wrong input");
                System.exit(0);
            }
        }
        /// deal with second array ////

        System.out.println("Input size of second array");
        int secondArrSize;
        while (true){
            try{
                secondArrSize = sc.nextInt();
                if(secondArrSize >= 1 && secondArrSize <= 10) break;
                else System.out.println("Size must be in a range from 1 to 10 including");
            }catch (Exception e) {
                System.out.println("Wrong input");
                System.exit(0);
            }
        }
        int[] secondArr = new int[secondArrSize];
        System.out.println("Would you like to fill first array manually? (Y/N)");
        String newAnswer;
        while (true) {
            try {
                newAnswer = sc.next();
                if(newAnswer.equalsIgnoreCase("y")){
                    System.out.println("Input array elements");
                    fillArray(secondArr, secondArrSize);
                    break;
                }
                else if(newAnswer.equalsIgnoreCase("n")){
                    for(int i = 0; i < secondArrSize; i++){
                        secondArr[i] = (int)(Math.random()*((100 -1)+1))+1;
                    }
                    System.out.println(Arrays.toString(secondArr));
                    break;
                }else System.out.println("Incorrect answer. Type again");
            } catch (Exception e) {
                System.out.println("Wrong input");
                System.exit(0);
            }
        }
        /////// task logic ////
        if(firstArr[firstArrSize - 1] - secondArr[secondArrSize - 1] >= -1){
            System.out.println("There is no range between last element of first array and first element of second array");
            System.out.println("1 - first task\n" +
                    "2 - second task\n" +
                    "0 - close program");
        }else{
            int betweenNum = firstArr[firstArrSize - 1] + 1;
            List<Integer> allNumbers = new LinkedList<>();
            while(betweenNum < secondArr[secondArrSize - 1]) {
                boolean matches = true;
                for (int i = 0; i < firstArrSize; i++) {
                    if (betweenNum % firstArr[i] != 0) {
                        matches = false;
                        break;
                    }
                }
                if (!matches) {
                    betweenNum++;
                    continue;
                }
                for(int i = 0; i < secondArrSize; i++){
                    if (secondArr[i]%betweenNum != 0) {
                        matches = false;
                        break;
                    }
                }
                if(matches) allNumbers.add(betweenNum);
                betweenNum++;
            }
            System.out.println("Result list of numbers" + allNumbers);
            System.out.println("1 - first task\n" +
                    "2 - second task\n" +
                    "0 - close program");
        }

    }
    public static void fillArray(int[] arr, int size){
        try {
            for (int i = 0; i < size; i++) {
                int arrElement = sc.nextInt();
                if (arrElement < 1 || arrElement > 100) {
                    System.out.println("Incorrect value of array element. Try again");
                    i--;
                }else arr[i] = arrElement;
            }
        }catch(Exception e){
            System.out.println("Wrong input of array elements");
        }
    }
}
