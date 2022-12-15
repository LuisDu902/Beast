package org.l06gr06.model.game.elements;

import org.l06gr06.model.Position;
import org.l06gr06.model.game.arena.Arena;

public class Beast extends Element{
    private int phase;

    public Beast(Position position, int phase) {
        super(position);
        this.phase = phase;
    }

    public void evolve() {
        this.phase++;
    }

    public int getPhase() {
        return phase;
    }

    public void interact(Element element, Arena arena){

    }
}
