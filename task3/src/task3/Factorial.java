package task3;

import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        int fact;
        int n;
        String choice;
        Scanner sc = new Scanner(System.in);

        do {
            fact = 1;
            System.out.println("Enter the number whose factorial you want to be calculated:");
            n = sc.nextInt();

            for (int i = n; i >= 1; i--) {
                fact *= i;
            }

            if (fact > 0) {
                System.out.println("The factorial of the number " + n + " is " + fact);
            } else {
                System.out.println("The entered number is too large, kindly use a number less than 32.");
            }

            System.out.println("Do you want to find the factorial again (Y/N)?");
            choice = sc.next();
        } while (choice.equalsIgnoreCase("Y"));

        System.out.println("Good Bye! Come again.");

        sc.close();
    }
}
