package org.l06gr06.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.gui.GUI;
import org.mockito.Mockito;

public class EggViewerTest {
    private Egg egg;
    private EggViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        egg = new Egg(20, 20);
        viewer = new EggViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(egg, gui);
        Mockito.verify(gui, Mockito.times(1)).drawEgg(egg.getPosition());
    }
}
