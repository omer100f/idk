package gameTest;

import java.awt.*;

public class Obst extends Being{

    public Rectangle rect;

    public Obst(int x, int y, int height, int width) {
        super(x, y, height, width);
    }

    public Obst(Rectangle rect) {
        this.rect = rect;
    }

    public Obst() {
    }
}
