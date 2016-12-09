package Cards;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author nickonofrio
 */
public class IntroCard extends JPanel implements ActionListener, javax.swing.event.ChangeListener{

    public JButton b1;
    
    
    public IntroCard()
    {
        super();
        
        //GridLayout grid = new GridLayout(6,1);
        setLayout(null);
        setBackground(Color.WHITE);
                
        //Create JLabels
        ImageIcon introGraphic = new ImageIcon("images/intro.png");
        JLabel l1 = new JLabel(introGraphic);
        l1.setBounds(0, 0, 1300, 800);
        
        //Create JButtons
        b1 = new JButton("Start");
        b1.setBounds(500, 150, 300, 50);
        b1.setHorizontalAlignment(JButton.CENTER);
        
        //Add Components
        add(b1);
        add(l1);
        
        // Add leaderboard
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
            if (obj == b1){ 
            //Need to add code to swap to game    
            
            }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}