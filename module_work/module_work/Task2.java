package module_work;
// работа Харламова Игоря ПП-11 Вариант 2 (2)
import java.util.Scanner;

public class Task2 {
    public static int quantity_games;
    public static int [] games;

    public static void menu(){
        int switch_number;
        System.out.println("Enter the quantity games max (100) min (1)");
        quantity_games = Check_num();
        games = new int[quantity_games];
        System.out.println("Input filling method 1-autofill 2-manually");
        Scanner Input = new Scanner(System.in);
        switch_number = Input.nextInt();
        switch (switch_number){
            case 1: autoFill();
            break;
            case 2: manual_filling();
            break;
            default:autoFill();
        }
        result_games();
    }
    public static void manual_filling(){
        for(int i=0; i<quantity_games; i++){
            System.out.println("Enter result the ["+(i+1)+"] games");
            int case_number = Check_num1();
            games[i]=case_number;
        }
    }
    public static void autoFill(){
        for(int i=0; i<quantity_games; i++) {
            games[i]=(int) (Math.random()*1001)-1;
            if(games[i]<=0)
                games[i]=1;
        }
    }

    public   static int Check_num() {
        int selected_num=0 ;
        while (true) {
            Scanner Input_number = new Scanner(System.in);
            if (Input_number.hasNextInt()){
                selected_num = Input_number.nextInt();
                if(selected_num>=1 && selected_num<=100)
                    break;
            }
            System.out.println("user do not enrage me and enter the number");
        }
        return selected_num;
    }

    public   static int Check_num1() {
        int selected_num=0 ;
        while (true) {
            Scanner Input_number = new Scanner(System.in);
            if (Input_number.hasNextInt()){
                selected_num = Input_number.nextInt();
                if(selected_num>=1 && selected_num<=1000)
                break;
            }
            System.out.println("user do not enrage me and enter the number");
        }
        return selected_num;
    }
    public static void result_games(){
        int best_result=1;
        int no_best_result=games[0];

        for(int i=0; i<quantity_games; i++){
            if(games[i]>=best_result){
                best_result=games[i];
            }else if(games[i]<=no_best_result){
                no_best_result=games[i];
            }

            System.out.println("\nGames №"+(i+1));
            System.out.println("Result "+games[i]);
            System.out.println("The Best Result "+ best_result);
            System.out.println("Worst Result "+ no_best_result);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
            boolean bool = true;
        menu();
       do {
           System.out.println("Enter 0-Exit ; 1-continue ");
           Scanner Input = new Scanner(System.in);
           int switch_number = Input.nextInt();
           switch(switch_number){
               case 1:  menu();
                        break;
               case 0:  bool=false;
                        break;
               default: break;
           }

       }while (bool);
    }
}
