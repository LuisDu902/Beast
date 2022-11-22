package org.l06gr06.viewer.game;

import org.l06gr06.gui.GUI;
import org.l06gr06.model.game.elements.PowerUp;
import org.l06gr06.model.game.elements.Shield;

public class PowerUpViewer implements ElementViewer<PowerUp>{
    public void draw(PowerUp powerUp, GUI gui){
        gui.drawShield(powerUp.getPosition());
    }
}
