package ui;

import javax.swing.*;

public class GameFrame extends JFrame {
    private static final int LIMIT = 500;

    public GameFrame() {
        setTitle("Gioco");
        setSize(LIMIT, LIMIT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new GamePanel(LIMIT));

        setVisible(true);
    }
}
