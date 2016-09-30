package ua.app;

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
            view.printMessage(Globals.NUMBER_FROM + model.getLow() + Globals.NUMBER_TO + model.getHigh());

            try {
                //     number = scan.nextInt();
                number = Integer.parseInt(scanner.nextLine());

                if (checkBorders(number)) {
                    view.printMessage(Globals.EXCEED_HIGHER);
                    continue;
                }
                else if (!checkBorders(number)) {
                    view.printMessage(Globals.EXCEED_LOWER);
                    continue;
                }

                if (model.checkNumber(number)){
                    view.printMessage(Globals.WIN + model.getGeneratedNumber() + Globals.ATTEMPTS + count);
                    model.setStarted(false);
                    break;
                }
                else {
                    if (!model.checkNumber(number)){
                        if(!model.compare(number))
                            view.printMessage(Globals.NUMBER_LOWER);
                        else if (model.compare(number))
                            view.printMessage(Globals.NUMBER_HIGHER);
                    }
                }
            } catch (Exception e) {
                e.getMessage();
                view.printMessage(Globals.WRONG_INPUT);
                continue;
            }
        }
    }

    private boolean checkBorders(int number) {
        if (number >= model.getHigh())
            return true;
        return false;
    }
}
