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

    public JButton b1, b2, b3, b4;
    JLabel l2;
    public GameCard gameIntro;
    
    public IntroCard(GameCard gi)
    {
        super();
        gameIntro = gi;
        
        //GridLayout grid = new GridLayout(6,1);
        setLayout(null);
        setBackground(Color.WHITE);
                
        //Create JLabels
        ImageIcon introGraphic = new ImageIcon("images/intro.png");
        JLabel l1 = new JLabel(introGraphic);
        l1.setBounds(0, 0, 1300, 800);
        l2 = new JLabel("SELECT PLAYER");
        l2.setBounds(600, 100, 200, 50);
        
        //Create JButtons
        b1 = new JButton("Start");
        b1.setBounds(500, 150, 300, 50);
        b1.setHorizontalAlignment(JButton.CENTER);
        
        //--------choose player buttons---------------
        gameIntro.play[0].setBounds(350, 150, 200, 50);
        gameIntro.play[1].setBounds(550, 150, 200, 50);
        gameIntro.play[2].setBounds(750, 150, 200, 50);
        gameIntro.play[0].setText("Player 1");
        gameIntro.play[1].setText("Player 2");
        gameIntro.play[2].setText("Player 3");
        gameIntro.play[0].addActionListener(this);
        gameIntro.play[1].addActionListener(this);
        gameIntro.play[2].addActionListener(this);
        
        
        //Add Components
        add(gameIntro.play[0]);
        add(gameIntro.play[1]);
        add(gameIntro.play[2]);
        add(b1);
        add(l2);
        add(l1);
        
        
        // Add leaderboard
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
            if (obj == b1){ 
            //Need to add code to swap to game    
            
            }
            if (obj == gameIntro.play[0])
            {
                gameIntro.pnum = 0;
                gameIntro.play[0].setVisible(false);
                gameIntro.play[1].setVisible(false);
                gameIntro.play[2].setVisible(false);
                l2.setVisible(false);
                b1.setVisible(true);
            }
            if (obj == gameIntro.play[1])
            {
                gameIntro.pnum = 1;
                gameIntro.play[0].setVisible(false);
                gameIntro.play[1].setVisible(false);
                gameIntro.play[2].setVisible(false);
                l2.setVisible(false);
                b1.setVisible(true);
            }
            if (obj == gameIntro.play[2])
            {
                gameIntro.pnum = 2;
                gameIntro.play[0].setVisible(false);
                gameIntro.play[1].setVisible(false);
                gameIntro.play[2].setVisible(false);
                l2.setVisible(false);
                b1.setVisible(true);
            }
            repaint();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}