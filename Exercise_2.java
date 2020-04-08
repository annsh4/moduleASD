import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Exercise_2 {
    Exercise_2() {
        Scanner in = new Scanner(System.in);
        int amountGames = 0;
        int maxScore=0;
        int minScore=1000;
        int baddestGame=0;
        int bestGame=0;
        System.out.println("Бажаєте заповнити вручну?");
        System.out.println("Так - 1");
        System.out.println("Ні - 2");
        int question = in.nextInt();
        if (question == 1) {
            System.out.println("Введіть кількість ігор");
            System.out.println("Кількість ігор(від 1 до 100):");
            amountGames = in.nextInt();
            if (amountGames > 100 || amountGames < 0) {
                System.out.println("Невірні дані!");
                System.exit(0);
            }
                int[] resultGames = new int[amountGames];
                System.out.println("Введіть результат(від 1 до 1000)");
                System.out.println("для кожної гри");
                for (int i = 0; i < amountGames; i++) {
                    resultGames[i] = in.nextInt();
                    if (resultGames[i] > 1000 || resultGames[i] < 0) {
                        System.out.println("Невірні дані!");
                        System.exit(0);
                    }
                }
                for(int i=0; i<amountGames; i++) {
                    if (resultGames[i] < minScore) {
                        System.out.println("Знайдена гірша гра!");
                        System.out.println("Попередня найгірша гра:"+minScore);
                        minScore = resultGames[i];
                        System.out.println("Тепер найгірша гра:"+minScore);
                        baddestGame=i;

                    }
                    if (resultGames[i] > maxScore){
                        System.out.println("Знайдена краща гра!");
                        System.out.println("Попередня найкраща гра:"+maxScore);
                        maxScore=resultGames[i];
                        System.out.println("Тепер найкраща гра:"+maxScore);
                        bestGame=i;
                    }
                }

            } else if (question == 2) {
                amountGames = (int) (Math.random() * 100);
                int[] resultGames = new int[amountGames];
                for (int i = 0; i < amountGames; i++) {
                    resultGames[i] = (int) (Math.random() * 1000);
                }
            for(int i=0; i<amountGames; i++) {
                if (resultGames[i] < minScore) {
                    System.out.println("Знайдена гірша гра!");
                    System.out.println("Попередня найгірша гра:"+minScore);
                    minScore = resultGames[i];
                    System.out.println("Тепер найгірша гра:"+minScore);
                    baddestGame=i;
                }
                if (resultGames[i] > maxScore){
                    System.out.println("Знайдена краща гра!");
                    System.out.println("Попередня найкраща гра:"+maxScore);
                    maxScore=resultGames[i];
                    System.out.println("Тепер найкраща гра:"+maxScore);
                    bestGame=i;
                }
            }
            } else {
                System.out.println("Помилка!");
            }
        System.out.println();
        System.out.println("Кращий результат:");
        System.out.println(maxScore);
        System.out.println("Під час гри №"+bestGame);
        System.out.println("Гірший результат:");
        System.out.println(minScore);
        System.out.println("Під час гри №"+baddestGame);

        }
    }