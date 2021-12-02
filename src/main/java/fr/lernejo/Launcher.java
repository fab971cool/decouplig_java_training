package fr.lernejo;
import java.io.IOException;
import java.security.SecureRandom;

import fr.lernejo.guessgame.ComputerPlayer;
import fr.lernejo.guessgame.HumanPlayer;

public class Launcher
{

    public static void main( String[] args) {
        if (args.length != 2) {
            System.out.println("Il faut 2 arguments");
            System.exit(0);
        }
        if (args[0].equals("-interactive")) {
            HumanPlayer player = new HumanPlayer();
            Simulation simu = new Simulation(player);

            SecureRandom random = new SecureRandom();
            long randomNumber = random.nextInt(100); // génère un nombre entre 0 (inclus) et 100 (exclus)

            simu.initialize(randomNumber);
            simu.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }
        else if (args[0].equals("-auto")) {
            long number = 0;
            ComputerPlayer player = new ComputerPlayer();
            Simulation simu = new Simulation(player);
             try
             {
                  number = Long.parseLong(args[1]);
                  simu.initialize(number);
                  simu.loopUntilPlayerSucceed(1000);
             }
             catch (Exception e)
             {
                System.out.println("Not an Integer");
             }
        }
        else {
            System.out.println("Erreur");
            System.exit(0);
        }
    }
}
