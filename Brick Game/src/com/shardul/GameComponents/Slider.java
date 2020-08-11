package com.shardul.GameComponents;

import java.awt.*;

//slider class
//has a start point,width,height
public class Slider {
    private final Point srtPt;
    private final int width;
    private final int height;

    public Slider(Point pt,int width,int height) {
        this.srtPt = pt;
        this.width = width;
        this.height = height;
    }

    //draw on the screen
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(srtPt.x,srtPt.y,width,height);
    }

    //moves the slider to the right also checks right bounds
    public void moveRight() {
        if(srtPt.x+100 >= 775) {
            srtPt.x = 683;
        }
        else {
            srtPt.x += 20;
        }
    }

    //moves the slider to the left also checks left bounds
    public void moveLeft() {
        if(srtPt.x <= 0) {
            srtPt.x = 0;
        }
        else {
            srtPt.x -= 20;
        }
    }

    //covers the slider with a rectangle to check intersects
    public Rectangle getRect() {
        return new Rectangle(srtPt.x,srtPt.y,width,height);
    }
}
