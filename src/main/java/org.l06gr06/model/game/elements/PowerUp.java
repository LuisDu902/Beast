package org.l06gr06.model.game.elements;

public class PowerUp extends Element {
    private long creationTime;
    private long duration;

    public PowerUp(int x, int y) {
        super(x, y);
        this.duration = 10;
        this.creationTime = System.currentTimeMillis();
    }

    public long getCreationTime(){ return creationTime; }

    public long getDuration() {
        return duration;
    }
}
