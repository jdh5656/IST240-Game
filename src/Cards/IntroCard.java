package Cards;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author nickonofrio
 */
public class IntroCard extends JPanel {

    public IntroCard()
    {
        super();
        
        GridLayout grid = new GridLayout(6,1);
        setLayout(grid);
        setBackground(Color.orange);
        
        //Create JLabels
        JLabel l1 = new JLabel("Welcome to our Game");
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        //Create JButtons
        JButton b1 = new JButton("Start");
        b1.setHorizontalAlignment(JButton.CENTER);
        
        //Add Components
        add(l1);
        add(b1);
    }

    
}