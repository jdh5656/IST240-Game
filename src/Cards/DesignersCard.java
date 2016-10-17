package Cards;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author nickonofrio
 */
public class DesignersCard extends JPanel {

    public DesignersCard()
    {
        super();
    
        GridLayout grid = new GridLayout(6,1);
        setLayout(grid);
        setBackground(Color.blue);
        
        //Create JLabels
        ImageIcon john = new ImageIcon("images/JohnCatanzaro.png");
        JLabel l1 = new JLabel("John", john, JLabel.CENTER);
        
        ImageIcon jacob = new ImageIcon("images/JacobHayes.png");
        JLabel l2 = new JLabel("Jacob", jacob, JLabel.CENTER);
        
        ImageIcon karin = new ImageIcon("images/KarinMartin.jpg");
        JLabel l3 = new JLabel("Karin", karin, JLabel.CENTER);
        
        ImageIcon nick = new ImageIcon("images/NickOnofrio.jpg");
        JLabel l4 = new JLabel("Nick", nick,JLabel.CENTER);
        
        //Add Components
        add(l1);
        add(l2);
        add(l3);
        add(l4);

    }

    
}