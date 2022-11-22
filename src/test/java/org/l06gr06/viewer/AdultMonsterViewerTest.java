package org.l06gr06.viewer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.elements.Monster;
import org.l06gr06.viewer.game.AdultMonsterViewer;
import org.mockito.Mockito;

public class AdultMonsterViewerTest {
    private Monster monster;
    private AdultMonsterViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        monster = new Monster(20, 20);
        viewer = new AdultMonsterViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(monster, gui);
        Mockito.verify(gui, Mockito.times(1)).drawAdultMonster(monster.getPosition());
    }
}
