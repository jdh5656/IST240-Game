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
import Game.XML_240;
import java.awt.*;
import javax.swing.*;

public class GameLeaderboard extends JPanel {
    XML_240 xmlLeader;
    GameCard gcard;
    int highScore = 0;
    public GameLeaderboard (GameCard g, XML_240 xL)
    {
        super();
        gcard = g;
        xmlLeader = xL;
        //xmlLeader.openReaderXML("test");
        //highScore = (int)xmlLeader.ReadObject();
        //System.out.println(highScore);
    }
}
