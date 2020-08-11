package com.shardul.GameComponents;

import java.awt.*;

//brick class
//has a start point(upper left point),width,height
//visible property is true at first.Becomes false when the ball hits the brick
public class Brick {
    private final Point srtPt;
    private final int width;
    private final int height;
    private boolean visible = true;

    public Brick(Point srtPt, int width, int height) {
        this.srtPt = srtPt;
        this.width = width;
        this.height = height;
    }

    //Draw the brick
    public void draw(Graphics g) {
        if(visible) {
            g.setColor(Color.WHITE);
            g.fillRect(srtPt.x,srtPt.y,width,height);
        }
    }

    //covers the brick with the rectangle if the brick is not hit yet
    public Rectangle getRect() {
        if(visible) {
            return new Rectangle(srtPt.x,srtPt.y,width,height);
        }
        return new Rectangle(0,0,0,0);
    }

    //setter for the visible property
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
