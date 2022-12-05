package org.l06gr06.model.game.elements;

public class PowerUp extends Element {
    private long duration;
    public PowerUp(int x, int y) {
        super(x, y);
        this.duration = 10;
    }
    public void decreaseDuration(){
        this.duration --;
    }

    public long getDuration() {return duration;}
}
