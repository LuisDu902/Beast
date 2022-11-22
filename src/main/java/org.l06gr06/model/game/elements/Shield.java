package org.l06gr06.model.game.elements;

public class Shield extends PowerUp{
    private int timer;
    public Shield(int x, int y) {
        super(x, y);
        this.timer = 10;
    }

}
