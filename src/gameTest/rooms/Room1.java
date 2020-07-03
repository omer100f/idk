package gameTest.rooms;

import gameTest.Door;
import gameTest.Obst;

public class Room1 extends Room{

    public Room1() {
        obsts = new Obst[]{o1, o2, o3, o4, floor};
        super.door = this.door;
    }

    private Obst o1 = new Obst(100, 900, 50,500);
    private Obst o2 = new Obst(200, 800, 50,50);
    private Obst o3 = new Obst(300, 700, 50,50);
    private Obst o4 = new Obst(400, 550, 50,50);
    private Obst floor = new Obst(0,980,90,1920);

    private Door door = new Door(1050,880,100,50);














}
