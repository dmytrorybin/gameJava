package ua.app;

/**
 * Created by Dmytro_Rybin on 9/13/2016.
 */
public class GenerateNumber {
    public final int RAND_MAX = 100;

    public int rand() {
        int res = (int)(Math.random() * 99);
        if (res == 0)
            res += 1;
        return res;
    }
    public int rand(int min, int max) {
        int res = (int)(Math.random() * (max - min)) + min;
        if (res == 0)
            res += 1;
        return res;
    }
}
