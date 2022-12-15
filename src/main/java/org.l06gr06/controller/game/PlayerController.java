package org.l06gr06.controller.game;

import org.l06gr06.Game;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.*;

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
        Arena arena = getModel();
        Player player = arena.getPlayer();

        if (arena.canMove(position)) {
            player.setPosition(position);
            if (arena.isBeast(position) && player.isImmortal())
                player.backToNormal();
            else if (arena.isBeast(position) && !player.isImmortal()){
                player.decreaseLife();
                arena.respawnPlayer();
            }
            else if (arena.isPowerUp(position)) {
                int i = arena.getPowerUps().indexOf(new PowerUp(position));
                if (arena.getPowerUps().get(i) instanceof Heart && player.getLife() <= 7)
                    player.increaseLife();
                else {
                    player.becomeImmortal();
                    stats[3]++;
                }
                arena.getPowerUps().remove(i);
            }
        }
        else if (arena.isBlock(position)){
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
    }

    public long[] getStats() {
        return stats;
    }

}
