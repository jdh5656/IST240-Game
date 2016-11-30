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
    JTextArea rMessage = new JTextArea("Outcome of kick will be shown here");
    JSlider accuracy, power;
    JButton b1, b2, b5, b6;
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
    int keyCounter = 0;

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
        tWind.start();
        
        //Create JButtons
        b1 = new JButton("Start Game");
        b1.addActionListener(this);
        b1.setHorizontalAlignment(JButton.CENTER);
        
        b2 = new JButton("Stop Slider");
        b2.addActionListener(this);
        b2.setHorizontalAlignment(JButton.CENTER);
        
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
        add(b6);
        add(accuracy);
        add(power);
        add(pMessage);
        add(aMessage);
        add(wMessage);
        add(rMessage);
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
        b6.setBounds(1000, 600, 200, 100);
        pMessage.setBounds(new Rectangle(100,260,200,20));
        aMessage.setBounds(new Rectangle(100,230,200,20));
        wMessage.setBounds(new Rectangle(1000,230,200,20));
        rMessage.setBounds(new Rectangle(1000,500,200,20));
        l2.setBounds(0, 0, 1300, 800);
        controller.optionsDifficulty.setBounds(new Rectangle(10,580,200,20));
        controller.optionsWind.setBounds(new Rectangle(10,620,200,20));
        controller.optionsDistance.setBounds(new Rectangle(10,660,200,20));
 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String choice = e.getActionCommand();        
	    if (obj == b1){
                tAccuracy.start();
            }
            
            if (obj == b2){
                if (keyCounter == 0)
                {
                    tAccuracy.stop();
                    aMessage.setText("Accuracy is: " + a);
                    keyCounter++;
                    tPower.start();
                }
                else {
                    
                    tPower.stop();
                    pMessage.setText("Power is: " + p);
                    
                    //----------CALCULATES IF WIN ------------
                    kickPoint = controller.evaluateKick(p, a, wx, wy);
                    winLose = controller.evaluateGoal(kickPoint);
                    if (winLose == 1)
                    {
                        rMessage.setText("You Win!!");
                    }
                    else {
                        rMessage.setText("You Lose :(");
                    }
                    System.out.println(kickPoint[0]+","+kickPoint[1]+" "+winLose);
                    
                    //----------RESETS THE GAME----------------
                    keyCounter = 0;
                    tAccuracy.start();
                    p = 0;
                    a = 0;
                    accuracy.setValue(0);
                    power.setValue(0);
                    }                
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
            //------Random wind direction for send into controller----------
            if (obj == tWind)
            {
                wRandom = Math.random()*8;
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
                else if (wRandom <= 4)//North
                {
                    wx = 0;
                    wy = 1;
                    wMessage.setText("North");
                }
                else if (wRandom <= 5) //North West
                {
                    wx = -1;
                    wy = 1;
                    wMessage.setText("North West");
                }
                else if (wRandom <= 6) //South West
                {
                    wx = -1;
                    wy = -1;
                    wMessage.setText("South West");
                }
                else if (wRandom <= 7) //North East
                {
                    wx = 1;
                    wy = 1;
                    wMessage.setText("North East");
                }
                else if (wRandom <= 8) //North West
                {
                    wx = 1;
                    wy = -1;
                    wMessage.setText("North West");
                }                   
            }
            
            repaint();
        
    
    
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}