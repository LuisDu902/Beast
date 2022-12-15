package org.l06gr06.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.Game;
import org.l06gr06.controller.menu.MainMenuController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.menu.MainMenu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;

public class MainMenuControllerTest {
    private MainMenuController controller;

    private MainMenu menu;

    @BeforeEach
    void setUp() {
        menu = new MainMenu((Arrays.asList("[Press enter to play]")));
        controller = new MainMenuController(menu);
    }
    /*
    @Test
    void changeState() throws IOException, URISyntaxException, FontFormatException {
        controller.step(new Game(), GUI.ACTION.SELECT,1);
    }
     */
}
