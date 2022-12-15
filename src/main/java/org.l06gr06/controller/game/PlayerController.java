package org.l06gr06.controller.game;

import org.l06gr06.Game;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.*;

public class PlayerController extends GameController {
    private GUI.ACTION action;
    private final long[] stats;

    private final Player player;

    public PlayerController(Arena arena) {
        super(arena);
        this.stats = new long[6];
        player = getModel().getPlayer();
    }
    private void movePlayerLeft() {
        movePlayer(player.getPosition().getLeft());
    }

    private void movePlayerRight() {
        movePlayer(player.getPosition().getRight());
    }

    private void movePlayerUp() {
        movePlayer(player.getPosition().getUp());
    }

    private void movePlayerDown() {
        movePlayer(player.getPosition().getDown());
    }

    private void moveblock(Position position){
        int j = getModel().getBlocks().indexOf(new Block(position));
        Block block = getModel().getBlocks().get(j);
        Position nextAvailablePos = new Position(position.getX(), position.getY());

        do nextAvailablePos = nextAvailablePos.getDirection(action);
        while (getModel().isBlock(nextAvailablePos));

        if (getModel().isWall(nextAvailablePos)) return;

        boolean nextToWall = getModel().isWall(nextAvailablePos.getDirection(action));
        boolean nextToBlock = getModel().isBlock(nextAvailablePos.getDirection(action));

        if (nextToWall || nextToBlock){
            if (getModel().isPowerUp(nextAvailablePos)) {
                getModel().getPowerUps().remove(new PowerUp(nextAvailablePos));
            }
            else if (getModel().isBeast(nextAvailablePos)){
                int i = getModel().getBeasts().indexOf(new Beast(nextAvailablePos,0));
                Beast beast = getModel().getBeasts().get(i);
                if (beast.getPhase() < 2 || nextToWall){
                    stats[beast.getPhase()]++;
                    getModel().getBeasts().remove(i);
                }
            }
        }
        if (!getModel().isEmpty(nextAvailablePos)) return;

        block.setPosition(nextAvailablePos);
        getModel().getPlayer().setPosition(position);
    }
    private void movePlayer(Position position) {

        if (getModel().isBlock(position)) {
            moveblock(position);
            return;
        }

        else if (getModel().canMove(position))
            player.setPosition(position);

        if (getModel().isBeast(position) && !getModel().isEgg(position))
            getModel().hitPlayer();

        else if (getModel().isPowerUp(position)) {
            int i = getModel().getPowerUps().indexOf(new PowerUp(position));
            if (getModel().getPowerUps().get(i) instanceof Heart && player.getLife() < 8)
                player.increaseLife();
            else {
                player.becomeImmortal();
                stats[3]++;
            }
            getModel().getPowerUps().remove(i);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {

        this.action = action;

        if (time - player.getImmortalTime() > player.getImmortalDuration() * 1000)
            player.backToNormal();

        if (action == GUI.ACTION.UP) movePlayerUp();
        if (action == GUI.ACTION.RIGHT) movePlayerRight();
        if (action == GUI.ACTION.DOWN) movePlayerDown();
        if (action == GUI.ACTION.LEFT) movePlayerLeft();
    }

    public long[] getStats() {
        return stats;
    }

}
