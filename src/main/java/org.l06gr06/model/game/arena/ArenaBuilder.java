package org.l06gr06.model.game.arena;

import org.l06gr06.model.game.elements.*;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setHero(createHero());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setPowerUps(createPowerUps());
        arena.setBlocks(createBlocks());
        arena.setEggs(createEggs());
        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract Hero createHero();
    protected abstract List<PowerUp> createPowerUps();
    protected abstract List<Block> createBlocks();
    protected abstract List<Egg> createEggs();
}

