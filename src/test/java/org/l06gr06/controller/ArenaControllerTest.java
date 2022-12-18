package org.l06gr06.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.Game;
import org.l06gr06.controller.game.ArenaController;
import org.l06gr06.controller.game.BeastController;
import org.l06gr06.controller.game.PlayerController;
import org.l06gr06.controller.game.PowerUpController;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Player;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.states.ScoreMenuState;
import org.l06gr06.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class ArenaControllerTest {
    private ArenaController controller;

    private PlayerController playerController;

    private BeastController beastController;

    private PowerUpController powerUpController;

    private Arena arena;
    private Game game;

    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        arena = new Arena(20, 20);


        arena.setPlayer(new Player(new Position(5, 5)));
        arena.setWalls(new ArrayList<>());
        arena.setPowerUps(new ArrayList<>());
        arena.setBlocks(new ArrayList<>());
        arena.setBeasts(new ArrayList<>());

        controller = new ArenaController(arena);
        playerController = mock(PlayerController.class);
        beastController = mock(BeastController.class);
        powerUpController = mock(PowerUpController.class);
        game = new Game(null);
    }

    @Test
    void quit() throws IOException {
        controller.step(game, GUI.ACTION.QUIT,1000);
        long[] stats = {0};
        State expected = new ScoreMenuState(new ScoreMenu(stats));
        State actual = game.getState();
        assertEquals(expected,actual);
    }

    @Test
    void lose() throws IOException {
        controller.step(game, GUI.ACTION.RIGHT,1);
        long[] stats = {0};
        State expected = new ScoreMenuState(new ScoreMenu(stats));
        State actual = game.getState();
        assertEquals(expected,actual);
    }

    @Test
    void step() throws IOException {
        controller.step(game, GUI.ACTION.RIGHT,1);
    }
}