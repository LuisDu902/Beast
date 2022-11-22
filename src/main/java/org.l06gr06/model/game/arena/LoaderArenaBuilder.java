package org.l06gr06.model.game.arena;

import org.l06gr06.model.game.elements.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder{
    private final int level;
    private final List<String> lines;

    public LoaderArenaBuilder(int level) throws IOException {
        //to be implemented...
    }

    private List<String> readLines(BufferedReader br) throws IOException {
        //to be implemented...
        return null;
    }

    @Override
    protected int getWidth() {
        //to be implemented...
        return 0;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected List<Wall> createWalls() {
        //to be implemented...
        return null;
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
