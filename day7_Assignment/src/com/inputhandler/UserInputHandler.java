package com.inputhandler;
import java.util.Scanner;
public class UserInputHandler {
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);

        int inputcount=0;
        int integercount=0;
        int nonIntegerCount=0;
        int sumofIntegers=0;

        while(true)
        {
            try{
                System.out.print("enter an integer : ");
                int input=sc.nextInt();
                inputcount++;
                integercount++;
                sumofIntegers+=input;
            }
            catch(java.util.InputMismatchException e)
            {
                inputcount++;
                integercount++;
                sc.next();
            }

            System.out.print("do you wish to continue: (yes/no) : ");
            String choice=sc.next().toUpperCase();
            if(choice.equals("NO"))
            {
                break;
            }
        }


        System.out.println("number of inputs = "+inputcount);
        System.out.println("number of integer inputs : "+integercount);
        System.out.println("number of non-integers inputs = "+nonIntegerCount);
        System.out.println("sum of all integer inputs = "+sumofIntegers);
    }

}
