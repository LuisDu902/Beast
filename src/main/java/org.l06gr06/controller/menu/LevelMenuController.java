package org.l06gr06.controller.menu;

import org.l06gr06.Game;
import org.l06gr06.controller.Controller;
import org.l06gr06.controller.game.ArenaController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.arena.LoaderArenaBuilder;
import org.l06gr06.model.game.arena.RandomArenaBuilder;
import org.l06gr06.model.menu.LevelMenu;
import org.l06gr06.states.GameState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class LevelMenuController  extends Controller<LevelMenu> {
    public LevelMenuController(LevelMenu menu) {
        super(menu);
    }
    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP : {
                getModel().previousEntry();
                break;
            }
            case DOWN : {
                getModel().nextEntry();
                break;
            }
            case SELECT : {
                if (getModel().isSelectedExit()) game.setState(null);
                else{
                URL resource = ArenaController.class.getResource("/levels/score.csv");
                BufferedWriter writer = new BufferedWriter(new FileWriter(resource.getFile(), true));
                String str = "";
                if (getModel().isSelected(0)) {
                    str = "~";
                    game.setState(new GameState(new RandomArenaBuilder(50, 20, 2, 150, 1, 15).createArena()));
                } else if (getModel().isSelected(1)) {
                    str = "~~";
                    game.setState(new GameState(new RandomArenaBuilder(50, 20, 4, 100, 3, 10).createArena()));
                } else if (getModel().isSelected(2)) {
                    str = "~~~";
                    game.setState(new GameState(new RandomArenaBuilder(50, 20, 6, 50, 6, 5).createArena()));
                }
                writer.append(str);
                writer.append(',');
                writer.close();
                }
            }
        }
    }
}
