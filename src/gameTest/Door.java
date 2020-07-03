package gameTest;

import java.awt.*;

public class Door extends Obst{


    public Door() {
        color = new Color(50,255,0);
    }

    public Door(int x, int y, int height, int width) {
        super(x, y, height, width);
        color = new Color(50,255,0);
    }
}
