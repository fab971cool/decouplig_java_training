package fr.lernejo;

import fr.lernejo.guessgame.HumanPlayer;
import fr.lernejo.guessgame.Player;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class Simulation
{
    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final HumanPlayer player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        //TODO implement me
        this.player = (HumanPlayer) player;
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
            this.player.respond(false);
            this.logger.log(" Le nombre est trop grand");
        }
        else
        {
            this.player.respond(true);
            this.logger.log(" Le nombre est trop petit");
        }

        return false;
    }

    public void loopUntilPlayerSucceed() {
        //TODO implement me
        boolean bool = false;
        do{
            bool = nextRound();
        }while(!bool);
    }
}
