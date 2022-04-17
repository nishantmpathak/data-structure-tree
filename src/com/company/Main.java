package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println(calculate(5, 2));
    }

    public static int calculate(int a, int n){
        int finalSum=0;
        int number=a;
        int lastSum=a;
        for(int i =1; i<=n;i++){
            finalSum = finalSum+lastSum;
            number = 10*number;
            lastSum = number+lastSum;
        }
        return finalSum;
    }
}
