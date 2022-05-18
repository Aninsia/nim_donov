package main.java;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        User_interface new_interface = new User_interface();
        JFrame frame = new JFrame();
        frame.add(new_interface);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}