package org.l06gr06.controller.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.Game;
import org.l06gr06.controller.game.ArenaController;
import org.l06gr06.controller.menu.LevelMenuController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.arena.RandomArenaBuilder;
import org.l06gr06.model.menu.LevelMenu;
import org.l06gr06.states.GameState;
import org.l06gr06.states.State;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(menu.isSelected(0));
        assertFalse(menu.isSelected(1));
        assertFalse(menu.isSelected(2));
        assertFalse(menu.isSelected(3));
        State expected = new GameState((new RandomArenaBuilder(50, 20, 2, 150, 1, 15).createArena()));
        State actual = game.getState();
        assertEquals(expected,actual);

        URL resource = ArenaController.class.getResource("/score/score.csv");
        assert resource != null;
        BufferedWriter writer = new BufferedWriter(new FileWriter(resource.getFile(), false));
        writer.append("");
        writer.close();
    }
    @Test
    void medium() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.SELECT,1);
        assertFalse(menu.isSelected(0));
        assertTrue(menu.isSelected(1));
        assertFalse(menu.isSelected(2));
        assertFalse(menu.isSelected(3));

        State expected = new GameState((new RandomArenaBuilder(50, 20, 4, 100, 4, 10).createArena()));
        State actual = game.getState();
        assertEquals(expected,actual);

        URL resource = ArenaController.class.getResource("/score/score.csv");
        assert resource != null;
        BufferedWriter writer = new BufferedWriter(new FileWriter(resource.getFile(), false));
        writer.append("");
        writer.close();
    }
    @Test
    void difficult() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.SELECT,1);
        assertFalse(menu.isSelected(0));
        assertFalse(menu.isSelected(1));
        assertTrue(menu.isSelected(2));
        assertFalse(menu.isSelected(3));
        State expected = new GameState((new RandomArenaBuilder(50, 20, 6, 50, 7, 5).createArena()));
        State actual = game.getState();
        assertEquals(expected,actual);
        assertNotEquals(new GameState((new RandomArenaBuilder(30, 20, 6, 50, 7, 5).createArena())),actual);

        URL resource = ArenaController.class.getResource("/score/score.csv");
        assert resource != null;
        BufferedWriter writer = new BufferedWriter(new FileWriter(resource.getFile(), false));
        writer.append("");
        writer.close();
    }

}