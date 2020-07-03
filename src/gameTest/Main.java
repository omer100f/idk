package gameTest;

import javafx.stage.Screen;

import javax.swing.*;
import java.awt.*;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
	// lol
        JFrame frame = new JFrame("IDK");
        Gameplay gameplay = new Gameplay();
        frame.add(gameplay);
        //new Rectangle(0 , 0,(int) Screen.getPrimary().getVisualBounds().getWidth(), (int) Screen.getPrimary().getVisualBounds().getHeight())
        frame.setBounds(0,0,1920,1080);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        //DesktopManager

    }
}
