package org.l06gr06.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.Game;
import org.l06gr06.controller.menu.ScoreMenuController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.menu.ScoreMenu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreMenuControllerTest {
    private ScoreMenuController controller;

    private ScoreMenu menu;
    @BeforeEach
    void setUp(){
        long[] stats = {0};
        menu = new ScoreMenu((Arrays.asList("Play Again", "ScoreBoard","Exit")),stats);
        controller = new ScoreMenuController(menu);
    }

    @Test
    void nextEntry() throws IOException {
        controller.step(null, GUI.ACTION.DOWN,1);
        assertEquals("ScoreBoard", menu.getEntry(1));
    }

    @Test
    void previousEntry() throws IOException {
        controller.step(null, GUI.ACTION.DOWN,1);
        controller.step(null, GUI.ACTION.DOWN,1);
        controller.step(null, GUI.ACTION.UP,1);
        assertEquals("ScoreBoard", menu.getEntry(1));
    }
    /*
    @Test
    void exit() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.DOWN,1);
        controller.step(game, GUI.ACTION.SELECT,1);
        assertEquals(null,game.getState());
    }
    @Test
    void playAgain() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        controller.step(game, GUI.ACTION.SELECT,1);
        //assertEquals(new GameState(new RandomArenaBuilder(50, 20, 4, 100, 3, 10).createArena()),game.getState());
    }
    @Test
    void scoreBoard() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        controller.step(game, GUI.ACTION.DOWN,1);
        //controller.step(game, GUI.ACTION.SELECT,1);
        //assertEquals(new GameState(new RandomArenaBuilder(50, 20, 4, 100, 3, 10).createArena()),game.getState());
    }

     */
}
