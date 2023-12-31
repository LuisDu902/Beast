package org.l06gr06.viewer.game;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.elements.Monster;

public class AdultMonsterViewer implements ElementViewer<Monster> {
    @Override
    public void draw(Monster monster, GUI gui) {
        gui.drawAdultMonster(monster.getPosition());
    }
}