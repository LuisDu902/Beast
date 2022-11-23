package org.l06gr06.model.game.elements;

public class Beast extends Element{
    private int phase;

    public Beast(int x, int y) {
        super(x, y);
        this.phase = 0;
    }

    public void evolve() {
        this.phase++;
    }

    public int getPhase() {
        return phase;
    }
}
