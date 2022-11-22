package org.l06gr06.model.game.arena;


import org.l06gr06.model.Position;
import org.l06gr06.model.game.elements.*;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Hero hero;

    private List<Monster> monsters;
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

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
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

    public boolean isEmpty(Position position) {
        //to be implemented...
        return true;
    }

    public boolean isMonster(Position position) {
        //to be implemented...
        return false;
    }

    public boolean isBlock(Position position) {
        //to be implemented...
        return true;
    }
    public boolean isWall(Position position) {
        //to be implemented...
        return true;
    }
    public boolean isPowerUp(Position position) {
        //to be implemented...
        return true;
    }
}
