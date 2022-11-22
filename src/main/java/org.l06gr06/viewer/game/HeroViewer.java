package org.l06gr06.viewer.game;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.elements.Hero;

public class HeroViewer implements ElementViewer<Hero> {
    @Override
    public void draw(Hero hero, GUI gui) {
        gui.drawHero(hero.getPosition());
    }
}
