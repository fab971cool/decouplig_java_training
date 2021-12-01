package fr.lernejo;
import java.security.SecureRandom;

import fr.lernejo.guessgame.HumanPlayer;

public class Launcher
{

    public static void main( String[] args)
    {
        HumanPlayer player = new HumanPlayer();
        Simulation simu = new Simulation(player);

        SecureRandom random = new SecureRandom();
        //long randomNumber = random.nextLong(); // génère un nombre entre Long.MIN_VALUE et Long.MAX_VALUE
        long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)

        simu.initialize(randomNumber);
        simu.loopUntilPlayerSucceed();
    }

}
