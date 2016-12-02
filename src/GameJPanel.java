/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jacobdhayes jdh5656
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GameJPanel extends JPanel implements ActionListener
{
    
    GameNavigationJPanel navigationJPanel;
    GameCardsJPanel gameCards;
    
    public GameJPanel ()
    {
        super ();
        
        // Adding MAC Support
                try 
                {
                    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
                } catch (Exception e) 
                {
                    e.printStackTrace();
                } 
        
        navigationJPanel = new GameNavigationJPanel();
        gameCards = new GameCardsJPanel();
        
        setLayout(new FlowLayout());
        setBackground(Color.gray);
       
        add(gameCards);
        add(navigationJPanel);
        
        navigationJPanel.jbIntro.addActionListener(this);
        navigationJPanel.jbInstructions.addActionListener(this);
        navigationJPanel.jbDesigners.addActionListener(this);
        navigationJPanel.jbGame.addActionListener(this);
        navigationJPanel.jbOptions.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object obj = e.getSource();
        
        if(obj == navigationJPanel.jbIntro) { 
            gameCards.cards.show(gameCards, "Intro"); 
        } else if (obj == navigationJPanel.jbInstructions) {
            gameCards.cards.show(gameCards, "Instructions");            
        } else if (obj == navigationJPanel.jbDesigners) {
            gameCards.cards.show(gameCards, "Designers");
        } else if (obj == navigationJPanel.jbGame){
            gameCards.cards.show(gameCards, "Game");
        } else if (obj == navigationJPanel.jbOptions) {
            gameCards.cards.show(gameCards, "Options");
        }  
    }
    


}