package org.l06gr06.controller.game;

import org.l06gr06.Game;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Block;
import org.l06gr06.model.game.elements.Heart;

import java.util.Random;


public class PlayerController extends GameController {
    private GUI.ACTION action;
    public PlayerController(Arena arena) {
        super(arena);
    }
    public void movePlayerLeft() {
        movePlayer(getModel().getPlayer().getPosition().getLeft());
    }

    public void movePlayerRight() {movePlayer(getModel().getPlayer().getPosition().getRight());}

    public void movePlayerUp() {
        movePlayer(getModel().getPlayer().getPosition().getUp());
    }

    public void movePlayerDown() {
        movePlayer(getModel().getPlayer().getPosition().getDown());
    }

    public void setAction(GUI.ACTION action) {this.action = action;}

    private void moveblock(Position position){
        Block block = getModel().findBlock(position);
        if (action == GUI.ACTION.DOWN){
            while (getModel().isBlock(block.getPosition().getDown())){
                block.getPosition().goDown();
            }

            if (getModel().isEmpty(block.getPosition().getDown()) && !getModel().isBeast(block.getPosition().getDown()) && !getModel().isPowerUp(block.getPosition().getDown())) {
                block.getPosition().goDown();
                getModel().getPlayer().getPosition().goDown();
            }
            else if (getModel().isBlock(block.getPosition().getDown().getDown()) || getModel().isWall(block.getPosition().getDown().getDown())){
                if (getModel().isPowerUp(block.getPosition().getDown())){
                    int i = getModel().findPowerUp(block.getPosition().getDown());
                    getModel().getPowerUps().remove(i);

                    block.getPosition().goDown();
                    getModel().getPlayer().setPosition(position);
                }
                else if (getModel().isBeast(block.getPosition().getDown()))  {
                    int i = getModel().findBeast(block.getPosition().getDown());
                    if (getModel().getBeasts().get(i).getPhase() < 2) {
                        getModel().getBeasts().remove(i);
                        block.getPosition().goDown();
                        getModel().getPlayer().setPosition(position);
                    }
                    else if (getModel().getBeasts().get(i).getPhase() == 2 && getModel().isWall(block.getPosition().getDown().getDown())){
                        getModel().getBeasts().remove(i);
                        block.getPosition().goDown();
                        getModel().getPlayer().setPosition(position);
                    }
                    else{
                        while (getModel().isBlock(block.getPosition().getUp())){
                            block.getPosition().goUp();
                        }
                        if (!block.getPosition().equals(position))
                            block.getPosition().goUp();
                    }
                }
                else{
                    while (getModel().isBlock(block.getPosition().getUp())){
                        block.getPosition().goUp();
                    }
                    if (!block.getPosition().equals(position))
                        block.getPosition().goUp();
                }
            }
            else{
                while (getModel().isBlock(block.getPosition().getUp())){
                    block.getPosition().goUp();
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
            if (getModel().isEmpty(pos.getUp()) && !getModel().isBeast(block.getPosition().getUp()) && !getModel().isPowerUp(block.getPosition().getUp())) {
                block.getPosition().goUp();
                getModel().getPlayer().getPosition().goUp();
            }
            else if (getModel().isBlock(block.getPosition().getUp().getUp()) || getModel().isWall(block.getPosition().getUp().getUp())){
                if (getModel().isPowerUp(block.getPosition().getUp())){
                    int i = getModel().findPowerUp(block.getPosition().getUp());
                    getModel().getPowerUps().remove(i);

                    block.getPosition().goUp();
                    getModel().getPlayer().setPosition(position);
                }

                else if (getModel().isBeast(block.getPosition().getUp()))  {
                    int i = getModel().findBeast(block.getPosition().getUp());
                    if (getModel().getBeasts().get(i).getPhase() < 2) {
                        getModel().getBeasts().remove(i);
                        block.getPosition().goUp();
                        getModel().getPlayer().setPosition(position);
                    }
                    else if (getModel().getBeasts().get(i).getPhase() == 2 && getModel().isWall(block.getPosition().getUp().getUp())){
                        getModel().getBeasts().remove(i);
                        block.getPosition().goUp();
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
                else{
                    while (getModel().isBlock(block.getPosition().getDown())){
                        block.getPosition().goDown();
                    }
                    if (!block.getPosition().equals(position))
                        block.getPosition().goDown();
                }
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
            if (getModel().isEmpty(pos.getLeft()) && !getModel().isBeast(block.getPosition().getLeft()) && !getModel().isPowerUp(block.getPosition().getLeft())) {
                block.getPosition().goLeft();
                getModel().getPlayer().getPosition().goLeft();
            }
            else if (getModel().isBlock(block.getPosition().getLeft().getLeft()) || getModel().isWall(block.getPosition().getLeft().getLeft())){
                if (getModel().isPowerUp(block.getPosition().getLeft())){
                    int i = getModel().findPowerUp(block.getPosition().getLeft());
                    getModel().getPowerUps().remove(i);
                    block.getPosition().goLeft();
                    getModel().getPlayer().setPosition(position);
                }

                else if (getModel().isBeast(block.getPosition().getLeft()))  {
                    int i = getModel().findBeast(block.getPosition().getLeft());
                    if (getModel().getBeasts().get(i).getPhase() < 2) {
                        getModel().getBeasts().remove(i);
                        block.getPosition().goLeft();
                        getModel().getPlayer().setPosition(position);
                    }
                    else if (getModel().getBeasts().get(i).getPhase() == 2 && getModel().isWall(block.getPosition().getLeft().getLeft())){
                        getModel().getBeasts().remove(i);
                        block.getPosition().goLeft();
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
                else{
                    while (getModel().isBlock(block.getPosition().getRight())){
                        block.getPosition().goRight();
                    }
                    if (!block.getPosition().equals(position))
                        block.getPosition().goRight();
                }
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
            if (getModel().isEmpty(pos.getRight()) && !getModel().isBeast(block.getPosition().getRight()) && !getModel().isPowerUp(block.getPosition().getRight())) {
                block.getPosition().goRight();
                getModel().getPlayer().getPosition().goRight();
            }

            else if (getModel().isBlock(block.getPosition().getRight().getRight()) || getModel().isWall(block.getPosition().getRight().getRight())){
                if (getModel().isPowerUp(block.getPosition().getRight())){
                    int i = getModel().findPowerUp(block.getPosition().getRight());
                    getModel().getPowerUps().remove(i);
                    block.getPosition().goRight();
                    getModel().getPlayer().setPosition(position);
                }

                else if (getModel().isBeast(block.getPosition().getRight()))  {
                    int i = getModel().findBeast(block.getPosition().getRight());
                    if (getModel().getBeasts().get(i).getPhase() < 2) {
                        getModel().getBeasts().remove(i);
                        block.getPosition().goRight();
                        getModel().getPlayer().setPosition(position);
                    }
                    else if (getModel().getBeasts().get(i).getPhase() == 2 && getModel().isWall(block.getPosition().getRight().getRight())){
                        getModel().getBeasts().remove(i);
                        block.getPosition().goRight();
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
                else{
                    while (getModel().isBlock(block.getPosition().getLeft())){
                        block.getPosition().goLeft();
                    }
                    if (!block.getPosition().equals(position))
                        block.getPosition().goLeft();
                }
            }
            else{
                while (getModel().isBlock(block.getPosition().getLeft())){
                    block.getPosition().goLeft();
                }
                if (!block.getPosition().equals(position))
                    block.getPosition().goLeft();
            }
        }

    }

    private void movePlayer(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPlayer().setPosition(position);
            if (getModel().isBeast(position)) {
                getModel().getPlayer().decreaseLife();
                Random rng = new Random();
                int x = rng.nextInt(getModel().getWidth()-2)+1;
                int y = rng.nextInt(getModel().getHeight()-3)+2;
                getModel().getPlayer().setPosition(new Position(x,y));}
            else if (getModel().isPowerUp(position)) {
                int i = getModel().findPowerUp(position);
                if (getModel().getPowerUps().get(i) instanceof Heart &&
                        getModel().getPlayer().getLife() <= 7) getModel().getPlayer().increaseLife();
                else getModel().getPlayer().becomeImmortal();
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
        if (action == GUI.ACTION.UP) movePlayerUp();
        if (action == GUI.ACTION.RIGHT) movePlayerRight();
        if (action == GUI.ACTION.DOWN) movePlayerDown();
        if (action == GUI.ACTION.LEFT) movePlayerLeft();
    }
}
