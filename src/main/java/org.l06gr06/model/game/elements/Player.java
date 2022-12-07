package org.l06gr06.model.game.elements;


public class Player extends Element {
    private int life;
    private int phase;

    public Player(int x, int y) {
        super(x, y);
        this.life = 5;
        this.phase = 0;
    }
    public void becomeImmortal(){this.phase = 1;}
    public void backToNormal(){this.phase = 0;}
    public void decreaseLife() {
        this.life--;
    }

    public void increaseLife() {
        this.life++;
    }

    public int getLife() {
        return life;
    }
    public int getPhase(){return phase;}
}
