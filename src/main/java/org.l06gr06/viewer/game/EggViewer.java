package org.l06gr06.viewer.game;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.elements.Egg;

public class EggViewer implements ElementViewer<Egg> {
    @Override
    public void draw(Egg egg, GUI gui) {
        gui.drawEgg(egg.getPosition());
    }
}
