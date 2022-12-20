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