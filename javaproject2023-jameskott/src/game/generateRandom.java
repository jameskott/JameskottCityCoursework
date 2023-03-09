package game;

import java.util.Random;

public class generateRandom{

    public static int main()
    {
        // create instance of Random class
        Random rand = new Random();


        int randInt = rand.nextInt(27);
        return randInt - 13;
    }
}