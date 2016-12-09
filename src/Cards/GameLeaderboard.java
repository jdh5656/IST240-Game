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
    public GameLeaderboard ( XML_240 xL)
    {
        super();
        xmlLeader = xL;
        thePlayer = new Player[3];
        xmlLeader.openReaderXML("test.xml");
        thePlayer[0] = (Player)xmlLeader.ReadObject();
        thePlayer[1] = (Player)xmlLeader.ReadObject();
        thePlayer[2] = (Player)xmlLeader.ReadObject();
        xmlLeader.closeReaderXML();
        
        //-------SET BUTTONS
        thePlayer[0].setBounds(350, 150, 200, 50);
        thePlayer[1].setBounds(350, 150, 200, 50);
        thePlayer[2].setBounds(350, 150, 200, 50);
        //-------ADD BUTTONS
        add(thePlayer[0]);
        add(thePlayer[1]);
        add(thePlayer[2]);
    }
    public void updateBoard() 
    {
        xmlLeader.openReaderXML("test.xml");
        thePlayer[0] = (Player)xmlLeader.ReadObject();
        thePlayer[1] = (Player)xmlLeader.ReadObject();
        thePlayer[2] = (Player)xmlLeader.ReadObject();
        xmlLeader.closeReaderXML();
        System.out.println(thePlayer[0].name + " " +thePlayer[0].pScore);
        System.out.println(thePlayer[1].name + " " +thePlayer[1].pScore);
        System.out.println(thePlayer[2].name + " " +thePlayer[2].pScore);
    }
}
