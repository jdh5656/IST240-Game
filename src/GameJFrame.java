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

public class GameJFrame extends JFrame
{

    GameJPanel gameJPanel;
    GameNavigationJPanel navigationJPanel;
    
    public GameJFrame()
    {
        super ("Game");
        
        // Create components: JPanel
        gameJPanel = new GameJPanel();
        
        getContentPane().setLayout(new GridLayout(1,1));
        getContentPane().add(gameJPanel,"Center");
       
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize (1300, 800);
        setVisible(true);    
        
    }
}
