package gameTest;

import gameTest.rooms.Room;
import gameTest.rooms.Room1;
import gameTest.rooms.Room2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Gameplay extends JPanel implements ActionListener, KeyListener {


    Timer timer;
    private Room[] rooms;
    private Room currentRoom;
    private Room1 room1 = new Room1();
    private Room2 room2 = new Room2();
    private boolean play = false;
    private int roomNumber = 0;

    public Player player = new Player();
    private String msg = "LOL? player..";
    Rectangle obst1 = new Rectangle(200,(800-50),100,50);
    //Rectangle obst2 = new Rectangle(400,(850-50),100,50);
    Rectangle obst3 = new Rectangle(500,(700-50),100,50);
    //Rectangle obst4 = new Rectangle(650,(700-50),100,50);
    Rectangle obst5 = new Rectangle(800,(550-50),100,50);
    //Rectangle obst6 = new Rectangle(850,(500-50),100,50);
    Rectangle door = new Rectangle(1100,(900-50),50,100);
    private Rectangle[] obsts = new Rectangle[]{obst1, obst3, obst5,};
    //Rectangle obs = new Rectangle(200,929-45,100,50);


    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        rooms = new Room[]{room1, room2};
        timer = new Timer(12,this);
        timer.start();
    }

    public void paint(Graphics g){
        //back
        g.setColor(Color. BLACK);
        g.fillRect(0,0,1920,1080);
        g.setColor(Color.CYAN);

        //player
        g.setColor(Color.CYAN);
        g.fillRect((int) player.getX(),(int) player.getY(),(int) player.getWidth(),(int) player.getHeight());


        //txt
        g.setColor(Color.WHITE);
        g.setFont(new Font("",Font.PLAIN,70));
        g.drawString(msg, 100, 100);
/*        g.drawString(player.y + " " + player.height, 500, 100);
        g.drawString(ground.y + " " + ground.height, 500, 400);
        g.drawString(String.valueOf(touches())+ " " + String.valueOf(touchesSide()) + " " + touchesUnder(), 550, 550);*/

        //obstacles
        rooms[roomNumber].paint(g);
        g.setColor(Color.CYAN);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        currentRoom = rooms[roomNumber];
            if(play){
                /*System.out.print(player.y-player.height);
                System.out.println(" ground"+ground.y);*/

                player.play(currentRoom);


                if (player.touches(currentRoom.door) || player.touchesUnder(currentRoom.door) || player.touchesSide(currentRoom.door)){
                    endRoom();
                }

            }
            repaint();
    }

    private void endRoom(){
        if (roomNumber < rooms.length - 1){
            roomNumber++;
            currentRoom = rooms[roomNumber];
            player.x = player.startPosX;
            player.y = player.startPosY;
        }

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){

            play=true;
            player.right = true;
        }if(e.getKeyCode()==KeyEvent.VK_UP){
            play = true;
            if(!player.isFalling)
                player.isJumping = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
            play = true;
            player.right = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_R){
            player.x = player.startPosX;
            player.y = player.startPosY;
            msg = "LOL? player..";
        }
    }


}