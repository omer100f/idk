package gameTest;

import java.awt.*;

public class Being {
    public int x;
    public int y;
    public int height;
    public int width;
    public  Color color;

    public Being() {        
    }

    public Being(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = new Color(255,255,255);
    }
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Being(int x, int y, int height, int width, Color color) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = new Color(255,255,255);;;;;;;;;;;;;;;;   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
