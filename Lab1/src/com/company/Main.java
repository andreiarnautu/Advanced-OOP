package com.company;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        labOne();
    }



    private static void labOne() {
        Scanner fin = new Scanner(System.in);
        System.out.println("Exercitiul: ");
        int request = fin.nextInt();

        switch(request) {
            case 1:
                taskOne(fin);
                break;
            case 2:
                taskTwo(fin);
                break;
            case 3:
                taskThree(fin);
                break;
            case 4:
                taskFour(fin);
                break;
            case 5:
                taskFive(fin);
                break;
            case 6:
                taskSix(fin);
                break;
            case 7:
                taskSeven(fin);
                break;
        }
    }

    private static void taskOne(Scanner fin) {
        System.out.println("Dati un numar: ");
        int n = fin.nextInt();

        for (int i = 0; i <= n; i += 2) {
            System.out.println(i);
        }
    }

    private static void taskTwo(Scanner fin) {
        System.out.println("a: ");
        int a = fin.nextInt();
        System.out.println("b: ");
        int b = fin.nextInt();

        if (a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
    }

    private static void taskThree(Scanner fin) {
        System.out.println("n: ");
        int n = fin.nextInt();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }

    private static void taskFour(Scanner fin) {
        System.out.println("n: ");
        int n = fin.nextInt();

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        System.out.println(fact);
    }

    private static void taskFive(Scanner fin) {
        System.out.println("n: ");
        int n = fin.nextInt();

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }

    private static void taskSix(Scanner fin) {
        System.out.println("a: ");
        int a = fin.nextInt();
        System.out.println("b: ");
        int b = fin.nextInt();

        int result = 1, aux = a;
        for (int i = 1; i <= b; i++) {
            result *= a;
        }
        System.out.println(result);
    }

    private static void taskSeven(Scanner fin) {
        int prev[] = {1, 1};
        System.out.println("n: ");
        int n = fin.nextInt();

        for (int i = 3; i <= n; i++) {
            int curr = prev[0] + prev[1];
            prev[0] = prev[1];
            prev[1] = curr;
        }
        System.out.println(prev[1]);
    }
}
