package org.l06gr06.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.gui.GUI;

import org.l06gr06.model.Position;
import org.l06gr06.model.menu.MainMenu;
import org.l06gr06.viewer.Viewer;
import org.l06gr06.viewer.menu.MainMenuViewer;
import org.mockito.Mockito;

import java.util.Arrays;

public class MainMenuViewerTest {
    private GUI gui;
    private Viewer viewer;
    private MainMenu mainMenu;
    @BeforeEach
    void setUp() {
        mainMenu = new MainMenu((Arrays.asList("[Press enter to play]")));
        viewer = new MainMenuViewer(mainMenu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawText(){
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(7+mainMenu.getNumberEntries())).drawText(Mockito.any(Position.class),Mockito.any(String.class),Mockito.any(String.class));
    }
}
