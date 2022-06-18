package main.java;

import javax.swing.*;
import java.awt.*;

public class User_interface extends JPanel {
    public static int[] table;
    public static state game_state;

    public User_interface() {
        game_state = state.START;
        table = new int[3];
        JLabel d = new JLabel("Введите откуда и куда хотите переместить спички" +
                "\n в виде:(1,2)");

        JTextField m = new JTextField("");
        JButton f = new JButton();

        JButton a = new JButton("start");
        a.setBounds(130, 70, 150, 40);
        a.addActionListener(e -> {
            table[0] = 11;
            table[1] = 7;
            table[2] = 6;
            game_state = state.START;
        });
        m.setColumns(20);
        f.addActionListener(e -> {
            String var = m.getText();
            Game.move(var);
            this.repaint();
        });

        JButton c = new JButton("exit");
        c.setBounds(130, 150, 150, 40);
        c.addActionListener(e -> System.exit(0));

        add(a);
        add(c);
        add(d);
        add(m);
        add(f);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.blue);
        Dimension size = getSize();
        Insets insets = getInsets();
        int w = size.width - insets.left - insets.right;
        int h = size.height - insets.top - insets.bottom;
        int zoom = 20;
        switch (game_state) {
            case START -> {
                for (int j = 0; j < 3; j++) {
                    int x = (j * zoom) % w + w / 2;
                    for (int i = 0; i < table[j]; i++) {
                        int y = (i * zoom) % h + 50;
                        g2d.drawRect(x, y, zoom / 2, zoom);
                        g2d.fillRect(x, y, zoom / 2, zoom);
                    }
                    g2d.drawString(j + 1 + "bunch", x, (table[j] * zoom) % h + 100);
                }
            }
            case WIN -> {
                for (int j = 0; j < 3; j++) {
                    int x = (j * zoom) % w + w / 2;
                    for (int i = 0; i < table[j]; i++) {
                        int y = (i * zoom) % h + 50;
                        g2d.drawRect(x, y, zoom / 2, zoom);
                        g2d.fillRect(x, y, zoom / 2, zoom);
                    }
                    g2d.drawString(j + 1 + "bunch", x, (table[j] * zoom) % h + 60);
                }
                g2d.drawString("You win!", 130, 100);
                game_state = state.START;
            }
            case ERROR -> {
                g2d.drawString("Wrong input! first < second", 130, 60);
                game_state = state.START;
            }
            case INPUT_ERROR -> {
                g2d.drawString("Wrong input!", 130, 60);
                game_state = state.START;
            }
        }
    }
}
