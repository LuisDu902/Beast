package org.l06gr06.model.game.arena;


import org.l06gr06.model.Position;
import org.l06gr06.model.game.elements.*;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Player player;
    private List<Beast> beasts;
    private List<Egg> eggs;
    private List<Wall> walls;
    private List<Block> blocks;
    private List<PowerUp> powerUps;


    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public List<Beast> getBeasts() {
        return beasts;
    }

    public void setBeasts(List<Beast> beasts) {
        this.beasts = beasts;
    }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public List<Block> getBlocks() {return blocks;}

    public List<PowerUp> getPowerUps() {
        return powerUps;
    }

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    public void setPowerUps(List<PowerUp> powerUps) {
        this.powerUps = powerUps;
    }

    public Block findBlock(Position position){
        for (Block block: blocks){
            if (block.getPosition().equals(position)){
                return block;
            }
        }
        return null;
    }
    public int findBeast(Position position){
        for (int i = 0; i < beasts.size(); i++){
            if (beasts.get(i).getPosition().equals(position)){
                return i;
            }
        }
        return -1;
    }
    public int findPowerUp(Position position) {
        for (int i = 0; i < powerUps.size(); i++){
            if (powerUps.get(i).getPosition().equals(position)){
                return i;
            }
        }
        return -1;
    }

    public int findEgg(Position position) {
        for (int i = 0; i < eggs.size(); i++){
            if (eggs.get(i).getPosition().equals(position)){
                return i;
            }
        }
        return 0;
    }

    public List<Egg> getEggs() {return eggs;}

    public void setEggs(List<Egg> eggs) {this.eggs = eggs;}

    public boolean isEmpty(Position position) {
        return !isEgg(position) && !isWall(position) && !isBlock(position);
    }
    public boolean isBeast(Position position) {
        for (Beast beast : beasts)
            if (beast.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isEgg(Position position) {
        for (Egg egg : eggs)
            if (egg.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isWall(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isBlock(Position position) {
        for (Block block : blocks)
            if (block.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isPowerUp(Position position) {
        for (PowerUp powerUp : powerUps)
            if (powerUp.getPosition().equals(position))
                return true;
        return false;
    }
}
