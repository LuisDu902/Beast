package org.l06gr06.model.game.arena;

import org.l06gr06.model.Position;
import org.l06gr06.model.game.elements.*;

import java.util.ArrayList;
import java.util.Arrays;
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

    private final int numberOfWalls;
    private List<Position> occupied = new ArrayList<>();

    public RandomArenaBuilder(int width, int height, int numberOfBeasts, int numberOfBlocks, int numberOfPowerUps, int numberOfEggs, int numberOfWalls) {
        this.rng = new Random();
        this.width = width;
        this.height = height;
        this.numberOfBeasts = numberOfBeasts;
        this.numberOfBlocks = numberOfBlocks;
        this.numberOfPowerUps = numberOfPowerUps;
        this.numberOfEggs = numberOfEggs;
        this.numberOfWalls = numberOfWalls;
    }
    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }
    private boolean isAvailable(Position pos){
        for (Position position: occupied){
            if (position.equals(pos)) return false;
        }
        return true;
    }
    @Override
    protected List<Beast> createBeasts() {
        List<Beast> beasts = new ArrayList<>();

        while (beasts.size() < numberOfBeasts) {
            int x = (rng.nextInt(width - 2) + 1);
            int y = (rng.nextInt(height - 2) + 1);
            if (isAvailable(new Position(x,y))){
                beasts.add(new Beast(x, y));
                occupied.add(new Position(x, y));
            }
        }

        return beasts;
    }

    @Override
    protected Player createPlayer() {
        return new Player(width / 3, height / 3);
    }

    @Override
    protected List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        while (walls.size() < numberOfWalls) {
            int x = (rng.nextInt(width - 2) + 1);
            int y = (rng.nextInt(height - 2) + 1);
            if (isAvailable(new Position(x,y))) {
                walls.add(new Wall(x, y));
                occupied.add(new Position(x, y));
            }
        }
        for (int x = 0; x < width; x++) {
            walls.add(new Wall(x, 0));
            walls.add(new Wall(x, height - 1));
            occupied.add(new Position(x, 0));
            occupied.add(new Position(x, height-1));
        }

        for (int y = 1; y < height - 1; y++) {
            walls.add(new Wall(0, y));
            walls.add(new Wall(width - 1, y));
            occupied.add(new Position(0, y));
            occupied.add(new Position(width-1, y));
        }

        return walls;
    }

    @Override
    protected List<Block> createBlocks() {
        List<Block> blocks = new ArrayList<>();

        while (blocks.size() < numberOfBlocks){
            int x = (rng.nextInt(width - 2) + 1);
            int y = (rng.nextInt(height - 2) + 1);
            if (isAvailable(new Position(x,y))){
                blocks.add(new Block(x, y));
                occupied.add(new Position(x, y));
            }
        }

        return blocks;

    }

    @Override
    protected List<Egg> createEggs() {
        List<Egg> eggs = new ArrayList<>();

        while (eggs.size() < numberOfEggs){
            int x = (rng.nextInt(width - 2) + 1);
            int y = (rng.nextInt(height - 2) + 1);
            if (isAvailable(new Position(x,y))){
                eggs.add(new Egg(x, y));
                occupied.add(new Position(x, y));
            }
        }
        return eggs;

    }

    @Override
    protected List<PowerUp> createPowerUps() {
        List<PowerUp> powerUps = new ArrayList<>();

        while (powerUps.size() < numberOfPowerUps){
            int a = (int) (Math.random()*2);
            int x = (rng.nextInt(width - 2) + 1);
            int y = (rng.nextInt(height - 2) + 1);
            if (isAvailable(new Position(x,y))){
                occupied.add(new Position(x, y));
                if (a == 0) powerUps.add(new Shield(x, y));
                else powerUps.add(new Heart(x, y));
            }
        }
        return powerUps;
    }
}
