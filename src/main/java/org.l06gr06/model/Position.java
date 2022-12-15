package org.l06gr06.model;

import org.l06gr06.gui.GUI;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }


    public Position getDirection(GUI.ACTION action){
        switch (action) {
            case UP : return getUp();
            case DOWN : return getDown();
            case LEFT : return getLeft();
            case RIGHT : return getRight();
        }
        return null;
    }
    public void goDirection(GUI.ACTION action){
        switch (action){
            case UP : {
                goUp();
                break;
            }
            case DOWN : {
                goDown();
                break;
            }
            case LEFT :{
                goLeft();
                break;
            }
            case RIGHT :{
                goRight();
                break;
            }
        }
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
        if (x > pos2.x && y < pos2.y){
            return 2;
        }
        if (x > pos2.x && y > pos2.y){
            return 3;
        }
        if (x < pos2.x && y > pos2.y){
            return 4;
        }
        return 1;
    }
}
