package org.l06gr06.controller.game;

import org.l06gr06.Game;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Block;
import org.l06gr06.model.game.elements.PowerUp;


public class PlayerController extends GameController {
    public PlayerController(Arena arena) {
        super(arena);
    }

    public void movePlayerLeft(GUI.ACTION action) {
        movePlayer(getModel().getPlayer().getPosition().getLeft(),action);
    }

    public void movePlayerRight(GUI.ACTION action) {
        movePlayer(getModel().getPlayer().getPosition().getRight(),action);
    }

    public void movePlayerUp(GUI.ACTION action) {
        movePlayer(getModel().getPlayer().getPosition().getUp(),action);
    }

    public void movePlayerDown(GUI.ACTION action) {
        movePlayer(getModel().getPlayer().getPosition().getDown(),action);
    }

    private void moveblock(Position position, GUI.ACTION action){
        for (Block block: getModel().getBlocks())
            if (block.getPosition().equals(position)){
                if (action == GUI.ACTION.DOWN){
                    while (getModel().isBlock(block.getPosition().getDown())){
                        block.getPosition().goDown();
                    }

                    if (getModel().isEmpty(block.getPosition().getDown())) {
                        block.setPosition(block.getPosition().getDown());
                        getModel().getPlayer().setPosition(position);
                    }
                    else if (getModel().isBeast(block.getPosition().getDown())) {
                        block.getPosition().goDown();
                        if (getModel().isBlock(block.getPosition().getDown())){
                            block.getPosition().goUp();
                    }
                    else{
                        while (getModel().isBlock(block.getPosition().getUp())){
                                block.getPosition().goUp();
                            }
                        }
                        if (!block.getPosition().equals(position))
                            block.getPosition().goUp();

                    }
                    return;
                }
                if (action == GUI.ACTION.UP){
                    Position pos = block.getPosition();
                    while (getModel().isBlock(pos.getUp())){
                        pos.goUp();
                    }
                    if (getModel().isEmpty(pos.getUp())) {
                        block.setPosition(pos.getUp());
                        getModel().getPlayer().setPosition(position);
                    }
                    else{
                        while (getModel().isBlock(block.getPosition().getDown())){
                            block.getPosition().goDown();
                        }
                        if (!block.getPosition().equals(position))
                            block.getPosition().goDown();
                    }
                }
                if (action == GUI.ACTION.LEFT){
                    Position pos = block.getPosition();
                    while (getModel().isBlock(pos.getLeft())){
                        pos.goLeft();
                    }
                    if (getModel().isEmpty(pos.getLeft())) {
                        block.setPosition(pos.getLeft());
                        getModel().getPlayer().setPosition(position);
                    }
                    else{
                        while (getModel().isBlock(block.getPosition().getRight())){
                            block.getPosition().goRight();
                        }
                        if (!block.getPosition().equals(position))
                            block.getPosition().goRight();
                    }
                }
                if (action == GUI.ACTION.RIGHT){
                    Position pos = block.getPosition();
                    while (getModel().isBlock(pos.getRight())){
                        pos.goRight();
                    }
                    if (getModel().isEmpty(pos.getRight())) {
                        block.setPosition(pos.getRight());
                        getModel().getPlayer().setPosition(position);
                    }
                    else{
                        while (getModel().isBlock(block.getPosition().getLeft())){
                            block.getPosition().goLeft();
                        }
                        if (!block.getPosition().equals(position))
                            block.getPosition().goLeft();
                    }
                }

            }}

    private void movePlayer(Position position,GUI.ACTION action) {
        if (getModel().isEmpty(position) && !getModel().isBlock(position) && !getModel().isPowerUp(position)) {
            getModel().getPlayer().setPosition(position);
            if (getModel().isBeast(position)) getModel().getPlayer().decreaseEnergy();

        }
        else if (getModel().isBlock(position)){
            moveblock(position,action);
        }

        else if (getModel().isPowerUp(position)){
            getModel().getPlayer().setPosition(position);
            getModel().getPlayer().increaseEnergy();
            int i = 0;
            for (PowerUp powerUp: getModel().getPowerUps()){
                if (powerUp.getPosition().equals(position)){
                    break;
                }
                i++;
            }
            getModel().getPowerUps().remove(i);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        if (action == GUI.ACTION.UP) movePlayerUp(action);
        if (action == GUI.ACTION.RIGHT) movePlayerRight(action);
        if (action == GUI.ACTION.DOWN) movePlayerDown(action);
        if (action == GUI.ACTION.LEFT) movePlayerLeft(action);
    }
}
