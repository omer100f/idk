package gameTest.rooms;

import gameTest.Door;
import gameTest.Obst;

import java.awt.*;

public class Room {

    public Obst[] obsts;
    public Door door;

    public void paint(Graphics g){

        //obstacles
        for(Obst obst : obsts){
            g.setColor(Color.WHITE);
            g.fillRect((int) obst.getX(),(int) obst.getY(),(int) obst.getWidth(),(int) obst.getHeight());
        }
        g.setColor(new Color(50,255,0));
        g.fillRect(door.getX(),door.getY(),door.getWidth(),door.getHeight());
        g.dispose();
    }
    public Obst[] getObsts() {
        return obsts;
    }









}
