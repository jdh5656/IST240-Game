/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jacobdhayes jdh5656
 */

import Cards.InstructionsCard;
import Cards.IntroCard;
import Cards.DesignersCard;
import Cards.GameCard;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameCardsJPanel extends JPanel
{

    CardLayout cards;
    
    IntroCard intro;
    InstructionsCard instructions;
    DesignersCard designers;
    GameCard game;
    
    String CINTRO = "Intro", CINSTRUCTIONS = "Instructions", CDESIGNERS = "Designers", CGAME = "Game";
    
    public GameCardsJPanel ()
    {
        super ();

        cards = new CardLayout();
        setLayout(cards);
        setPreferredSize(new Dimension(1300,700));
        
        //Create Panels
        intro = new IntroCard();
        instructions = new InstructionsCard();
        designers = new DesignersCard();
        game = new GameCard();
       
        add(intro, CINTRO);
        add(instructions, CINSTRUCTIONS);
        add(designers, CDESIGNERS);  
        add(game, CGAME);
        
    }

}