package org.l06gr06.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.Game;
import org.l06gr06.controller.game.ArenaController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Player;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.states.GameState;
import org.l06gr06.states.ScoreMenuState;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArenaControllerTest {
    private ArenaController controller;

    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        arena = new Arena(20, 20);


        arena.setPlayer(new Player(5, 5));
        arena.setWalls(new ArrayList<>());
        arena.setPowerUps(new ArrayList<>());
        arena.setBlocks(new ArrayList<>());
        arena.setBeasts(new ArrayList<>());

        controller = new ArenaController(arena);
        game = new Game(null);
    }

    @Test
    void quit() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.QUIT,1000);
        long[] stats = {0};
        assertEquals(new ScoreMenuState(new ScoreMenu(Arrays.asList("Play Again", "ScoreBoard", "Exit"),stats)),game.getState());
    }

    @Test
    void lose() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.RIGHT,1);
    }


}