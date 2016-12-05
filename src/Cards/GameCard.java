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
    JTextArea scoreMessage = new JTextArea("Score will be shown here");
    JSlider accuracy, power;
    JButton b1, b2, b5, b6,b7,ball;
    JLabel l1, l2;
    Timer tAccuracy;
    Timer tPower;
    Timer tWind;
    Timer tMessage;
    int limit = 0;  
    int aDelay = 0;
    int dDelay = 0;
    int wDelay = 0;
    int mDelay = 0;
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
    int score = 0;
    
    ImageIcon north = new ImageIcon("images/north.png");
        ImageIcon northEast = new ImageIcon("images/northeast.png");
        ImageIcon northWest = new ImageIcon("images/northwest.png");
        ImageIcon south = new ImageIcon("images/south.png");
        ImageIcon southEast = new ImageIcon("images/southeast.png");
        ImageIcon southWest = new ImageIcon("images/southwest.png");
        ImageIcon east = new ImageIcon("images/east.png");
        ImageIcon west = new ImageIcon("images/west.png");
        ImageIcon fieldgoal = new ImageIcon("images/fieldgoal.png");
        ImageIcon blank = new ImageIcon("images/blank.png");
        ImageIcon missed = new ImageIcon("images/missed.png");
        ImageIcon football = new ImageIcon("images/football1.png");

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
        
        //-------MESSAGE TIMER------------------------------------------
        mDelay = 1*1000;
        tMessage = new Timer(mDelay, this);
        
        //Create JButtons
        b1 = new JButton("Start Game");
        b1.addActionListener(this);
        b1.setHorizontalAlignment(JButton.CENTER);
        
        b2 = new JButton("Stop Slider");
        b2.addActionListener(this);
        b2.setHorizontalAlignment(JButton.CENTER);
        
        //Win or miss
        b6 = new JButton("");
        b6.addActionListener(this);
        b6.setHorizontalAlignment(JButton.CENTER);
        b6.setHorizontalTextPosition(SwingConstants.CENTER);
        b6.setBorder(null);
        b6.setBorderPainted(false);
        b6.setContentAreaFilled(false);
        
        //Compass
        b7 = new JButton("");
        b7.addActionListener(this);
        b7.setHorizontalAlignment(JButton.CENTER);
        b7.setHorizontalTextPosition(SwingConstants.CENTER);
        b7.setBorder(null);
        b7.setBorderPainted(false);
        b7.setContentAreaFilled(false);
        b7.setIcon(north);
        
        //Football
        ball = new JButton("");
        ball.addActionListener(this);
        ball.setHorizontalAlignment(JButton.CENTER);
        ball.setHorizontalTextPosition(SwingConstants.CENTER);
        ball.setBorder(null);
        ball.setBorderPainted(false);
        ball.setContentAreaFilled(false);
        ball.setIcon(football);
        
        
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
        add(ball);
        add(accuracy);
        add(power);
        add(pMessage);
        add(aMessage);
        add(wMessage);
        add(rMessage);
        add(scoreMessage);
        add(controller.optionsDifficulty);
        add(controller.optionsWind);
        add(controller.optionsDistance);
        add(b7);
        add(l2);
        
    
        
        //------------Placing------------------------------------
        // x,y, length, height)
        accuracy.setBounds(new Rectangle(500,600,300,100));
        power.setBounds(new Rectangle(800,400,100,300));
        b1.setBounds(new Rectangle(100,10,100,100));
        b2.setBounds(new Rectangle(100,120,100,100));
        b6.setBounds(300, 50, 750, 400);
        pMessage.setBounds(new Rectangle(100,260,200,20));
        aMessage.setBounds(new Rectangle(100,230,200,20));
        wMessage.setBounds(new Rectangle(1000,230,200,20));
        rMessage.setBounds(new Rectangle(1000,500,200,20));
        scoreMessage.setBounds(new Rectangle(10,500,200,20));
        l2.setBounds(0, 0, 1300, 800);
        controller.optionsDifficulty.setBounds(new Rectangle(10,580,200,20));
        controller.optionsWind.setBounds(new Rectangle(10,620,200,20));
        controller.optionsDistance.setBounds(new Rectangle(10,660,200,20));
        
        b7.setBounds(new Rectangle(1000,60,160,160));
        ball.setBounds(new Rectangle(625,500,40,70));
 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String choice = e.getActionCommand();        
	    if (obj == b1){
                tAccuracy.start();
                score = 0;
                scoreMessage.setText("Score: " + score);
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
                        b6.setIcon(fieldgoal);
                        tAccuracy.stop();
                        tMessage.start();
                        score = (score + 1);
                        scoreMessage.setText("Score: " + score);
                        
                    }
                    else {
                        rMessage.setText("You Lose :(");
                        b6.setIcon(missed);
                        tMessage.start();
                    }
                    System.out.println(kickPoint[0]+","+kickPoint[1]+" "+winLose);
                    
                    //----------RESETS THE GAME----------------
                    keyCounter = 0;
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
                    b7.setIcon(east);
                }
                else if (wRandom <= 2) //South
                {
                    wx = 0;
                    wy = -1;
                    wMessage.setText("South");
                    b7.setIcon(south);
                }
                else if (wRandom <= 3) //West
                {
                    wx = -1;
                    wy = 0;
                    wMessage.setText("West");
                    b7.setIcon(west);
                }             
                else if (wRandom <= 4)//North
                {
                    wx = 0;
                    wy = 1;
                    wMessage.setText("North");
                    b7.setIcon(north);
                }
                else if (wRandom <= 5) //North West
                {
                    wx = -1;
                    wy = 1;
                    wMessage.setText("North West");
                    b7.setIcon(northWest);
                }
                else if (wRandom <= 6) //South West
                {
                    wx = -1;
                    wy = -1;
                    wMessage.setText("South West");
                    b7.setIcon(southWest);
                }
                else if (wRandom <= 7) //North East
                {
                    wx = 1;
                    wy = 1;
                    wMessage.setText("North East");
                    b7.setIcon(northEast);
                }
                else if (wRandom <= 8) //North West
                {
                    wx = 1;
                    wy = -1;
                    wMessage.setText("North West");
                    b7.setIcon(northWest);
                }
            }
            if (obj == tMessage) 
            {
                tAccuracy.start();
                tMessage.stop();
                b6.setIcon(blank);
            }
            
            repaint();
        
    
    
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}