package gameTest;

import gameTest.rooms.Room;

import java.awt.*;

public class Player extends Being{

    final int startPosY = 400;
    final int startPosX = 100;
    final public int ADD = -20;
    public int g = ADD;
    public boolean isJumping, right, isFalling;
    Rectangle idk = new Rectangle(100,900,50,30);


    public Player() {

        this.x = 100;
        this.y = 500;
        this.width = 50;
        this.height = 30;

    }

    public void play(Room room){
        if (y > 1080){
            y = 1800;
        }
        if(!touches(room.getObsts()) && !isJumping && !isFalling){
            g = 9;
            isFalling = true;
        }
        if(isJumping){
            jump();
            if(g == 0 || touchesUnder(room.getObsts())){
                isJumping = false;
                isFalling = true;
                g = 0;
            }
            //ground.intersects(player) ||
            if (touches(room.getObsts())) {
                isJumping = false;
                isFalling = true;
                g = ADD;
            }

        }
        if(isFalling){
            fall();
            if(touches(room.getObsts()) || touchesUnder(room.getObsts()) || inter(room.getObsts())){
                isFalling = false;
                g = ADD;
            }
        }
        if(right && !touchesSide(room.obsts)) {
            x+=10;
        }

    }
    public boolean touches(Obst[] obsts){
        for(Obst obst : obsts) {
            /*if (((ground.y <= idk.y + idk.height))) {
                idk.y = ground.y - idk.height;
                return true;
*/
              if (((obst.y <= this.y + this.height) && (obst.y >this.y) && ((this.x + this.width > obst.x)) && (this.x < obst.x + obst.width))) {
                this.y = obst.y - this.height;
                return true;
            }
        }
        return false;
    }
    public boolean touchesSide(Obst[] obsts) {
        for (Obst obst : obsts) {
            if ((obst.y < this.y + this.height) && (obst.y + obst.height > this.y) && (this.x + this.width == obst.x)){
                this.x = obst.x - this.width - 10;
                return  true;
            }
        }
        return false;
    }
    public boolean touchesUnder (Obst[] obsts) {
        for(Obst obst : obsts) {
            if (this.y > obst.y && this.y < obst.y + obst.height && (this.x + this.width > obst.x) && (this.x < obst.x + obst.width)) {
                this.y = obst.y + obst.height;
                return true;
            }
        }
        return false;
    }
    public boolean touches(Door door) {
        if (((door.y <= this.y + this.height) && (door.y > this.y) && ((this.x + this.width > door.x)) && (this.x < door.x + door.width))) {
            this.y = door.y - this.height;
            return true;
        }

        return false;
    }
    public boolean touchesSide(Door door) {

            if ((door.y < this.y + this.height) && (door.y + door.height > this.y) && (this.x + this.width == door.x)){
                this.x = door.x - this.width - 10;
                return  true;
            }

        return false;
    }
    public boolean touchesUnder (Door door) {
            if (this.y > door.y && this.y < door.y + door.height && (this.x + this.width > door.x) && (this.x < door.x + door.width)) {
                this.y = door.y + door.height;
                return true;
            }
        return false;
    }

    public boolean inter (Obst[] obsts) {
        for(Obst obst : obsts) {
            if (this.y + this.height > obst.y && this.y + this.height < obst.y + obst.height && (this.x + this.width > obst.x) && (this.x < obst.x + obst.width)) {
                this.y = obst.y + obst.height;
                return true;
            }
        }
        return false;
    }
    public void jump(){
        g += 1;
        y += g;
    }
    public void fall(){
        g += 1;
        y += g;
    }
}
