package com.shardul;

import com.shardul.GameWindow.GameWindow;

import javax.swing.*;
import java.awt.*;

//Main class to run the application
public class Main {

    public static void main(String[] args) {
        //initialize the game window
        GameWindow game = new GameWindow();

        JFrame frame = new JFrame();

        //setting the JFrame
        frame.setTitle("Brick Game");
        frame.setSize(new Dimension(800,600));
        frame.setLocation(100,100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        //adding game window object to the JFrame
        frame.add(game);
    }
}
