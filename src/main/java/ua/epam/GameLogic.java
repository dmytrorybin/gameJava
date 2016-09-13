package ua.epam;

import java.util.InputMismatchException;

/**
 * Created by Dmytro_Rybin on 9/13/2016.
 */
public class GameLogic {

    private GenerateNumber gn;
    private int randomNumber;

    private int low;
    private int high;

    public GameLogic() {
        low = 0;
        high = 100;
        gn = new GenerateNumber();
        randomNumber = gn.generate();
    }


    public void gameSart() {
        System.out.println(randomNumber);
    }


    public int compare(int number) throws InputMismatchException {
        if (randomNumber == number) {
            return 10;
        }
        else if (number > randomNumber) {
            high = number - 1;
            return 1;
        }
        else if (number < randomNumber) {
            low = number + 1;
            return -1;
        }
        return 0;
    }

    public int getLow() {
        return low;
    }

    public int getHigh() {
        return high;
    }
}
