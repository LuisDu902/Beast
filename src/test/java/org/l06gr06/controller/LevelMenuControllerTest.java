package org.l06gr06.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.Game;
import org.l06gr06.controller.menu.LevelMenuController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.arena.RandomArenaBuilder;
import org.l06gr06.model.menu.LevelMenu;
import org.l06gr06.states.GameState;
import org.l06gr06.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LevelMenuControllerTest {
    private LevelMenuController controller;

    private LevelMenu menu;

    private Game game;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        menu = new LevelMenu();
        controller = new LevelMenuController(menu);
        game = new Game(null);
    }

    @Test
    void nextEntry() throws IOException {
        controller.step(null, GUI.ACTION.DOWN,1);
        assertEquals(1, menu.getCurrentEntry());
    }

    @Test
    void previousEntry() throws IOException {
        controller.step(null, GUI.ACTION.DOWN,1);
        controller.step(null, GUI.ACTION.DOWN,1);
        controller.step(null, GUI.ACTION.UP,1);
        assertEquals(1, menu.getCurrentEntry());
    }

    @Test
    void exit() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.SELECT,1);
        assertNull(game.getState());
    }
    @Test
    void easy() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.SELECT,1);
        State expected = new GameState(new Arena(50,20));
        State actual = game.getState();
        assertEquals(expected,actual);
    }
    @Test
    void medium() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.SELECT,1);

        State expected = new GameState(new Arena(50,20));
        State actual = game.getState();
        assertEquals(expected,actual);
    }
    @Test
    void difficult() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.SELECT,1);
        State expected = new GameState(new RandomArenaBuilder(50, 20, 4, 100, 3, 10).createArena());
        State actual = game.getState();
        assertEquals(expected,actual);
    }

}
