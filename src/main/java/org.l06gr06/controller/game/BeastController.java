package org.l06gr06.controller.game;

import org.l06gr06.Game;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Beast;
import org.l06gr06.model.game.elements.PowerUp;

import java.io.IOException;

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
                Position playerPos = getModel().getPlayer().getPosition();
                Position beastPos = beast.getPosition();
                moveBeast(beast, beastPos.getCloser(playerPos));
            }
            this.lastMovement = time;
        }
    }

    private void moveBeast(Beast beast, Position position) {
        if (beast.getPhase() == 0) return;

        else if (!getModel().canMove(position) || getModel().isBeast(position)) return;

        else if (getModel().isPowerUp(position)) {
            this.speed -= 50;
            beast.evolve();
            getModel().getPowerUps().remove(new PowerUp(position));
        }

        else if (getModel().isPlayer(position))
            getModel().hitPlayer();

        beast.setPosition(position);
    }

    public long getSpeed() {
        return speed;
    }
}
