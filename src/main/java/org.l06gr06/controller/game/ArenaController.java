package org.l06gr06.controller.game;

import org.l06gr06.Game;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.states.ScoreState;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.util.Arrays;

public class ArenaController extends GameController {
    private final PlayerController playerController;
    private final BeastController beastController;

    public ArenaController(Arena arena) {
        super(arena);
        this.playerController = new PlayerController(arena);
        this.beastController = new BeastController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (action == GUI.ACTION.QUIT || getModel().getPlayer().getEnergy() == 0 || getModel().getBeasts().size() == 0)
            game.setState(new ScoreState(new ScoreMenu(Arrays.asList("Play Again","Exit"))));
        else {
            playerController.step(game, action, time);
            beastController.step(game, action, time);
        }
    }
}

