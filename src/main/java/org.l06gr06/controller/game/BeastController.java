package org.l06gr06.controller.game;

import org.l06gr06.Game;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Beast;
import org.l06gr06.model.game.elements.PowerUp;

import java.io.IOException;
import java.util.Random;

public class BeastController extends GameController {
    private long lastMovement;
    private long speed;
    private final long hatchingTime;
    public BeastController(Arena arena) {
        super(arena);
        this.speed = 500;
        this.lastMovement = 0;
        this.hatchingTime = 10;
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if ((time - getModel().getStartingTime())/1000 == hatchingTime) getModel().hatchEggs();
        if (time - lastMovement > speed) {
            for (Beast beast : getModel().getBeasts()){
                moveBeast(beast,
                        beast.getPosition().getCloserToPlayer(
                                getModel().getPlayer().getPosition().relativeQuad(beast.getPosition())));}
            this.lastMovement = time;
        }
    }

    private void moveBeast(Beast beast, Position position) {
        if (beast.getPhase() == 0) return;
        if (getModel().canMove(position) && !getModel().isBlock(position) && !getModel().isBeast(position)) {
            if (getModel().isPowerUp(position)) {
                this.speed -= 50;
                if (beast.getPhase() == 1)
                    beast.evolve();
                getModel().getPowerUps().remove(new PowerUp(position));
            }
            beast.setPosition(position);
            if (getModel().getPlayer().getPosition().equals(position)) {
                if (getModel().getPlayer().getPhase() == 1){
                    getModel().getPlayer().backToNormal();
                }
                else {
                    getModel().getPlayer().decreaseLife();
                    Random rng = new Random();
                    int x = rng.nextInt(getModel().getWidth() - 2) + 1;
                    int y = rng.nextInt(getModel().getHeight() - 3) + 2;
                    getModel().getPlayer().setPosition(new Position(x, y));
                }        }
        }
    }

    public long getSpeed() {
        return speed;
    }
}
