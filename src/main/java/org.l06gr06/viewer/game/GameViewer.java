package org.l06gr06.viewer.game;

import org.l06gr06.Game;
import org.l06gr06.gui.GUI;
import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;
import org.l06gr06.model.game.elements.Element;
import org.l06gr06.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {

    private WallViewer wallViewer;
    private BeastViewer beastViewer;
    private PlayerViewer playerViewer;
    private BlockViewer blockViewer;
    private EggViewer eggViewer;
    private PowerUpViewer powerUpViewer;

    public GameViewer(Arena arena) {

        super(arena);
        this.playerViewer = new PlayerViewer();
        this.wallViewer = new WallViewer();
        this.beastViewer = new BeastViewer();
        this.eggViewer = new EggViewer();
        this.blockViewer = new BlockViewer();
        this.powerUpViewer = new PowerUpViewer();
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getWalls(), wallViewer);
        drawElements(gui, getModel().getBeasts(), beastViewer);
        drawElement(gui, getModel().getPlayer(), playerViewer);
        drawElements(gui, getModel().getBlocks(), blockViewer);
        //drawElements(gui, getModel().getEggs(), eggViewer);
        drawElements(gui, getModel().getPowerUps(), powerUpViewer);
        gui.drawText(new Position(0, 0), "Life: " + getModel().getPlayer().getLife(), "#FFD700");
        long x = (System.currentTimeMillis() - getModel().getStartingTime())/1000;
        long min = x/60;
        long sec = x%60;
        String txt = String.format("Timer: %02d:%02d", min, sec);
        gui.drawText(new Position(38, 0), txt, "#FFD700");

    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
