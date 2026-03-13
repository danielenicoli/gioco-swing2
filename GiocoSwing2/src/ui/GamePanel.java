package ui;

import model.Pallino;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel {
    int limiti;
    ArrayList<Pallino> pallini;
    public static final int NUMERO_PALLINI = 3;

    public GamePanel(int limiti) {
        this.limiti = limiti;
        this.pallini = new ArrayList<>();
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
    }
}
