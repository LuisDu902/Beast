package org.l06gr06.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.elements.Shield;
import org.l06gr06.viewer.game.ShieldViewer;
import org.mockito.Mockito;

public class ShieldViewerTest {
    private Shield shield;
    private ShieldViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        shield = new Shield(20, 20);
        viewer = new ShieldViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(shield, gui);
        Mockito.verify(gui, Mockito.times(1)).drawShield(shield.getPosition());
    }
}