package org.example;

import java.util.Scanner;

import static config.Configuration.fanContext;
import static config.Configuration.fanService;

public class CeilingFan {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char ch;

        System.out.println("\nSimple Ceiling Fan Test\n");
        System.out.println("Ceiling Fan Operations:");

        do {
            System.out.println("\n'i' or '+' to increase the speed of the fan");
            System.out.println("'r' to reverse the direction of the fan");

            char userInput = scan.next().charAt(0);
            switch (userInput) {
                case 'i':
                case 'I':
                case '+':
                    fanService.changeSpeed();
                    break;
                case 'r':
                case 'R':
                    fanService.changeDirection();
                    break;
                default :
                    System.out.println("Wrong Entry\n");
                    break;
            }

            fanContext.printStatus();

            System.out.println("\nDo you want to operate the fan again (Type 'y' for yes)");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}