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
import Cards.OptionsCard;
import Game.GameController;
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
    OptionsCard options;
    
    String CINTRO = "Intro", CINSTRUCTIONS = "Instructions", CDESIGNERS = "Designers", CGAME = "Game", COPTIONS = "Options";
    
    public GameCardsJPanel ()
    {
        super ();

        cards = new CardLayout();
        setLayout(cards);
        setPreferredSize(new Dimension(1300,700));
        
        //Create Controller
        GameController controller = new GameController();
        
        //Create Panels
        options = new OptionsCard(controller);
        intro = new IntroCard();
        instructions = new InstructionsCard();
        game = new GameCard(controller, options);
        designers = new DesignersCard();
       
        add(intro, CINTRO);
        add(instructions, CINSTRUCTIONS);
        add(designers, CDESIGNERS);  
        add(game, CGAME);
        add(options, COPTIONS);
    }

}