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

    private final long startingTime;


    public Arena(int width, int height) { // ao criar a arena devemos inicializar todas as listas de elementos como listas vazias?
        this.width = width;
        this.height = height;
        this.startingTime = System.currentTimeMillis();
    }

    public long getStartingTime() {
        return startingTime;
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

    public boolean canMove(Position position){
        return !isEgg(position) && !isBlock(position) && !isWall(position);
    }
    public boolean isEmpty(Position position) {
        return !isBlock(position) && !isWall(position) && !isPowerUp(position) && !isBeast(position);
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
    public void createPowerUp(){
        Random  rng = new Random();
        int a = (int) (Math.random()*2);
        int x = (rng.nextInt(width - 2) + 1);
        int y = (rng.nextInt(height - 2) + 1);
        if (isEmpty(new Position(x,y))){
            if (a == 0) powerUps.add(new Shield(x, y));
            else powerUps.add(new Heart(x, y));
        }
    }
    public void hatchEggs(){
        for (Beast beast : beasts){
            if (beast.getPhase() == 0) beast.evolve();
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
