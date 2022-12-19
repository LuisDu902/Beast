package org.l06gr06.controller.game;

import org.l06gr06.Game;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.states.ScoreMenuState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class ArenaController extends GameController {
    private PlayerController playerController;
    private BeastController beastController;
    private PowerUpController powerUpController;

    public ArenaController(Arena arena) {
        super(arena);
        this.playerController = new PlayerController(arena);
        this.beastController = new BeastController(arena);
        this.powerUpController = new PowerUpController(arena);
    }

    public void setBeastController(BeastController beastController) {
        this.beastController = beastController;
    }



    public PlayerController getPlayerController() {
        return playerController;
    }

    public void setPowerUpController(PowerUpController powerUpController) {
        this.powerUpController = powerUpController;
    }

    public void setPlayerController(PlayerController playerController) {
        this.playerController = playerController;
    }

    private void saveScore() throws IOException {
        StringBuilder str = new StringBuilder();
        long[] stats = playerController.getStats();
        long score = stats[0]*75 + stats[1]* 150 + stats[2] * 300 + stats[3] * 50 + stats[4] * 50 - stats[5];
        long timer = getModel().getTimer()/50;
        long min = timer/60; long sec = timer%60;
        str.append(score).append(',').append(String.format("%02d:%02d", min, sec)).append('\n');
        URL resource = ArenaController.class.getResource("/score/score.csv");
        assert resource != null;
        BufferedWriter writer = new BufferedWriter(new FileWriter(resource.getFile(), true));
        writer.append(str.toString());
        writer.close();
    }
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        getModel().increaseTimer();
        if (action == GUI.ACTION.QUIT || getModel().getPlayer().getLife() == 0 || getModel().getBeasts().size() == 0) {
            playerController.getStats()[4] = getModel().getPlayer().getLife();
            playerController.getStats()[5] = getModel().getTimer()/50;
            saveScore();
            game.setState(new ScoreMenuState(new ScoreMenu(playerController.getStats())));
        }
        else {
            powerUpController.step(game, action, time);
            playerController.step(game, action, time);
            beastController.step(game, action, time);
        }
    }
}

