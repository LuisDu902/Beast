package org.l06gr06;

import org.junit.jupiter.api.Test;
import org.l06gr06.controller.game.ArenaController;
import org.l06gr06.controller.game.GameController;
import org.l06gr06.controller.menu.LevelMenuController;
import org.l06gr06.controller.menu.MainMenuController;
import org.l06gr06.controller.menu.ScoreBoardMenuController;
import org.l06gr06.controller.menu.ScoreMenuController;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.menu.LevelMenu;
import org.l06gr06.model.menu.MainMenu;
import org.l06gr06.model.menu.ScoreBoardMenu;
import org.l06gr06.model.menu.ScoreMenu;
import org.l06gr06.states.*;
import org.l06gr06.viewer.MainMenuViewerTest;
import org.l06gr06.viewer.game.GameViewer;
import org.l06gr06.viewer.menu.LevelMenuViewer;
import org.l06gr06.viewer.menu.MainMenuViewer;
import org.l06gr06.viewer.menu.ScoreBoardMenuViewer;
import org.l06gr06.viewer.menu.ScoreMenuViewer;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import org.l06gr06.gui.GUI;
import org.mockito.Mockito;

public class StateTest {

    @Test
    void mainMenuState() throws IOException {
        MainMenuState mainMenuState = new MainMenuState(new MainMenu());
        assertEquals(new MainMenuController(new MainMenu()), mainMenuState.getController());
        assertEquals(new MainMenuViewer(new MainMenu()), mainMenuState.getViewer());
    }

    @Test
    void levelMenuState() throws IOException {

        LevelMenuState levelMenuState = new LevelMenuState(new LevelMenu());
        assertEquals(new LevelMenuController(new LevelMenu()), levelMenuState.getController());
        assertEquals(new LevelMenuViewer(new LevelMenu()), levelMenuState.getViewer());
        }

    @Test
    void gameState() throws IOException {

        GameState gameState = new GameState(new Arena(50,20));
        assertEquals(new ArenaController(new Arena(50,20)), gameState.getController());
        assertEquals(new GameViewer(new Arena(50,20)), gameState.getViewer());
    }

    @Test
    void scoreMenuState() throws IOException {
        long[] stats = {0};
        ScoreMenuState scoreMenuState = new ScoreMenuState(new ScoreMenu(stats));
        assertEquals(new ScoreMenuController(new ScoreMenu(stats)), scoreMenuState.getController());
        assertEquals(new ScoreMenuViewer(new ScoreMenu(stats)), scoreMenuState.getViewer());
    }
    /*
    @Test
    void scoreBoardMenuState() throws IOException {

        ScoreBoardMenu scoreBoardMenu = new ScoreBoardMenu();
        ScoreBoardMenuViewer scoreBoardMenuViewer = new ScoreBoardMenuViewer(scoreBoardMenu, "scoreTest.csv");
        ScoreBoardMenuController scoreBoardMenuController = new ScoreBoardMenuController(scoreBoardMenu);
        ScoreBoardMenuState scoreBoardMenuState = new ScoreBoardMenuState(new ScoreBoardMenu(),"scoreTest.csv");
        assertEquals(new ScoreBoardMenuController(new ScoreBoardMenu()), scoreBoardMenuState.getController());
        //assertEquals(new ScoreBoardMenuViewer(new ScoreBoardMenu(),"scoreTest.csv"),scoreBoardMenuState.getViewer());
        //assertNotEquals(scoreBoardMenuState.getViewer(), null);
        //assertNotEquals(scoreBoardMenuState.getController(), null);

    }

     */
    @Test
    void notEqual() throws IOException {
        long[] stats = {0};
        assertNotEquals(new ScoreMenuState(new ScoreMenu(stats)),new MainMenuState(new MainMenu()));
    }

    @Test
    void step() throws IOException {
        MainMenuState mainMenuState = new MainMenuState(new MainMenu());
        MainMenuController mainMenuController = mock(MainMenuController.class);
        MainMenuViewer mainMenuViewer = mock(MainMenuViewer.class);
        mainMenuState.setController(mainMenuController);
        mainMenuState.setViewer(mainMenuViewer);
        GUI gui = mock(GUI.class);
        mainMenuState.step(null,gui,0);
        Mockito.verify(mainMenuViewer, Mockito.times(1)).draw(gui);
        Mockito.verify(mainMenuController, Mockito.times(1)).step(null,null,0);
    }
}
