package org.l06gr06.model.game.arena;


import org.l06gr06.model.Position;
import org.l06gr06.model.game.elements.*;

import java.util.List;
import java.util.Random;

public class Arena {
    private final int width;
    private final int height;

    private Player player;
    private List<Beast> beasts;
    private List<Wall> walls;
    private List<Block> blocks;
    private List<PowerUp> powerUps;

    private long timer;


    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.timer = 0;
    }

    public void increaseTimer(){timer++;}

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
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

    public boolean canMove(Position position){
        return !isEgg(position) && !isBlock(position) && !isWall(position);
    }

    public boolean isEmpty(Position position) {
        return !isBlock(position) && !isWall(position) && !isPowerUp(position) && !isBeast(position);
    }

    public boolean isPlayer(Position position) {
        return player.getPosition().equals(position);
    }

    public boolean isBeast(Position position) {
        for (Beast beast : beasts)
            if (beast.getPosition().equals(position))
                return true;
        return false;
    }
    public boolean isEgg(Position position) {
        for (Beast beast : beasts)
            if (beast.getPosition().equals(position) && beast.getPhase() == 0)
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
    private Position randomAvailablePosition(){
        Random  rng = new Random();
        int x, y;
        do {
            x = (rng.nextInt(width - 2) + 1);
            y = (rng.nextInt(height - 5) + 4);
        }
        while (!isEmpty(new Position(x,y)));
        return new Position(x,y);
    }

    public void createPowerUp(){
        int a = (int) (Math.random()*2);
        Position pos = randomAvailablePosition();
        if (a == 0) powerUps.add(new Shield(pos));
        else powerUps.add(new Heart(pos));
    }
    public void hatchEggs(){
        for (Beast beast : beasts)
            if (beast.getPhase() == 0) beast.evolve();
    }

    public void respawnPlayer(){
        Position pos = randomAvailablePosition();
        player.setPosition(pos);
    }

    public void hitPlayer(){
        if (player.isImmortal()) player.backToNormal();
        else {
            player.decreaseLife();
            respawnPlayer();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arena arena = (Arena) o;
        return height == arena.height && width == arena.width;
    }
}
