package Cards;/*

import java.awt.*;
import javax.swing.*;
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jacobdhayes
 */
import Game.Player;
import Game.XML_240;
import java.awt.*;
import javax.swing.*;

public class GameLeaderboard extends JPanel {
    XML_240 xmlLeader;
    int highScore = 0;
    Player[] thePlayer;
    JButton jb2;
    public GameLeaderboard ( XML_240 xL)
    {
        super();
        GridLayout grid = new GridLayout(5,1);
        setLayout(grid);
        xmlLeader = xL;
        jb2 = new JButton ("Reset stats");
        JButton jb1 = new JButton("Leaderboard");
        jb1.setBackground(Color.white);
        thePlayer = new Player[3];
        xmlLeader.openReaderXML("test.xml");
        thePlayer[0] = (Player)xmlLeader.ReadObject();
        thePlayer[1] = (Player)xmlLeader.ReadObject();
        thePlayer[2] = (Player)xmlLeader.ReadObject();
        xmlLeader.closeReaderXML();
        
        //-------SET BUTTONS
        thePlayer[0].setBounds(350, 300, 200, 50);
        thePlayer[1].setBounds(350, 200, 200, 50);
        thePlayer[2].setBounds(350, 200, 200, 50);
        //-------ADD BUTTONS
        add(jb1);
        add(thePlayer[0]);
        add(thePlayer[1]);
        add(thePlayer[2]);
        add(jb2);
        
        //-------Message and Look/feel
        thePlayer[0].setText(thePlayer[0].name+"'s"+" high score is: "+thePlayer[0].pScore);
        thePlayer[1].setText(thePlayer[1].name+"'s"+" high score is: "+thePlayer[1].pScore);
        thePlayer[2].setText(thePlayer[2].name+"'s"+" high score is: "+thePlayer[2].pScore);
    }
    public void updateBoard() 
    {
        xmlLeader.openReaderXML("test.xml");
        thePlayer[0] = (Player)xmlLeader.ReadObject();
        thePlayer[1] = (Player)xmlLeader.ReadObject();
        thePlayer[2] = (Player)xmlLeader.ReadObject();
        xmlLeader.closeReaderXML();
    }
    public void clearBoard ()
    {
        thePlayer[0].name = "Player 1"; thePlayer[0].pScore = 0;
        thePlayer[1].name = "Player 1"; thePlayer[1].pScore = 0;
        thePlayer[2].name = "Player 1"; thePlayer[2].pScore = 0;
        xmlLeader.openWriterXML("test.xml");
        xmlLeader.writeObject(thePlayer[0]);
        xmlLeader.writeObject(thePlayer[1]);
        xmlLeader.writeObject(thePlayer[2]);
        xmlLeader.closeWriterXML();
        xmlLeader.openReaderXML("test.xml");
        thePlayer[0] = (Player)xmlLeader.ReadObject();
        thePlayer[1] = (Player)xmlLeader.ReadObject();
        thePlayer[2] = (Player)xmlLeader.ReadObject();
        xmlLeader.closeReaderXML();
        repaint();
    }
}
