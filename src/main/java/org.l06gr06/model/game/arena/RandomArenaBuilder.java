package org.l06gr06.model.game.arena;

import org.l06gr06.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomArenaBuilder extends ArenaBuilder{
    private final Random rng;
    private final int width;
    private final int height;
    private final int numberOfBeasts;
    private final int numberOfBlocks;
    private final int numberOfPowerUps;
    private final int numberOfEggs;

    public RandomArenaBuilder(int width, int height, int numberOfBeasts, int numberOfBlocks, int numberOfPowerUps, int numberOfEggs) {
        this.rng = new Random();
        this.width = width;
        this.height = height;
        this.numberOfBeasts = numberOfBeasts;
        this.numberOfBlocks = numberOfBlocks;
        this.numberOfPowerUps = numberOfPowerUps;
        this.numberOfEggs = numberOfEggs;
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
    protected List<Beast> createBeasts() {
        List<Beast> beasts = new ArrayList<>();

        while (beasts.size() < numberOfBeasts)
            beasts.add(new Beast(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return beasts;
    }

    @Override
    protected Player createPlayer() {
        return new Player(width / 3, height / 3);
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int x = 0; x < width; x++) {
            walls.add(new Wall(x, 0));
            walls.add(new Wall(x, height - 1));
        }

        for (int y = 1; y < height - 1; y++) {
            walls.add(new Wall(0, y));
            walls.add(new Wall(width - 1, y));
        }

        return walls;
    }

    @Override
    protected List<Block> createBlocks() {
        List<Block> blocks = new ArrayList<>();

        while (blocks.size() < numberOfBlocks)
            blocks.add(new Block(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return blocks;

    }

    @Override
    protected List<Egg> createEggs() {
        List<Egg> eggs = new ArrayList<>();

        while (eggs.size() < numberOfEggs)
            eggs.add(new Egg(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));

        return eggs;

    }

    @Override
    protected List<PowerUp> createPowerUps() {
        List<PowerUp> powerUps = new ArrayList<>();

        while (powerUps.size() < numberOfPowerUps){
            int a = (int) (Math.random()*2);
            if (a == 0) powerUps.add(new Shield(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));
            else powerUps.add(new Heart(rng.nextInt(width - 2) + 1, rng.nextInt(height - 2) + 1));
        }

        return powerUps;
    }
}
