package org.l06gr06.model.game.elements;


public class Player extends Element {
    private int life;

    public Player(int x, int y) {
        super(x, y);
        this.life = 5;
    }

    public void decreaseLife() {
        this.life--;
    }

    public void increaseLife() {
        this.life++;
    }

    public int getLife() {
        return life;
    }
}
