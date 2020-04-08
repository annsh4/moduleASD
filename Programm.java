import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;


//ПП-11
//Грищенко Богдан
//Варіант 2(8)
public class Programm {
    public static void main(String[] args) {
        System.out.println("Введіть намер задачі");
        System.out.println("1 - Задача №1");
        System.out.println("2 - Задача №2");
        Scanner input=new Scanner(System.in);
        try {
            int x=input.nextInt();
            if(x==1){
                new Exercise_1();
            }
            else if(x==2){
                new Exercise_2();
            }
            else{
                System.out.println("Ви ввели невірні дані!");
            }
        } catch (InputMismatchException e) {
            System.out.println("Помилка!");
        }
    }
}
