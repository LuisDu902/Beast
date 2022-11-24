package org.l06gr06.model.game.elements;

import org.l06gr06.viewer.game.PlayerViewer;

public class Player extends Element {
    private int energy;

    public Player(int x, int y) {
        super(x, y);
        this.energy = 5;
    }

    public void decreaseEnergy() {
        this.energy--;
    }

    public void increaseEnergy() {
        this.energy++;
    }

    public int getEnergy() {
        return energy;
    }
}
