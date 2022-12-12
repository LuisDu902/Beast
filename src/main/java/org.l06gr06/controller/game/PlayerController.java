package org.l06gr06.controller.game;

import org.l06gr06.Game;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Block;
import org.l06gr06.model.game.elements.Heart;
import org.l06gr06.model.game.elements.Shield;

import java.util.Random;


public class PlayerController extends GameController {
    private GUI.ACTION action;
    private final long[] stats;
    public PlayerController(Arena arena) {
        super(arena);
        this.stats = new long[6];
    }
    private void movePlayerLeft() {
        movePlayer(getModel().getPlayer().getPosition().getLeft());
    }

    private void movePlayerRight() {movePlayer(getModel().getPlayer().getPosition().getRight());}

    private void movePlayerUp() {
        movePlayer(getModel().getPlayer().getPosition().getUp());
    }

    private void movePlayerDown() {
        movePlayer(getModel().getPlayer().getPosition().getDown());
    }
    
    private void linkedBlocks(Block block){
        while (getModel().isBlock(block.getPosition().getDirection(action))){
            block.getPosition().goDirection(action);
        }
    }
    private void restorePosition(Block block, Position position){
        while (getModel().isBlock(block.getPosition().getDirection(symmetricAction(action))))
            block.getPosition().goDirection(symmetricAction(action));
        if (!block.getPosition().equals(position))
            block.getPosition().goDirection(symmetricAction(action));
    }
    private GUI.ACTION symmetricAction(GUI.ACTION action){
        switch (action){
            case LEFT -> { return GUI.ACTION.RIGHT; }
            case UP -> { return GUI.ACTION.DOWN; }
            case RIGHT -> { return GUI.ACTION.LEFT; } }
        return GUI.ACTION.UP;
    }
    private void moveblock(Position position){
        Block block = getModel().findBlock(position);
        linkedBlocks(block);

        if (getModel().isEmpty(block.getPosition().getDirection(action))) {
            block.getPosition().goDirection(action);
            getModel().getPlayer().getPosition().goDirection(action);
        }
        else if (getModel().isBlock(block.getPosition().getDirection(action).getDirection(action)) || getModel().isWall(block.getPosition().getDirection(action).getDirection(action))){
            if (getModel().isPowerUp(block.getPosition().getDirection(action))){
                int i = getModel().findPowerUp(block.getPosition().getDirection(action));
                getModel().getPowerUps().remove(i);

                block.getPosition().goDirection(action);
                getModel().getPlayer().setPosition(position);
            }
            else if (getModel().isBeast(block.getPosition().getDirection(action)))  {
                int i = getModel().findBeast(block.getPosition().getDirection(action));
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
        if (getModel().canMove(position)) {
            getModel().getPlayer().setPosition(position);
            if (getModel().isBeast(position)) {
                if (getModel().getPlayer().getPhase() == 1){
                    getModel().getPlayer().backToNormal();
                }
                else {
                    getModel().getPlayer().decreaseLife();
                    Random rng = new Random();
                    int x = rng.nextInt(getModel().getWidth() - 2) + 1;
                    int y = rng.nextInt(getModel().getHeight() - 3) + 2;
                    getModel().getPlayer().setPosition(new Position(x, y));
                }
            }
            else if (getModel().isPowerUp(position)) {
                int i = getModel().findPowerUp(position);
                if (getModel().getPowerUps().get(i) instanceof Heart &&
                        getModel().getPlayer().getLife() <= 7) getModel().getPlayer().increaseLife();
                else if (getModel().getPowerUps().get(i) instanceof Shield) {
                    getModel().getPlayer().becomeImmortal();
                    stats[3]++;
                }
                getModel().getPowerUps().remove(i);

            }
        }
        else if (getModel().isBlock(position)){
            moveblock(position);
        }
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) {

        this.action = action;

        if (time - getModel().getPlayer().getImmortalTime() > getModel().getPlayer().getImmortalDuration() * 1000){
            getModel().getPlayer().backToNormal();
        }
        if (action == GUI.ACTION.UP) movePlayerUp();
        if (action == GUI.ACTION.RIGHT) movePlayerRight();
        if (action == GUI.ACTION.DOWN) movePlayerDown();
        if (action == GUI.ACTION.LEFT) movePlayerLeft();

        stats[4] = getModel().getPlayer().getLife();
        stats[5] = (time - getModel().getStartingTime())/1000;
    }

    public long[] getStats() {
        return stats;
    }

}
