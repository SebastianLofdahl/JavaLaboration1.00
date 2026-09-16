package Se.iths.sebastian.laborationEtt.laborationDice.model;

import java.util.random.RandomGenerator;
//Util för att kunna ta funktion av random generering

public class Dice {

    public static int roll() {
        //metoden för att kalla på för att generera ett nummer per kast
        return RandomGenerator.getDefault().nextInt(1, 20);
    }


}
