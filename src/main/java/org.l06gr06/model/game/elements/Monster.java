package org.l06gr06.model.game.elements;

public class Monster extends Element{
    private int phase;

    public Monster(int x, int y) {
        super(x, y);
        this.phase = 1;
    }

    public void evolve() {
        this.phase++;
    }

    public int getPhase() {
        return phase;
    }
}
