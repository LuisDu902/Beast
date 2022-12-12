package org.l06gr06.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.Game;
import org.l06gr06.controller.game.ArenaController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Player;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class ArenaControllerTest {
    private ArenaController controller;

    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(20, 20);


        arena.setPlayer(new Player(5, 5));
        arena.setWalls(List.of());
        arena.setPowerUps(List.of());
        arena.setBlocks(List.of());
        arena.setBeasts(List.of());

        controller = new ArenaController(arena);
    }

    @Test
    void score() throws IOException, URISyntaxException, FontFormatException {
        controller.step(new Game(), GUI.ACTION.QUIT,1000);
        URL resource = ArenaController.class.getResource("/levels/score.csv");
        BufferedReader reader = new BufferedReader(new FileReader(resource.getFile()));
    }

    @Test
    void controllers() throws IOException, URISyntaxException, FontFormatException {
        controller.step(new Game(), GUI.ACTION.RIGHT,1);
    }
}