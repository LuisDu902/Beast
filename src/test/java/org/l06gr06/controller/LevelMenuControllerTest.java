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

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LevelMenuControllerTest {
    private LevelMenuController controller;

    private LevelMenu menu;
    @BeforeEach
    void setUp(){
        menu = new LevelMenu((Arrays.asList("Easy","Medium","Difficult","Exit")));
        controller = new LevelMenuController(menu);
    }

    @Test
    void nextEntry() throws IOException {
        controller.step(null, GUI.ACTION.DOWN,1);
        assertEquals("Medium", menu.getEntry(1));
    }

    @Test
    void previousEntry() throws IOException {
        controller.step(null, GUI.ACTION.DOWN,1);
        controller.step(null, GUI.ACTION.DOWN,1);
        controller.step(null, GUI.ACTION.UP,1);
        assertEquals("Medium", menu.getEntry(1));
    }

    @Test
    void exit() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.SELECT,1);
        assertEquals(null,game.getState());
    }
    @Test
    void easy() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        controller.step(game, GUI.ACTION.SELECT,1);

        assertEquals(new GameState(new Arena(50,20)),game.getState());
    }
    @Test
    void medium() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.SELECT,1);

        assertEquals(new GameState(new Arena(50,20)),game.getState());
    }
    @Test
    void difficult() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.SELECT,1);
        assertEquals(new GameState(new RandomArenaBuilder(50, 20, 4, 100, 3, 10).createArena()),game.getState());
    }
}
