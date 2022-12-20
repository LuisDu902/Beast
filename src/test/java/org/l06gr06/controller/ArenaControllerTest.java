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
import org.l06gr06.model.game.arena.RandomArenaBuilder;
import org.l06gr06.model.game.elements.Beast;
import org.l06gr06.model.game.elements.Player;
import org.l06gr06.model.menu.ScoreBoardMenu;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.states.ScoreMenuState;
import org.l06gr06.states.State;
import org.mockito.Mockito;

import java.awt.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ArenaControllerTest {
    private ArenaController controller;

    private PlayerController playerController;

    private BeastController beastController;

    private PowerUpController powerUpController;

    private Arena arena;
    private Game game;

    private Method saveScoreMethod() throws NoSuchMethodException {
        Method method = ArenaController.class.getDeclaredMethod("saveScore");
        method.setAccessible(true);
        return method;
    }
    @BeforeEach
    void setUp() throws IOException, URISyntaxException, FontFormatException {
        arena = new Arena(20, 20);


        arena.setPlayer(new Player(new Position(5, 5)));
        arena.setWalls(new ArrayList<>());
        arena.setPowerUps(new ArrayList<>());
        arena.setBlocks(new ArrayList<>());
        arena.setBeasts(new ArrayList<>());

        controller = new ArenaController(arena);
        game = new Game(null);
    }

    @Test
    void quit() throws IOException {
        controller.step(game, GUI.ACTION.QUIT,1);
        assertEquals(1,arena.getTimer());
        long[] stats = {0};
        State expected = new ScoreMenuState(new ScoreMenu(stats));
        State actual = game.getState();
        assertEquals(expected,actual);
    }

    @Test
    void win() throws IOException {
        arena.setTimer(3050);

        controller.step(game, GUI.ACTION.RIGHT,1);
        assertEquals(5,controller.getPlayerController().getStats()[4]);
        assertEquals(61,controller.getPlayerController().getStats()[5]);

        State expected = new ScoreMenuState(new ScoreMenu(controller.getPlayerController().getStats()));
        State actual = game.getState();
        assertEquals(expected,actual);

        URL resource = ScoreBoardMenu.class.getResource("/score/score.csv");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        String lastScore = br.readLine();
        assertEquals("189,01:01",lastScore);

        BufferedWriter writer = new BufferedWriter(new FileWriter(resource.getFile(), false));
        writer.append("");
        writer.close();

    }

    @Test
    void step() throws IOException {
        playerController = mock(PlayerController.class);
        beastController = mock(BeastController.class);
        powerUpController = mock(PowerUpController.class);
        controller.setPlayerController(playerController);
        controller.setBeastController(beastController);
        controller.setPowerUpController(powerUpController);

        arena.setBeasts(Arrays.asList(new Beast(new Position(0,0),0)));
        controller.step(game, GUI.ACTION.RIGHT,1);

        verify(playerController,Mockito.times(1)).step(game,GUI.ACTION.RIGHT,1);
        verify(beastController,Mockito.times(1)).step(game,GUI.ACTION.RIGHT,1);
        verify(powerUpController,Mockito.times(1)).step(game,GUI.ACTION.RIGHT,1);

    }

    @Test
    void saveScore() throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        playerController = mock(PlayerController.class);
        arena.setTimer(3050);
        controller.setPlayerController(playerController);
        long[] stats = {10,10,10,10,10,10};
        when(playerController.getStats()).thenReturn(stats);
        saveScoreMethod().invoke(controller);

        URL resource = ScoreBoardMenu.class.getResource("/score/score.csv");
        assert resource != null;
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null;) lines.add(line);
        String lastScore = lines.get(lines.size()-1);
        assertEquals("6240,01:01",lastScore);

        BufferedWriter writer = new BufferedWriter(new FileWriter(resource.getFile(), false));
        writer.append("");
        writer.close();
    }
}