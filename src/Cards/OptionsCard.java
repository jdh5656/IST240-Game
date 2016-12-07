package Cards;
import Game.GameController;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.event.ActionListener;

/**
 *
 * @author John
 */
public class OptionsCard extends JPanel implements ActionListener
{
    JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9;
    GameController controller;
    int dimX = 530, dimY = 300;

    
    public OptionsCard(GameController ctrl)
    {
        super();
        
        controller = ctrl;
        
        //---------Layout----------------------
        
        GridLayout grid = new GridLayout(3,4);
        setLayout(grid);
        setBackground(Color.RED);
        
        //--------Create JLabels---------------
        JLabel label1 = new JLabel ("Game Type");
        JLabel label2 = new JLabel ("Wind");
        JLabel label3 = new JLabel ("Distance");
        
        //--------Create JButtons--------------
        jb1 = new JButton ("Practice");
        jb1.setBackground(Color.BLUE);
        jb2 = new JButton ("Game Day");
        jb2.setBackground(Color.GRAY);
        jb3 = new JButton ("Championship");
        jb3.setBackground(Color.GRAY);
        jb4 = new JButton ("Slight");
        jb4.setBackground(Color.BLUE);
        jb5 = new JButton ("Moderate");
        jb5.setBackground(Color.GRAY);
        jb6 = new JButton ("Heavy");
        jb6.setBackground(Color.GRAY);
        jb7 = new JButton ("Close");
        jb7.setBackground(Color.BLUE);
        jb8 = new JButton ("Average");
        jb8.setBackground(Color.GRAY);
        jb9 = new JButton ("NFL Record");
        jb9.setBackground(Color.GRAY);
        
        //---------------Add Labels and JButtons----------
        add(label1);
        add(jb1);
        add(jb2);
        add(jb3);
        add(label2);
        add(jb4);
        add(jb5);
        add(jb6);
        add(label3);
        add(jb7);
        add(jb8);
        add(jb9);

        //--------look and feel------
        label1.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label3.setHorizontalAlignment(JLabel.CENTER);
        
        
        //------------First three are easy, medium hard affecting speed of slider-------
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        //-----------Second three are weather settings affecting the x, y selections------
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        //----------Third three are distance, i.e. more power needed----------
        jb7.addActionListener(this);
        jb8.addActionListener(this);
        jb9.addActionListener(this);      

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Object obj = e.getSource();
        
        //--------Difficulty--------------
        
        if(obj == jb1){
            controller.options.difficulty = "Practice";
            jb1.setBackground(Color.BLUE);
            jb2.setBackground(Color.GRAY);
            jb3.setBackground(Color.GRAY);
        }
        
        if(obj == jb2){
            controller.options.difficulty = "Game Day";
            jb1.setBackground(Color.GRAY);
            jb2.setBackground(Color.BLUE);
            jb3.setBackground(Color.GRAY);
        }
        
        if(obj == jb3){
            controller.options.difficulty = "Championship";
            jb1.setBackground(Color.GRAY);
            jb2.setBackground(Color.GRAY);
            jb3.setBackground(Color.BLUE);
        }
        
        //--------Wind--------------
        
        if(obj == jb4){
            controller.options.wind = "Slight";
            jb4.setBackground(Color.BLUE);
            jb5.setBackground(Color.GRAY);
            jb6.setBackground(Color.GRAY);
        }
        
        if(obj == jb5){
            controller.options.wind = "Moderate";
            jb4.setBackground(Color.GRAY);
            jb5.setBackground(Color.BLUE);
            jb6.setBackground(Color.GRAY);
        }
        
        if(obj == jb6){
            controller.options.wind = "Heavy";
            jb4.setBackground(Color.GRAY);
            jb5.setBackground(Color.GRAY);
            jb6.setBackground(Color.BLUE);
        }
        
        //--------Distance--------------
        
        if(obj == jb7){
            controller.options.distance = "Close";
            jb7.setBackground(Color.BLUE);
            jb8.setBackground(Color.GRAY);
            jb9.setBackground(Color.GRAY);
            dimX = 530;
            dimY = 300;
            controller.winXMax = controller.kickX - ((controller.kickX - dimX)/2);
            controller.winYMax = controller.kickY - ((controller.kickY - dimY)/2);
            controller.winXMin = (controller.kickX - dimX)/2;
            controller.winYMin = controller.kickY - controller.winYMax - dimY;
        }
        
        if(obj == jb8){
            controller.options.distance = "Average";
            jb7.setBackground(Color.GRAY);
            jb8.setBackground(Color.BLUE);
            jb9.setBackground(Color.GRAY);
//            controller.winXMax = 350;
//            controller.winYMax = 225;
//            controller.winXMin = 0;
//            controller.winYMin = 0;
        }
        
        if(obj == jb9){
            jb7.setBackground(Color.GRAY);
            jb8.setBackground(Color.GRAY);
            jb9.setBackground(Color.BLUE);
//            controller.options.distance = "NFL Record";
//            controller.winXMax = 300;
//            controller.winYMax = 200;
//            controller.winXMin = 0;
//            controller.winYMin = 0;
        }
        
        controller.optionsDifficulty.setText("Game Type: "+controller.options.difficulty);
        controller.optionsWind.setText("Wind: "+controller.options.wind);
        controller.optionsDistance.setText("Distance: "+controller.options.distance);
        
        repaint();
        
    }
}
