package org.l06gr06.model;

import java.util.Objects;

public class Position {
    private  int x;
    private  int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position getLeft() {
        return new Position(x - 1, y);
    }
    public Position getRight() {
        return new Position(x + 1, y);
    }
    public Position getUp() {
        return new Position(x, y - 1);
    }
    public Position getDown() {
        return new Position(x, y + 1);
    }
    public Position getUpLeft() {return new Position(x - 1,y - 1);}
    public Position getUpRight() {return new Position(x + 1,y - 1);}
    public Position getDownLeft() {return new Position(x - 1,y + 1);}
    public Position getDownRight() {return new Position(x + 1,y + 1);}

    public Position getCloserToPlayer(int quad) {
        int n = (int) (Math.random() * 3);
        switch (quad) {
            case 1:
                switch (n){
                    case 0: return getLeft();
                    case 1: return getUpLeft();
                    default: return getUp();
                }
            case 2:
                switch (n){
                    case 0: return getUp();
                    case 1: return getUpRight();
                    default: return getRight();
                }
            case 3:
                switch (n){
                    case 0: return getRight();
                    case 1: return getDownRight();
                    default: return getDown();
                }
            default:
                switch (n){
                    case 0: return getDown();
                    case 1: return getDownLeft();
                    default: return getLeft();
                }
        }
    }
    public void goRight() {
        x++;
    }
    public void goLeft() {
        x--;
    }
    public void goUp() {
        y--;
    }
    public void goDown() {
        y++;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int relativeQuad(Position pos2){
        if (this.getX() > pos2.getX() && this.getY() > pos2.getY()){
            return 3;
        }
        if (this.getX() < pos2.getX() && this.getY() > pos2.getY()){
            return 4;
        }
        if (this.getX() > pos2.getX() && this.getY() < pos2.getY()){
            return 2;
        }
        return 1;
    }
}
