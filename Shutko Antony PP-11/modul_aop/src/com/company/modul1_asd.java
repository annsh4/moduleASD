package com.company;
import java.util.Random;
import java.util.Scanner;

public class modul1_asd
{
    static int get_int()
    {
        int choise_num;
        while (true)
        {
            final Scanner num = new Scanner(System.in);
            if (num.hasNextInt())
            {
                choise_num = num.nextInt();
                break;
            }
            System.out.println("it is not integer");
        }
        return choise_num;
    }

    public static void main(String []args)
    {
        sumOfDiagonalSquare();
        task2NonNameing();
    }

    static void sumOfDiagonalSquare()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter size of square");
        int sizeSquare = get_int();
        int [][]square = new int[sizeSquare][sizeSquare];
        System.out.println("do you want fill array automatically?\ny-yes\nn-no");
        Random random = new Random();
        char answer = input.next().toLowerCase().charAt(0);
        if (answer == 'y')
        {
            for (int i=0; i<sizeSquare; i++)
            {
                for (int j=0; j<sizeSquare; j++)
                {
                    square[i][j]=(random.nextInt(201))-100;
                }
            }
        }
        else
        {
            System.out.println("enter elements of square");
            for (int i=0; i<sizeSquare; i++)
            {
                for (int j=0; j<sizeSquare; j++)
                {
                    square[i][j]=get_int();
                }
            }
        }
        int differenceSumDiagonales=0;
        for (int i=0; i<sizeSquare; i++)
        {
            differenceSumDiagonales+=square[i][i];
            differenceSumDiagonales-=square[i][sizeSquare-1-i];
        }
        differenceSumDiagonales=Math.abs(differenceSumDiagonales);
        for (int i=0; i<sizeSquare; i++)
        {
            for (int j=0; j<sizeSquare; j++)
            {
                System.out.print(square[i][j]+"  ");
            }
            System.out.println();
        }
        System.out.println("\n"+differenceSumDiagonales);
    }

    static void task2NonNameing()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("enter size of n array(from 1 to 10)");
        int sizeN=get_int();
        while (sizeN<1||sizeN>10)
        {
            System.out.println("from 1 to 10");
            sizeN=get_int();
        }
        System.out.println("enter size of m array(from 1 to 10)");
        int sizeM=get_int();
        while (sizeM<1||sizeM>10)
        {
            System.out.println("from 1 to 10");
            sizeM=get_int();
        }
        int []n=new int[sizeN];
        int []m=new int[sizeM];
        Random random = new Random();
        System.out.println("do you want fill n automatically?\ny-yes\nn-no");
        char answer = input.next().toLowerCase().charAt(0);
        if (answer == 'y')
        {
            for (int i=0; i<sizeN; i++)
            {
                n[i]=random.nextInt(100)+1;
            }
        }
        else
        {
            System.out.println("enter n");
            for (int i=0; i<sizeN; i++)
            {
                n[i]=get_int();
            }
        }
        System.out.println("do you want fill m automatically?\ny-yes\nn-no");
        answer = input.next().toLowerCase().charAt(0);
        if (answer == 'y')
        {
            for (int i=0; i<sizeM; i++)
            {
                m[i]=random.nextInt(100)+1;
            }
        }
        else
        {
            System.out.println("enter m");
            for (int i=0; i<sizeM; i++)
            {
                m[i]=get_int();
            }
        }

        boolean flag, isNonClear = false;
        if (n[sizeN-1]<m[0])
            for (int i=n[sizeN-1]; i<=m[0]; i++)
            {
                flag = true;
                for (int j=0; j<sizeN; j++)
                    if(i%n[j]!=0)
                        flag=false;
                for (int j=0; j<sizeM; j++)
                    if(m[j]%i!=0)
                        flag=false;
                if (flag)
                {
                    System.out.println(i);
                    isNonClear=false;
                }
            }
        else
        {
            for (int i=m[0]; i<=n[sizeN-1]; i++)
            {
                flag = true;
                for (int j = 0; j < sizeN; j++)
                    if (i % n[j] != 0)
                        flag = false;
                for (int j = 0; j < sizeM; j++)
                    if (m[j] % i != 0)
                        flag = false;
                if (flag) {
                    System.out.println(i);
                    isNonClear = false;
                }
            }
        }
        if(isNonClear)
            System.out.println("required values not found");
    }
}
