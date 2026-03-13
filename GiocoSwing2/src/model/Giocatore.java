package model;

import java.awt.*;

public class Giocatore {
    private int x;
    private int y;

    public static final int SIZE = 40;

    public Giocatore() {
        this.x = 100;
        this.y = 100;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int dx, int limite) {
        limite -= SIZE;

        int newPos = x + dx;

        if (newPos < 0) {
            this.x = 0;
        }
        else if (newPos > limite) {
            this.x = limite;
        }
        else {
            this.x = newPos;
        }
    }

    public void setY(int dy, int limite) {
        limite -= SIZE;

        int newPos = y + dy;

        if (newPos < 0) {
            this.y = 0;
        }
        else if (newPos > limite) {
            this.y = limite;
        }
        else {
            this.y = newPos;
        }
    }

    public Rectangle getLimiti() {
        return new Rectangle(x, y, SIZE, SIZE);
    }
}
