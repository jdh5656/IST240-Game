import java.awt.*;
import javax.swing.*;

/**
 *
 * @author nickonofrio
 */
public class InstructionsCard extends JPanel {

    public InstructionsCard()
    {
        super();
    
        GridLayout grid = new GridLayout(6,1);
        setLayout(grid);
        setBackground(Color.yellow);
        
        //Create JLabels
        JLabel l1 = new JLabel("Instructions");
        l1.setHorizontalAlignment(JLabel.CENTER);        
        
        //Add Components
        add(l1);
    }

    
}