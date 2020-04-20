package com.company;

public class Primes {


    public static void main(String[] args) {
        boolean b = true;
        int i;
        int n = 100;
       if (isPrime(n) == true) {
           System.out.println("число - простое");
       }
        else {
           System.out.println("число - не простое");
       }
    }
    public static boolean isPrime(int n) { //класс, узнающий, простое ли число
        boolean b = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                b = false;
            }
        }
        return b;
    }
}
