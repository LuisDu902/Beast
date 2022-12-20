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
import org.l06gr06.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreMenuControllerTest {
    private ScoreMenuController controller;

    private ScoreMenu menu;

    private Game game;
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        long[] stats = {0};
        menu = new ScoreMenu(stats);
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
    void exit() throws IOException {
        controller.step(game, GUI.ACTION.RIGHT,1);
        controller.step(game, GUI.ACTION.RIGHT,1);
        controller.step(game, GUI.ACTION.SELECT,1);
        assertNull(game.getState());
    }
    @Test
    void playAgain() throws IOException{

        controller.step(game, GUI.ACTION.SELECT,1);
        assertEquals(new LevelMenuState(new LevelMenu()),game.getState());
    }

    @Test
    void scoreBoard() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.RIGHT,1);

        try{
            controller.step(game, GUI.ACTION.SELECT,1);
            State expected = new ScoreBoardMenuState(new ScoreBoardMenu());
            assertEquals(expected,game.getState());
        } catch (Exception e){}

    }


}
