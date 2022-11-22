package org.l06gr06.model.game.elements;

public class Hero extends Element {
    private int energy;

    public Hero(int x, int y) {
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
