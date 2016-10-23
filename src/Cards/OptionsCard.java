package Cards;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author John
 */
public class OptionsCard extends JPanel
{
JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9;
    public OptionsCard()
    {
        //---------Layout----------------------
        super();
        GridLayout grid = new GridLayout(4,3);
        setLayout(grid);
        setBackground(Color.RED);
        
        //--------Create JLabels---------------
        JLabel label1 = new JLabel ("Game Type");
        JLabel label2 = new JLabel ("Wind");
        JLabel label3 = new JLabel ("Distance");
        
        
        //--------Create JButtons--------------
        jb1 = new JButton ("Practice");
        jb2 = new JButton ("Game Day");
        jb3 = new JButton ("Championship");
        jb4 = new JButton ("Slight");
        jb5 = new JButton ("Moderate");
        jb6 = new JButton ("Heavy");
        jb7 = new JButton ("Close");
        jb8 = new JButton ("Average");
        jb9 = new JButton ("NFL Record");
        
        //---------------Add Labels and JButtons----------
        add(label1);
        add(label2);
        add(label3);
        add(jb1);
        add(jb2);
        add(jb3);
        add(jb4);
        add(jb5);
        add(jb6);
        add(jb7);
        add(jb8);
        add(jb9);

        //--------look and feel------
        label1.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label3.setHorizontalAlignment(JLabel.CENTER);
        
            

    }
}
