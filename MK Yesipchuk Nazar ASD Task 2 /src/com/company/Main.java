package com.company;
import java.util.Scanner;

public class Main {
    public static int qua_games;
    public static int [] games;

    public static void menu(){
        int switch_num;
        System.out.println("Введите число матчей максимально(100) минимально (1)");
        qua_games = Check_num();
        games = new int[qua_games];
        System.out.println("Метод заполнения 1-Авто 2-В ручную");
        Scanner Input = new Scanner(System.in);
        switch_num = Input.nextInt();
        switch (switch_num){
            case 1: autoFill();
                break;
            case 2: manual_filling();
                break;
            default:autoFill();
        }
        result_games();
    }
    public static void manual_filling(){
        for(int i=0; i<qua_games; i++){
            System.out.println("Введите результат ["+(i+1)+"] игры");
            int case_num= Check_num1();
            games[i]=case_num;
        }
    }
    public static void autoFill(){
        for(int i=0; i<qua_games; i++) {
            games[i]=(int) (Math.random()*1001)-1;
            if(games[i]<=0)
                games[i]=1;
        }
    }

    public   static int Check_num() {
        int select_num=0 ;
        while (true) {
            Scanner Input_number = new Scanner(System.in);
            if (Input_number.hasNextInt()){
                select_num = Input_number.nextInt();
                if(select_num>=1 && select_num<=100)
                    break;
            }
            System.out.println("Введти число");
        }
        return select_num;
    }

    public   static int Check_num1() {
        int select_num=0 ;
        while (true) {
            Scanner Input_number = new Scanner(System.in);
            if (Input_number.hasNextInt()){
                select_num = Input_number.nextInt();
                if(select_num>=1 && select_num<=1000)
                    break;
            }
            System.out.println("Лучше вводить числа");
        }
        return select_num;
    }
    public static void result_games(){
        int best_result=1;
        int worst_result=games[0];

        for(int i=0; i<qua_games; i++){
            if(games[i]>=best_result){
                best_result=games[i];
            }else if(games[i]<= worst_result){
                worst_result=games[i];
            }

            System.out.println("\nИгра №"+(i+1));
            System.out.println("Результат "+games[i]);
            System.out.println("Лучший результат "+ best_result);
            System.out.println("Худший результат "+ worst_result);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        menu();
            System.out.println("Выберитайте 0-Выход ; 1-Продолжить ");
            Scanner Input = new Scanner(System.in);
            int switch_num = Input.nextInt();
            switch(switch_num){
                case 1:  menu();
                    break;
                case 0:
                    break;
                default: break;
            }
    }
}