package ua.epam;

import java.util.InputMismatchException;

/**
 * Created by Dmytro_Rybin on 9/15/2016.
 */
public class Model {
    public final int RAND_MIN = 0;
    public final int RAND_MAX = 100;
    private int low;
    private int high;
    private boolean isStarted = false;
    private int generatedNumber;

    public Model() {
        low = RAND_MIN;
        high = RAND_MAX;
    }

    public Model(int low, int high) {
        this.low = low;
        this.high = high;
    }

        public int generateRandomNumber() {
        generatedNumber = (int)(Math.random() * (RAND_MAX - RAND_MIN)) + RAND_MIN;
        if (generatedNumber == 0)
            generatedNumber += 1;
            isStarted = true;
  //          System.out.println(generatedNumber);
        return generatedNumber;
    }

    public int generateRandomNumber(int min, int max) {
        generatedNumber = (int)(Math.random() * (max - min)) + min;
        if (generatedNumber == 0)
            generatedNumber += 1;
        return generatedNumber;
    }

    public boolean checkNumber(int number) throws InputMismatchException {
        if (generatedNumber == number) {
            return true;
        }
        else if (number > generatedNumber) {
            high = number;
        }
        else if (number < generatedNumber) {
            low = number;
        }
        return false;
    }

    public boolean compare(int number) {
        if (number > generatedNumber) {
            return true;
        }
        return false;
    }

    public int getLow() { return low; }

    public int getHigh() {
        return high;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public int getGeneratedNumber() { return generatedNumber; }
}

