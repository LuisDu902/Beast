package org.l06gr06.state;

import org.junit.jupiter.api.Test;
import org.l06gr06.controller.menu.MainMenuController;
import org.l06gr06.model.menu.MainMenu;
import org.l06gr06.states.*;
import org.l06gr06.viewer.menu.MainMenuViewer;

import java.io.IOException;
import static org.mockito.Mockito.*;
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