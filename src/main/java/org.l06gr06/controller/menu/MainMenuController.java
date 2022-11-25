package org.l06gr06.controller.menu;

import org.l06gr06.Game;
import org.l06gr06.controller.Controller;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.menu.LevelMenu;
import org.l06gr06.model.menu.MainMenu;
import org.l06gr06.states.LevelMenuState;

import java.io.IOException;
import java.util.Arrays;

public class MainMenuController extends Controller<MainMenu> {
    public MainMenuController(MainMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        if (action == GUI.ACTION.SELECT) {
            if (getModel().isSelectedStart())
                game.setState(new LevelMenuState(new LevelMenu(Arrays.asList("Easy", "Medium", "Difficult", "Exit"))));
        }
    }
}
