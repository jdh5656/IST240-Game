/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jacobdhayes jdh5656
 */
import Game.XML_240;
import Cards.InstructionsCard;
import Cards.IntroCard;
import Cards.DesignersCard;
import Cards.GameCard;
import Cards.OptionsCard;
import Cards.GameLeaderboard;
import Game.GameController;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameCardsJPanel extends JPanel
{
    XML_240 x2;
    CardLayout cards;
    IntroCard intro;
    InstructionsCard instructions;
    DesignersCard designers;
    GameCard game;
    OptionsCard options;
    GameLeaderboard leaderboard;
    
    String CINTRO = "Intro", CINSTRUCTIONS = "Instructions", CDESIGNERS = "Designers", CGAME = "Game", COPTIONS = "Options", CLEADERBOARD = "Leaderboard";
    
    public GameCardsJPanel ()
    {
        super ();

        cards = new CardLayout();
        setLayout(cards);
        setPreferredSize(new Dimension(1300,700));
        x2 = new XML_240();
        
        //Create Controller
        GameController controller = new GameController();
        
        //Create Panels
        options = new OptionsCard(controller);
        leaderboard = new GameLeaderboard(x2);
        game = new GameCard(controller, options, x2, leaderboard);
        designers = new DesignersCard();
        intro = new IntroCard(game);
        instructions = new InstructionsCard();
        
       
        add(intro, CINTRO);
        add(instructions, CINSTRUCTIONS);
        add(designers, CDESIGNERS);  
        add(game, CGAME);
        add(options, COPTIONS);
        add(leaderboard, CLEADERBOARD);
    }

}