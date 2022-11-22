package org.l06gr06.model.game.arena;

import org.l06gr06.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArenaBuilder extends ArenaBuilder{
    private final Random rng;
    private final int width;
    private final int height;
    private final int numberOfMonsters;

    public RandomArenaBuilder(int width, int height, int numberOfMonsters) {
        this.rng = new Random();

        this.width = width;
        this.height = height;
        this.numberOfMonsters = numberOfMonsters;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected List<Monster> createMonsters() {
        //to be implemented...
        return null;
    }

    @Override
    protected Hero createHero() {
        //to be implemented...
        return null;
    }

    @Override
    protected List<Wall> createWalls() {
        //to be implemented...
        return null;
    }

    @Override
    protected List<Block> createBlocks() {
        //to be implemented...
        return null;
    }

    @Override
    protected List<PowerUp> createPowerUps() {
        //to be implemented...
        return null;
    }
}
