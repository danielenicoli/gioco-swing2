package model;

import java.awt.*;

public class Pallino {
    private int x;
    private int y;
    private boolean visibile;

    public static final int SIZE = 20;

    public Pallino(int x, int y) {
        this.x = x;
        this.y = y;
        this.visibile = true;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isVisibile() {
        return visibile;
    }

    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }

    public Rectangle getLimiti() {
        return new Rectangle(x, y, SIZE, SIZE);
    }
}
