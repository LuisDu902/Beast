package org.l06gr06.viewer.game;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Element;
import org.l06gr06.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), new WallViewer());
        drawElements(gui, getModel().getBeasts(), new BeastViewer());
        drawElement(gui, getModel().getPlayer(), new PlayerViewer());
        drawElements(gui, getModel().getBlocks(), new BlockViewer());
        drawElements(gui, getModel().getEggs(), new EggViewer());
        drawElements(gui, getModel().getPowerUps(), new PowerUpViewer());
        gui.drawText(new Position(0, 0), "Energy: " + getModel().getPlayer().getEnergy(), "#FFD700");
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
