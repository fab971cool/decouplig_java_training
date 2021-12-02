package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player
{
    Logger logger = LoggerFactory.getLogger("computer");
    boolean bool = false;
    long borneSup = Long.MAX_VALUE;
    long borneInf = 0;

    long nombre = (borneSup + borneInf) / 2;

    @Override
    public long askNextGuess()
    {

        if (bool)
        {
            borneInf = nombre;
        }
        else
        {
            borneSup = nombre;
        }
        nombre = (borneInf + borneSup) / 2;
        return nombre;
    }

    // si vrai, le nombre à deviner est plus petit
    @Override
    public void respond(boolean lowerOrGreater) {
        this.bool = lowerOrGreater;
        System.out.print(nombre);
    }
}
