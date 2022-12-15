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
    
    private void linkedBlocks(Block block){
        while (getModel().isBlock(block.getPosition().getDirection(action)))
            block.getPosition().goDirection(action);
    }
    private void restorePosition(Block block, Position position){
        while (getModel().isBlock(block.getPosition().getDirection(symmetricAction(action))))
            block.getPosition().goDirection(symmetricAction(action));
        if (!block.getPosition().equals(position))
            block.getPosition().goDirection(symmetricAction(action));
    }
    private GUI.ACTION symmetricAction(GUI.ACTION action){
        switch (action){
            case LEFT : return GUI.ACTION.RIGHT;
            case UP : return GUI.ACTION.DOWN;
            case RIGHT : return GUI.ACTION.LEFT;
        }
        return GUI.ACTION.UP;
    }
    private void moveblock(Position position){
        int j = getModel().getBlocks().indexOf(new Block(position));
        Block block = getModel().getBlocks().get(j);

        linkedBlocks(block);

        if (getModel().isEmpty(block.getPosition().getDirection(action))) {
            block.getPosition().goDirection(action);
            getModel().getPlayer().getPosition().goDirection(action);
        }
        else if (getModel().isBlock(block.getPosition().getDirection(action).getDirection(action)) || getModel().isWall(block.getPosition().getDirection(action).getDirection(action))){
            if (getModel().isPowerUp(block.getPosition().getDirection(action))){
                getModel().getPowerUps().remove(new PowerUp(block.getPosition().getDirection(action)));

                block.getPosition().goDirection(action);
                getModel().getPlayer().setPosition(position);
            }
            else if (getModel().isBeast(block.getPosition().getDirection(action)))  {

                int i = getModel().getBeasts().indexOf(new Beast(block.getPosition().getDirection(action),0));
                if (getModel().getBeasts().get(i).getPhase() < 2) {
                    stats[getModel().getBeasts().get(i).getPhase()]++;
                    getModel().getBeasts().remove(i);
                    block.getPosition().goDirection(action);
                    getModel().getPlayer().setPosition(position);
                }
                else if (getModel().getBeasts().get(i).getPhase() == 2 && getModel().isWall(block.getPosition().getDirection(action).getDirection(action))){
                    stats[getModel().getBeasts().get(i).getPhase()]++;
                    getModel().getBeasts().remove(i);
                    block.getPosition().goDirection(action);
                    getModel().getPlayer().setPosition(position);
                }
                else{
                    restorePosition(block,position);
                }
            }
            else{
                restorePosition(block,position);
            }
        }
        else{
            restorePosition(block,position);
        }

    }
    private void movePlayer(Position position) {

        if (getModel().isBlock(position)) {
            moveblock(position);
            return;
        }

        else if (getModel().canMove(position))
            player.setPosition(position);

        if (getModel().isBeast(position))
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
