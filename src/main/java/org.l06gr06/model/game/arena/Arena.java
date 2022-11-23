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

    public List<Egg> getEggs() {return eggs;}

    public void setEggs(List<Egg> eggs) {this.eggs = eggs;}

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return true;
        for (Egg egg : eggs)
            if (egg.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isBeast(Position position) {
        for (Beast beast : beasts)
            if (beast.getPosition().equals(position))
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

    public int getPlayerQuad(){
        return 1;
    }
}
