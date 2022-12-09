package org.l06gr06.model.game.arena;

import org.l06gr06.model.game.elements.*;

import java.util.ArrayList;
import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        List<PowerUp> powerUps = new ArrayList<>();
        arena.setPowerUps(powerUps);
        arena.setPlayer(createPlayer());
        arena.setBeasts(createBeasts());
        arena.setWalls(createWalls());
        arena.setBlocks(createBlocks());

        return arena;
    }


    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Beast> createBeasts();

    protected abstract Player createPlayer();

    protected abstract List<Block> createBlocks();
    //protected abstract List<Egg> createEggs();
}

