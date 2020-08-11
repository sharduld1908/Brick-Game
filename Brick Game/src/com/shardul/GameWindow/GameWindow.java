package com.shardul.GameWindow;

import com.shardul.GameComponents.Ball;
import com.shardul.GameComponents.Brick;
import com.shardul.GameComponents.Slider;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

//Game window class
public class GameWindow extends JPanel implements KeyListener, ActionListener {
    private boolean gameOver = false;
    private boolean play = false;
    private int score = 0;

    //initialize game components
    private final Slider slider;
    private final Ball ball;
    private final ArrayList<Brick> bricks;

    //timer class
    private final Timer timer;

    //constructor initializes all the game objects(slider,ball,bricks)
    public GameWindow() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);

        //start timer
        timer = new Timer(10,this);
        timer.start();

        slider = new Slider(new Point(300, 526), 100, 10);

        int X = random(200,400);
        int Y = random(300,410);
        ball = new Ball(new Point(X, Y), 20);

        //brick grid
        bricks = new ArrayList<>();
        for(int j = 0;j<5;j++) {
            for(int i = 100;i<=600;i += 100) {
                bricks.add(new Brick(new Point(i,100+(30*j)),90,20));
            }
        }
    }

    //draw the game interface using draw functions and graphics object
    @Override
    public void paint(Graphics g) {
        //BackGround
        g.setColor(Color.BLACK);
        g.fillRect(0,0,800,600);

        //Border
        g.setColor(Color.YELLOW);
        g.fillRect(0,0,3,600);
        g.fillRect(0,0,800,3);
        g.fillRect(783,0,3,600);

        //slider
        slider.draw(g);

        //ball
        ball.draw(g);

        //bricks
        for (Brick brick : bricks) {
            brick.draw(g);
        }

        if(play) {
            g.drawString("Score = " + score,10,20);
        }
        else if(gameOver) {
            g.drawString("Game Over!!!!!",400,300);
            g.drawString("Score = " + score,400,320);
        }
        else{
            g.drawString("Lets Play Brick Breaker!!!!! Press Any Key to Start",400,300);
            g.drawString("Press Any Key to Start",400,320);
        }
        g.dispose();
    }

    //checks key pressed(if left key pressed slider moves towards the left and if right key pressed slider moves to the right)
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            slider.moveRight();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            slider.moveLeft();
        }
        play = true;
    }

    //needs to be overridden but not used
    @Override
    public void keyTyped(KeyEvent e) {}

    //needs to be overridden but not used
    @Override
    public void keyReleased(KeyEvent e) {}

    //game brain performs all the actions
    //eg : 1)calculating score
    //     2)checking ball and slider touch
    //     3)checking ball and brick touch
    //     4)Game over or not
    @Override
    public void actionPerformed(ActionEvent e) {
        if(play) {
            ball.move();
            if(ball.getRect().intersects(slider.getRect())) {
                //ball has touched the slider
                ball.touchedSlider();
            }
            for(Brick brick : bricks) {
                if(brick.getRect().intersects(ball.getRect())) {
                    //ball has touched a brick
                    brick.setVisible(false);
                    ball.touchedBrick(brick.getRect());
                    score += 5;
                    break;
                }
            }
        }

        //checks if ball has fallen below the slider i.e you lost the game
        //checks if the level is complete i.e hit all the bricks and got a score of 150
        //if any condition is true then GAME OVER
        if(ball.getCentre().y > 600 || score == 150) {
            play = false;
            gameOver = true;
            timer.stop();
        }
        //call back the paint function with updated screen
        //hit bricks destroyed
        repaint();
    }

    //random function
    private int random(int max , int min) {
        return (int)(Math.random() * (max - min + 1) + min);
    }
}
