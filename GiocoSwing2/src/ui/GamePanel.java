package ui;

import model.Giocatore;
import model.Pallino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements KeyListener {
    int limiti;
    int punteggio;
    Giocatore giocatore;
    ArrayList<Pallino> pallini;
    public static final int NUMERO_PALLINI = 10;

    public GamePanel(int limiti) {
        this.punteggio = 0;
        this.limiti = limiti;
        this.giocatore = new Giocatore();
        this.pallini = new ArrayList<>();

        setFocusable(true);
        addKeyListener(this);

        generaPallini();
    }

    private void generaPallini() {
        Random rand = new Random();
        for(int i = 0; i < NUMERO_PALLINI; i++) {
            int x = rand.nextInt(limiti);
            int y = rand.nextInt(limiti);

            pallini.add(new Pallino(x, y));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Disegno dei pallini
        for(Pallino pallino : pallini) {
            if(pallino.isVisibile()) {
                g.setColor(Color.RED);
                g.fillOval(pallino.getX(), pallino.getY(), Pallino.SIZE, Pallino.SIZE);
            }
        }

        // Disegno del giocatore
        g.setColor(Color.BLUE);
        g.fillRect(giocatore.getX(), giocatore.getY(), Giocatore.SIZE, Giocatore.SIZE);

        // Punteggio
        g.setColor(Color.BLACK);
        g.drawString("Punti: " + punteggio, 10, 20);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            giocatore.setX(-10, getWidth());
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            giocatore.setX(10, getWidth());
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            giocatore.setY(-10, getWidth());
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            giocatore.setY(10, getWidth());
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}
}
