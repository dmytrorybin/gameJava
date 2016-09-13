package ua.epam;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            GameLogic game = new GameLogic();
            Scanner scan = new Scanner(System.in);
            //		InputStream s = System.in;
            int code;
            int number;
            int count = 0;

            game.gameSart();

            while(true) {
                count++;
                System.out.println("enter number from " + game.getLow() + " to " + game.getHigh() + ":");

                try {
                    number = scan.nextInt();

                    if (number > game.getHigh()) {
                        System.out.println("You exceed higher border ");
                        continue;
                    }
                    else if (number < game.getLow()) {
                        System.out.println("You exceed lower border ");
                        continue;
                    }

                    code = game.compare(number);
                    if (code == 10){
                        System.out.println("You won!!! Random was " + number + " . Number of attempts: " + count);
                        break;
                    }
                    else {
                        if (code == -1){
                            System.out.println("Your number is lower than random");
                        }
                        if (code == 1){
                            System.out.println("Your number is higher than random");
                        }
                    }
                } catch (InputMismatchException e) {
                    e.getMessage();
                    System.out.println("Wrong input");
                    break;
                }
            }
        }
}
