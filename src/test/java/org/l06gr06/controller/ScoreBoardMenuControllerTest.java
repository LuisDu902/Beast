package org.l06gr06.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.Game;
import org.l06gr06.controller.menu.ScoreBoardMenuController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.menu.ScoreBoardMenu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardMenuControllerTest {
    private ScoreBoardMenuController controller;

    private ScoreBoardMenu menu;
    @BeforeEach
    void setUp(){
        menu = new ScoreBoardMenu((Arrays.asList("Play Again", "Exit")));
        controller = new ScoreBoardMenuController(menu);
    }

    @Test
    void nextEntry() throws IOException {
        controller.step(null, GUI.ACTION.DOWN,1);
        assertEquals("Exit", menu.getEntry(1));
    }

    @Test
    void previousEntry() throws IOException {
        controller.step(null, GUI.ACTION.DOWN,1);
        controller.step(null, GUI.ACTION.DOWN,1);
        controller.step(null, GUI.ACTION.UP,1);
        assertEquals("Play Again", menu.getEntry(0));
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
    void playAgain() throws IOException, URISyntaxException, FontFormatException {
        Game game = new Game();
        controller.step(game, GUI.ACTION.SELECT,1);
        //assertEquals(new GameState(new RandomArenaBuilder(50, 20, 4, 100, 3, 10).createArena()),game.getState());
    }
}
