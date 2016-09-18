package ua.epam;

import java.util.Scanner;

/**
 * Created by Dmytro_Rybin on 9/15/2016.
 */
public class Controller {
    private Model model;
    private View view;
    private int count = 0;
    private int number;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void startGame() {
        if(!model.isStarted()) {
            model.generateRandomNumber();
        }
        gameFlow();
    }

    private void gameFlow() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            count++;
            view.printMessage("enter number from " + model.getLow() + " to " + model.getHigh() + ":");

            try {
                //     number = scan.nextInt();
                number = Integer.parseInt(scanner.nextLine());

                if (checkBorders(number) == 1) {
                    view.printMessage("You exceed higher border ");
                    continue;
                }
                else if (checkBorders(number) == -1) {
                    view.printMessage("You exceed lower border ");
                    continue;
                }

                int compareResult = model.compare(number);
                if (compareResult == 10){
                    view.printMessage("You won!!! Random was " + model.getGeneratedNumber() + " . Number of attempts: " + count);
                    model.setStarted(false);
                    break;
                }
                else {
                    if (compareResult == -1){
                        view.printMessage("Your number is lower than random");
                    }
                    if (compareResult == 1){
                        view.printMessage("Your number is higher than random");
                    }
                }
            } catch (Exception e) {
                e.getMessage();
                view.printMessage("Wrong input");
                continue;
                //   main(args);
            }
        }
    }

    private int checkBorders(int number) {
        if (number >= model.getHigh()) {
            return 1;
        }
        else if (number <= model.getLow()) {
            return -1;
        }
        return 0;
    }
}
