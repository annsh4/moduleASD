
import java.util.Scanner;

public class Exercise_1 {

    Exercise_1() {
        int n,m;
        Scanner in = new Scanner(System.in);
        System.out.println("Введіть розмірність масиву №1 та №2");
        System.out.println("Розмірність масиву №1:(від 1 до 10)");
        n = in.nextInt();
        if (n>10 || n<0){
            System.out.println("Невірні дані!");
            System.exit(0);
        }
        System.out.println("Розмірність масиву №2:(від 1 до 10)");
        m = in.nextInt();
        if (m>10 || m<0){
            System.out.println("Невірні дані!");
            System.exit(0);
        }
        int[] massive1=new int[n];
        int[] massive2=new int[m];
        System.out.println("Розмірності: #1 - " + n + "  #2 - " + m);
        System.out.println("Бажаєте заповнити вручну?");
        System.out.println("Так - 1");
        System.out.println("Ні - 2");
        int question = in.nextInt();
        if (question == 1) {handFilling(n,m, massive1, massive2);}
        else if (question == 2) {autoFilling(n, m, massive1, massive2);
        } else {System.out.println("Помилка!");}

        myWork(n, m, massive1, massive2);

    }
    public void autoFilling(int n, int m, int[] massive1, int[] massive2){
        System.out.println("Масив №1 ");
        for(int i=0; i<n; i++){
            massive1[i]= (int) (Math.random() * 99+1);
            System.out.print(massive1[i]+" ");
        }

        System.out.println("\nМасив №2 ");
        for(int i=0; i<m; i++){
            massive2[i]=(int)(Math.random()*99+1);
            System.out.print(massive2[i]+" ");
        }
    }
    public static void handFilling(int n, int m, int[] massive1, int[] massive2){
        Scanner in= new Scanner(System.in);
        System.out.println("Введіть числа масиву №1");
        for(int i=0; i<n; i++){
            System.out.println("1 масив:");
            massive1[i]=in.nextInt();
            if(massive1[i]>100 || massive1[i]<0){
                System.out.println("Помилка!");
                System.exit(0);
            }
        }
        System.out.println("Введіть числа масиву №2");
        for(int i=0; i<m; i++){
            System.out.println("2 масив:");
            massive2[i]=in.nextInt();
            if(massive2[i]>100 || massive2[i]<0){
                System.out.println("Помилка!");
                System.exit(0);
            }
        }
    }
    public void myWork(int n, int m, int[] massive1, int[] massive2){
        int sizeMassive3=n+m;
        int [] massive3=new int[sizeMassive3];
        for(int i=0; i<n; i++){
            massive3[i]=massive1[i];
        }
        for(int i=n; i<sizeMassive3; i++){
            massive3[i]=massive2[i-n];
        }
        //копіювання першого та другого масиву
        int lastElementOfFirstArray=massive1[n-1];
        int firstElementOfSecondArray=massive2[0];
        boolean isSorted = false;
        int temp;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < massive3.length-1; i++) {
                if(massive3[i] > massive3[i+1]){
                    isSorted = false;

                    temp = massive3[i];
                    massive3[i] = massive3[i+1];
                    massive3[i+1] = temp;
                }
            }
        }

        //сортування масиву від найшменшого до найбільшого
        System.out.println();
        System.out.println("Обєднаний масив:");
        for (int i=0 ;i< massive3.length; i++){
            System.out.print(massive3[i]+ " ");
        }
        int indexOfFirst=0;
        int indexOfLast=0;
        for(int i=0; i<massive3.length; i++){
            if(lastElementOfFirstArray==massive3[i]){
                indexOfFirst=i;
            }
            if(firstElementOfSecondArray==massive3[i]){
                indexOfLast=i;
            }
        }
        int[] ourInterval = new int[0];
        try {
            ourInterval = new int[indexOfLast-indexOfFirst+1];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("ПОМИЛКА!!");
            System.exit(0);
        }
        boolean[] tryNumber= new boolean[ourInterval.length];
        try {
            boolean start=false;
            for(int i=0, j=0; i<massive3.length; i++){
                if(massive3[i]==lastElementOfFirstArray){
                    start=true;
                }
                if(start){
                    ourInterval[j]=massive3[i];
                    j++;
                }
                if(massive3[i]==firstElementOfSecondArray){
                    start=false;
                }
            }
            System.out.println("\nНаш інтервал:");
            for (int value : ourInterval) {
                System.out.print(value + " ");
            }
            tryNumber = new boolean[ourInterval.length];
            for(int i=0; i<ourInterval.length; i++){
                for(int j=0; j<massive1.length; j++){
                    if((ourInterval[i]%massive1[j])==0){
                        tryNumber[i]=true;
                    }
                    else {tryNumber[i]=false;}
                }
                for(int j=0; j<massive2.length; j++){
                    if( massive2[j]%ourInterval[i]==0){
                        tryNumber[i]=true;
                    }else{tryNumber[i]=false;}
                }
            }
        } catch (IndexOutOfBoundsException e ) {
            e.printStackTrace();
            System.out.println("ПОМИЛКА!!");
            System.exit(0);
        }
        System.out.println("\nЕлементи які  є діленими на елементи першого масиву та дільниками елементів другого масиву:");
        for(int i=0; i<ourInterval.length; i++){
            if(tryNumber[i]){
                System.out.print(ourInterval[i]+" ");
            }
        }
        //часто нічого не виводить через малоймовірну подію
    }
}
