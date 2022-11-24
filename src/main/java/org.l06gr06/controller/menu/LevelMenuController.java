package org.l06gr06.controller.menu;

import org.l06gr06.Game;
import org.l06gr06.controller.Controller;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.arena.LoaderArenaBuilder;
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
                else if (getModel().isSelected(0))
                    //game.setState(new GameState(new RandomArenaBuilder(50,20,2,150,15,0,15).createArena()));
                    game.setState(new GameState(new LoaderArenaBuilder(1).createArena()));
                else if (getModel().isSelected(1))
                    game.setState(new GameState(new RandomArenaBuilder(50,20,4,100,10,3,10).createArena()));
                else if (getModel().isSelected(2))
                    game.setState(new GameState(new RandomArenaBuilder(50,20,6,50,5,6,5).createArena()));
        }
    }
}
