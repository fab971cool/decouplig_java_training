package fr.lernejo;

import fr.lernejo.guessgame.HumanPlayer;
import fr.lernejo.guessgame.Player;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;
import jdk.dynalink.linker.support.SimpleLinkRequest;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Simulation
{
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        //TODO implement me
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        //TODO implement me
        long deviner = this.player.askNextGuess();
        if ( deviner == this.numberToGuess)
            return true;
        else if ( deviner > this.numberToGuess) {
            this.player.respond(false); // lower
            this.logger.log(" Le nombre est trop grand");
        }
        else
        {
            this.player.respond(true); // greater
            this.logger.log(" Le nombre est trop petit");
        }
        return false;
    }

    public void loopUntilPlayerSucceed( long maxIteration) {
        //TODO implement me

        SimpleDateFormat format = new SimpleDateFormat("mm:ss.SSS", Locale.FRANCE);
        long time = System.currentTimeMillis();
        boolean bool = false;
        int i = 0;
        while ( i != maxIteration && !bool){
            bool = this.nextRound();
            i++;

        }
        if (bool)
            System.out.println(" Le joueur a réussi à trouver le nombre : " + this.numberToGuess);
        else
            System.out.println(" Le joueur n'a pas réussi à trouver le nombre");


        long diffTime = System.currentTimeMillis() - time;
        Date date1 = new Date(diffTime);
        System.out.print(" "+ i + " itérations en : ");
        System.out.println( format.format(date1) + "s");
    }
}
