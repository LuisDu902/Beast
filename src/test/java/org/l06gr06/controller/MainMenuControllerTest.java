package org.l06gr06.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.Game;
import org.l06gr06.controller.menu.MainMenuController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.menu.LevelMenu;
import org.l06gr06.model.menu.MainMenu;
import org.l06gr06.states.LevelMenuState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainMenuControllerTest {
    private MainMenuController controller;

    private MainMenu menu;

    private Game game;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        menu = new MainMenu((Arrays.asList("[Press enter to play]")));
        controller = new MainMenuController(menu);
        game = new Game(null);
    }

    @Test
    void changeState() throws IOException, URISyntaxException, FontFormatException {
        controller.step(game, GUI.ACTION.SELECT,1);
        assertEquals(new LevelMenuState(new LevelMenu(Arrays.asList("Easy", "Medium", "Difficult", "Exit"))),game.getState());
    }

}
