package org.l06gr06.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.Game;
import org.l06gr06.controller.menu.ScoreMenuController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.menu.LevelMenu;
import org.l06gr06.model.menu.ScoreBoardMenu;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.states.LevelMenuState;
import org.l06gr06.states.ScoreBoardMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreMenuControllerTest {
    private ScoreMenuController controller;

    private ScoreMenu menu;

    private Game game;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        long[] stats = {0};
        menu = new ScoreMenu((Arrays.asList("Play Again", "ScoreBoard","Exit")),stats);
        controller = new ScoreMenuController(menu);
        game = new Game(null);
    }

    @Test
    void nextEntry() throws IOException {
        controller.step(null, GUI.ACTION.RIGHT,1);
        assertEquals(1, menu.getCurrentEntry());
    }

    @Test
    void previousEntry() throws IOException {
        controller.step(null, GUI.ACTION.RIGHT,1);
        controller.step(null, GUI.ACTION.RIGHT,1);
        controller.step(null, GUI.ACTION.LEFT,1);
        assertEquals(1, menu.getCurrentEntry());
    }

    @Test
    void exit() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.RIGHT,1);
        controller.step(game, GUI.ACTION.RIGHT,1);
        controller.step(game, GUI.ACTION.SELECT,1);
        assertEquals(null,game.getState());
    }
    @Test
    void playAgain() throws IOException, URISyntaxException, FontFormatException {

        controller.step(game, GUI.ACTION.SELECT,1);
        assertEquals(new LevelMenuState(new LevelMenu(Arrays.asList("Easy", "Medium", "Difficult", "Exit"))),game.getState());
    }
    /*
    @Test
    void scoreBoard() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.RIGHT,1);
        controller.step(game, GUI.ACTION.SELECT,1);

        assertEquals(new ScoreBoardMenuState(new ScoreBoardMenu(Arrays.asList("Play again", "Exit"))),game.getState());
    }*/


}
