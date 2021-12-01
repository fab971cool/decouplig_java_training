package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.util.Scanner;

public class HumanPlayer implements Player
{
    Logger logger = LoggerFactory.getLogger("player");
    Scanner scan = new Scanner(System.in);

    @Override
    public long askNextGuess()
    {
        System.out.println(" Veuillez entrer un nombre : ");
        long res = scan.nextLong();
        scan.nextLine();
        return res;
    }

    @Override
    public void respond(boolean lowerOrGreater)
    {
        if (lowerOrGreater)
        {
            logger.log(" Greater! ");
        }
        else
        {
            logger.log(" Lower ");
        }
    }
}
