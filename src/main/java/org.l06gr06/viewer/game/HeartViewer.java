package org.l06gr06.viewer.game;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.elements.Heart;
import org.l06gr06.model.game.elements.PowerUp;

public class HeartViewer extends PowerUpViewer {
    @Override
    public void draw(PowerUp powerUp, GUI gui) {
        gui.drawHeart(powerUp.getPosition());
    }
}