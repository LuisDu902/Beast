package org.l06gr06.controller.game;

import org.l06gr06.Game;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.PowerUp;

import java.io.IOException;

public class PowerUpController extends GameController{
    private long creationTime;
    private long tick;
    public PowerUpController(Arena arena){
        super(arena);
        this.creationTime = 5;
        this.tick = 5;
    }
    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if(getModel().getPowerUps().size() != 0) {
            PowerUp powerUp = getModel().getPowerUps().get(0);
            if (time - powerUp.getCreationTime() > powerUp.getDuration() * 1000) {
                getModel().getPowerUps().remove(powerUp);
            }
        }

        if ((time - getModel().getStartingTime())/1000 == creationTime){
            getModel().createPowerUp();
            creationTime += 5;
        }
    }
}
