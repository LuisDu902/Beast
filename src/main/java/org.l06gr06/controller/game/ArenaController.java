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
import java.util.Arrays;

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

    public void step(Game game, GUI.ACTION action, long time) throws IOException {

        if (action == GUI.ACTION.QUIT || getModel().getPlayer().getLife() == 0 || getModel().getBeasts().size() == 0) {
            StringBuilder str = new StringBuilder();
            long stats[] = playerController.getStats();
            long score = stats[0]*75 + stats[1]* 150 + stats[2] * 300 + stats[3] * 50 + stats[4] * 50 - stats[5];
            str.append(score);
            str.append(',');
            long timer = (time - getModel().getStartingTime())/1000;
            long min = timer/60;
            long sec = timer%60;
            String txt = String.format("%02d:%02d", min, sec);
            str.append(txt);
            str.append('\n');
            URL resource = ArenaController.class.getResource("/levels/score.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(resource.getFile(), true));
            writer.append(str.toString());

            writer.close();
            game.setState(new ScoreMenuState(new ScoreMenu(Arrays.asList("Play Again", "ScoreBoard", "Exit"),playerController.getStats())));
        }
        else {
            powerUpController.step(game, action, time);
            playerController.step(game, action, time);
            beastController.step(game, action, time);
        }
    }
}

