package org.l06gr06.controller.game;

import org.l06gr06.Game;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Block;
import org.l06gr06.model.game.elements.Heart;
import org.l06gr06.model.game.elements.PowerUp;

import java.util.Arrays;
import java.util.List;


public class HeroController extends GameController {
    public HeroController(Arena arena) {
        super(arena);
    }
    public void moveHeroLeft(GUI.ACTION action) {
        moveHero(getModel().getHero().getPosition().getLeft(),action);
    }

    public void moveHeroRight(GUI.ACTION action) {
        moveHero(getModel().getHero().getPosition().getRight(),action);
    }

    public void moveHeroUp(GUI.ACTION action) {
        moveHero(getModel().getHero().getPosition().getUp(),action);
    }

    public void moveHeroDown(GUI.ACTION action) {
        moveHero(getModel().getHero().getPosition().getDown(),action);
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
                        getModel().getHero().setPosition(position);
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
                    if (getModel().isEmpty(pos.getUp())) {
                        block.setPosition(pos.getUp());
                        getModel().getHero().setPosition(position);
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
                        getModel().getHero().setPosition(position);
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
                        getModel().getHero().setPosition(position);
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

    private void moveHero(Position position,GUI.ACTION action) {
        if (getModel().isEmpty(position) && !getModel().isBlock(position) && !getModel().isPowerUp(position)) {
            getModel().getHero().setPosition(position);
            if (getModel().isMonster(position)) getModel().getHero().decreaseEnergy();

        }
        else if (getModel().isBlock(position)){
            moveblock(position,action);
        }

        else if (getModel().isPowerUp(position)){
            getModel().getHero().setPosition(position);
            getModel().getHero().increaseEnergy();
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
        if (action == GUI.ACTION.UP) moveHeroUp(action);
        if (action == GUI.ACTION.RIGHT) moveHeroRight(action);
        if (action == GUI.ACTION.DOWN) moveHeroDown(action);
        if (action == GUI.ACTION.LEFT) moveHeroLeft(action);
    }
}
