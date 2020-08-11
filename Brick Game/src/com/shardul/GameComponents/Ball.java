package com.shardul.GameComponents;

import java.awt.*;

//Ball class
//has a radius and a centre
//xInc and yInc moves the ball around the screen
public class Ball {
    private final int radius;
    private final Point centre;
    private int xInc = -1;
    private int yInc = 2;

    public Ball(Point centre,int radius) {
        this.centre = centre;
        this.radius = radius;
    }

    //draw the ball
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillOval(centre.x,centre.y,radius,radius);
    }

    //moving the ball around the screen and checking bounds
    public void move() {
        centre.x += xInc;
        centre.y += yInc;
        if (centre.x < 0 || centre.x > 765) {
            xInc = -xInc;
        }
        if (centre.y < 0) {
            yInc = -yInc;
        }
    }

    //the ball has touched a brick
    public void touchedBrick(Rectangle rect) {
        if(centre.x + 19 <= rect.x && centre.x + 1 >= rect.x + rect.width) {
            //the ball the touched the left and right sides of the brick
            xInc = -xInc;
        }
        else {
            //the ball the touched the top and bottom sides of the brick
            yInc = -yInc;
        }
    }

    //touched the slider the ball should go up
    public void touchedSlider() {
        yInc = -yInc;
    }

    //returns a rectangle around the ball
    public Rectangle getRect() {
        return new Rectangle(centre.x,centre.y,radius,radius);
    }

    //returns the centre
    public Point getCentre() {
        return centre;
    }
}
