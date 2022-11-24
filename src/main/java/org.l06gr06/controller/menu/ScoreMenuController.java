package org.l06gr06.controller.menu;

import org.l06gr06.Game;
import org.l06gr06.controller.Controller;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.arena.LoaderArenaBuilder;
import org.l06gr06.model.menu.LevelMenu;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.states.GameState;
import org.l06gr06.states.LevelState;

import java.io.IOException;
import java.util.Arrays;

public class ScoreMenuController extends Controller<ScoreMenu> {
    public ScoreMenuController(ScoreMenu menu) {
        super(menu);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedPlayAgain()) game.setState(new LevelState(new LevelMenu(Arrays.asList("Easy", "Medium", "Difficult", "Exit"))));
        }
    }
}
