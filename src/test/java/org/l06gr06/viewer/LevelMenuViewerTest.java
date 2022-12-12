package org.l06gr06.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.menu.LevelMenu;
import org.l06gr06.viewer.menu.LevelMenuViewer;
import org.mockito.Mockito;

import java.util.Arrays;

public class LevelMenuViewerTest {
    private GUI gui;
    private Viewer viewer;
    private LevelMenu levelMenu;
    @BeforeEach
    void setUp() {
        levelMenu = new LevelMenu(Arrays.asList("Level 1", "Level 2", "Level 3", "Exit"));
        viewer = new LevelMenuViewer(levelMenu);
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawText(){
        viewer.drawElements(gui);
        Mockito.verify(gui, Mockito.times(1+levelMenu.getNumberEntries())).drawText(Mockito.any(Position.class),Mockito.any(String.class),Mockito.any(String.class));
    }

}

