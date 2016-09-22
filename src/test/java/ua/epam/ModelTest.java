package ua.epam;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.InputMismatchException;

import static org.junit.Assert.*;

/**
 * Created by Дмитрий on 18.09.2016.
 */
public class ModelTest {
    @Rule
    public final ExpectedException exp = ExpectedException.none();

    @Test
    public void testGenerateRandomNumber() throws Exception {
        Model model = new Model();
        boolean flag = false;
        int res = model.generateRandomNumber();
        for (int i = 0; i < 1000; i++) {
            if(res > model.RAND_MIN && res < model.RAND_MAX)
                flag = true;
        }
        Assert.assertTrue(flag);
    }

    @Test
    public void testGenerateRandomNumberWithParams() throws Exception {
        Model model = new Model();
        boolean flag = false;
        int low = 5;
        int high = 15;
        int res = model.generateRandomNumber(low, high);
        for (int i = 0; i < 1000; i++) {
            if(res > low && res < high)
                flag = true;
        }
        Assert.assertTrue(flag);
    }

    @Test
    public void testCompareMoreThanRandom() throws Exception {
        Model model = new Model();
        int generatedNumber = 100;
        int guessNumber = 51;
        while (generatedNumber > 50) {
            model.generateRandomNumber();
            generatedNumber = model.getGeneratedNumber();
        }
        boolean compareResult = model.checkNumber(guessNumber);

        Assert.assertEquals(false, compareResult);
    }

    @Test
    public void testCompareLessThanRandom() throws Exception {
        Model model = new Model();
        int generatedNumber = 0;
        int guessNumber = 49;
        while (generatedNumber <= 50) {
            model.generateRandomNumber();
            generatedNumber = model.getGeneratedNumber();
        }
        boolean compareResult = model.checkNumber(guessNumber);

        Assert.assertEquals(false, compareResult);
    }

    @Test
    public void testCompareLessEqualsRandom() throws Exception {
        Model model = new Model();
        int generatedNumber = 100;
        int guessNumber = 50;
        while (generatedNumber != 50) {
            model.generateRandomNumber();
            generatedNumber = model.getGeneratedNumber();
        }
        boolean compareResult = model.checkNumber(guessNumber);

        Assert.assertEquals(true, compareResult);
    }
}