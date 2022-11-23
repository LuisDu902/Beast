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
    private final HeroController heroController;
    private final MonsterController monsterController;

    public ArenaController(Arena arena) {
        super(arena);
        this.heroController = new HeroController(arena);
        this.monsterController = new MonsterController(arena);
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (action == GUI.ACTION.QUIT || getModel().getHero().getEnergy() == 0)
            game.setState(new ScoreState(new ScoreMenu(Arrays.asList("Play Again","Exit"))));
        else {
            heroController.step(game, action, time);
            monsterController.step(game, action, time);
        }
    }
}

