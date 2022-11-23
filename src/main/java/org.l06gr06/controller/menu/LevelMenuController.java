package org.l06gr06.controller.menu;

import org.l06gr06.Game;
import org.l06gr06.controller.Controller;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.arena.RandomArenaBuilder;
import org.l06gr06.model.menu.LevelMenu;
import org.l06gr06.states.GameState;

import java.io.IOException;

public class LevelMenuController  extends Controller<LevelMenu> {
    public LevelMenuController(LevelMenu menu) {
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
                else
                    game.setState(new GameState(new RandomArenaBuilder(50,20,5,80,2,3).createArena()));
        }
    }
}