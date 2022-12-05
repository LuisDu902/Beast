package org.l06gr06.controller.game;

import org.l06gr06.Game;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Heart;
import org.l06gr06.model.game.elements.PowerUp;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.states.ScoreMenuState;

import java.io.IOException;
import java.util.Arrays;

public class ArenaController extends GameController {
    private final PlayerController playerController;
    private final BeastController beastController;
    private long powerUpTimer;
    private long eggTimer;

    public ArenaController(Arena arena) {
        super(arena);
        this.playerController = new PlayerController(arena);
        this.beastController = new BeastController(arena);
        this.powerUpTimer = 10;
        this.eggTimer = 10;
    }

    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (action == GUI.ACTION.QUIT)
            game.setState(new ScoreMenuState(new ScoreMenu(Arrays.asList("Play Again","Exit"))));
        else if (getModel().getPlayer().getLife() == 0){
            game.setState(new ScoreMenuState(new ScoreMenu(Arrays.asList("GAME OVER","Play Again","Exit"))));
        }
        else if (getModel().getBeasts().size() == 0){
            game.setState(new ScoreMenuState(new ScoreMenu(Arrays.asList("YOU WON","Play Again","Exit"))));
        }
        else {
            if ((time - getModel().getStartingTime())/1000 == eggTimer) getModel().hatchEggs();
            if ((time - getModel().getStartingTime())/1000 == powerUpTimer){
                getModel().createPowerUp();
                powerUpTimer += 5;
            }
            playerController.step(game, action, time);
            beastController.step(game, action, time);
        }
    }
}

