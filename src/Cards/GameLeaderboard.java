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
    Player thePlayer;
    public GameLeaderboard ( XML_240 xL)
    {
        super();
        xmlLeader = xL;
        thePlayer = new Player("", 0);
    }
    public void updateBoard() 
    {
        xmlLeader.openReaderXML("test.xml");
        thePlayer = (Player)xmlLeader.ReadObject();
        xmlLeader.closeReaderXML();
        System.out.println(thePlayer.name + " " +thePlayer.pScore);
    }
}
