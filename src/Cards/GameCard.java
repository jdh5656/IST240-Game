package Cards;

import Game.GameController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import Cards.OptionsCard;

/**
 *
 * @author nickonofrio
 */
public class GameCard extends JPanel implements ActionListener, javax.swing.event.ChangeListener {    
    
    GameController controller;
    
    JTextArea pMessage = new JTextArea("Power will be displayed here");
    JTextArea aMessage = new JTextArea("Accuracy will be displayed here");
    JTextArea wMessage = new JTextArea("Wind direction will be displayed here");
    JSlider accuracy, power;
    JButton b1, b2, b3, b4, b5, b6;
    JLabel l1, l2;
    Timer tAccuracy;
    Timer tPower;
    Timer tWind;
    int limit = 0;  
    int aDelay = 0;
    int dDelay = 0;
    int wDelay = 0;
    int i = 0;
    int j = 0;
    int a = 1, vA = 1;
    int p = 1, vP = 1;
    double wRandom = Math.random() * 4;
    double wx = 1;
    double wy = 1;
    int kickPoint[];
    int winLose;

    public GameCard(GameController ctrl)
    {
        super();
        
        controller = ctrl;
        
        setLayout(null);
        setBackground(Color.gray);
        
        //------SLIDER TIMER -------------------------------------------
  	aDelay = 10; //milliseconds
        dDelay = 10; //milliseconds
        tAccuracy = new Timer(aDelay, this);
        tPower = new Timer(dDelay, this);
        
        //-------WIND TIMER---------------------------------------------
        wDelay = 10*1000;
        tWind = new Timer(wDelay, this);
        
        //Create JButtons
        b1 = new JButton("Start Accuracy");
        b1.addActionListener(this);
        b1.setHorizontalAlignment(JButton.CENTER);
        
        b2 = new JButton("Stop Accuracy");
        b2.addActionListener(this);
        b2.setHorizontalAlignment(JButton.CENTER);
        
        b3 = new JButton("Start Power");
        b3.addActionListener(this);
        b3.setHorizontalAlignment(JButton.CENTER);
        
        b4 = new JButton("Stop Power");
        b4.addActionListener(this);
        b4.setHorizontalAlignment(JButton.CENTER);
        
        b6 = new JButton("Test Selection");
        b6.addActionListener(this);
        b6.setHorizontalAlignment(JButton.CENTER);
        
        
        //Create Sliders
        accuracy = new JSlider(JSlider.HORIZONTAL,0,100,0);
        accuracy.setMajorTickSpacing(25);
        accuracy.setBorder(BorderFactory.createTitledBorder("Accuracy"));
        accuracy.setPaintTicks(true);
        
        power = new JSlider(JSlider.VERTICAL,0,100,0);
        power.setMajorTickSpacing(25);
        power.setBorder(BorderFactory.createTitledBorder("power"));
        power.setPaintTicks(true);
        
        //Create Graphics
        ImageIcon gBackground = new ImageIcon ("images/gameMain.png");
        l2 = new JLabel(gBackground);
       
        
        
        //Add Components
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b6);
        add(accuracy);
        add(power);
        add(pMessage);
        add(aMessage);
        add(wMessage);
        add(controller.optionsDifficulty);
        add(controller.optionsWind);
        add(controller.optionsDistance);
        add(l2);
    
        
        //------------Placing------------------------------------
        // x,y, length, height)
        accuracy.setBounds(new Rectangle(500,600,300,100));
        power.setBounds(new Rectangle(800,400,100,300));
        b1.setBounds(new Rectangle(100,10,100,100));
        b2.setBounds(new Rectangle(100,120,100,100));
        b3.setBounds(new Rectangle(600,10,100,100));
        b4.setBounds(new Rectangle(600,120,100,100));
        b6.setBounds(1000, 600, 200, 100);
        pMessage.setBounds(new Rectangle(600,230,200,20));
        aMessage.setBounds(new Rectangle(100,230,200,20));
        wMessage.setBounds(new Rectangle(1000,230,200,20));
        l2.setBounds(0, 0, 1300, 800);
        controller.optionsDifficulty.setBounds(new Rectangle(0,580,200,20));
        controller.optionsWind.setBounds(new Rectangle(0,620,200,20));
        controller.optionsDistance.setBounds(new Rectangle(0,660,200,20));
 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String choice = e.getActionCommand();        
	    if (obj == b1){
                tAccuracy.start();
                tWind.start();
            }
            
            if (obj == b2){
                tAccuracy.stop();
                aMessage.setText("Accuracy is: " + a);
            }
            
            if (obj == b3){tPower.start();}
            
            if (obj == b4){
                tPower.stop();
                pMessage.setText("Power is: " + p);
            }
            
            if (obj == tAccuracy)
		{
		i = i+1;
                if (a < 0 || a > 100)
                {
                    vA = -vA;
                }
                a += vA;
                accuracy.setValue(a);
                }
            
            if (obj == tPower)
            {
                j = j+1;
                if (p < 0 || p > 100)
                {
                    vP = -vP;
                }
                p += vP;
                power.setValue(p);
            }
            if (obj == b6)
            {
                kickPoint = controller.evaluateKick(p, a, wx, wy);
                winLose = controller.evaluateGoal(kickPoint);
                if(winLose == 0)
                System.out.println(kickPoint[0]+","+kickPoint[1]+" "+winLose);
                {
                    
                }
            }
            //------Random wind direction for send into controller----------
            if (obj == tWind)
            {
                wRandom = Math.random()*4;
                if (wRandom <= 1) //East
                {
                    wx = 1;
                    wy = 0;
                    wMessage.setText("East");
                }
                else if (wRandom <= 2) //South
                {
                    wx = 0;
                    wy = -1;
                    wMessage.setText("South");
                }
                else if (wRandom <= 3) //West
                {
                    wx = -1;
                    wy = 0;
                    wMessage.setText("West");
                }
                else //North
                {
                    wx = 0;
                    wy = 1;
                    wMessage.setText("North");
                }         
            }
            
            repaint();
        
    
    
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}