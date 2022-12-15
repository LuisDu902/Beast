package org.l06gr06.controller.game;

import org.l06gr06.Game;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Element;
import org.l06gr06.model.game.elements.Player;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.states.ScoreMenuState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class ArenaController extends GameController {
    private final PlayerController playerController;
    private final BeastController beastController;
    private final PowerUpController powerUpController;

    public ArenaController(Arena arena) {
        super(arena);
        this.playerController = new PlayerController(arena);
        this.beastController = new BeastController(arena);
        this.powerUpController = new PowerUpController(arena);
    }

    private StringBuilder Score(long time){
        StringBuilder str = new StringBuilder();
        long[] stats = playerController.getStats();
        long score = stats[0]*75 + stats[1]* 150 + stats[2] * 300 + stats[3] * 50 + stats[4] * 50 - stats[5];
        str.append(score);
        str.append(',');
        long timer = (time - getModel().getStartingTime())/1000;
        long min = timer/60;
        long sec = timer%60;
        String txt = String.format("%02d:%02d", min, sec);
        str.append(txt).append('\n');

        return str;

    }

    private void saveScore(StringBuilder str) throws IOException {
        URL resource = ArenaController.class.getResource("/score/score.csv");
        BufferedWriter writer = new BufferedWriter(new FileWriter(resource.getFile(), true));
        writer.append(str.toString());
        writer.close();
    }
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        playerController.getStats()[4] = getModel().getPlayer().getLife();
        playerController.getStats()[5] = (time - getModel().getStartingTime())/1000;
        if (action == GUI.ACTION.QUIT || getModel().getPlayer().getLife() == 0 || getModel().getBeasts().size() == 0) {
            saveScore(Score(time));
            game.setState(new ScoreMenuState(new ScoreMenu(playerController.getStats())));
        }
        else {
            powerUpController.step(game, action, time);
            playerController.step(game, action, time);
            beastController.step(game, action, time);
        }
    }

}

