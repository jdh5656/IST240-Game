import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author nickonofrio
 */
public class GameNavigationJPanel extends JPanel
{
    
    JButton jbIntro, jbInstructions, jbDesigners, jbGame, jbOptions, jbLeaderboard;
    
    public GameNavigationJPanel()
    {
        super();
    
        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(1300,100));
        
        //Create JButtons
        jbIntro = new JButton("Introduction");
        jbInstructions = new JButton("Instructions");
        jbDesigners = new JButton("Designers");
        jbGame = new JButton("Game");
        jbOptions = new JButton("Options");
        jbLeaderboard = new JButton("Leaderboard");
        
        
        //Add Components
        add(jbIntro);
        add(jbInstructions);
        add(jbOptions);
        add(jbGame);
        add(jbLeaderboard);
        add(jbDesigners);
    }
    
}