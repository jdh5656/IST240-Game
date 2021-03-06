package Cards;

import Game.XML_240;
import Game.GameController;
import Game.Player;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import Cards.OptionsCard;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.io.*;
import java.beans.*;

/**
 *
 * @author nickonofrio
 */
public class GameCard extends JPanel implements ActionListener, javax.swing.event.ChangeListener {    
    
    GameController controller;
    OptionsCard gameOpt;
    XML_240 xmlGame;
    GameLeaderboard lb;
    
    JTextArea pMessage = new JTextArea("Power will be displayed here");
    JTextArea aMessage = new JTextArea("Accuracy will be displayed here");
    JTextArea wMessage = new JTextArea("Wind direction will be displayed here");
    JTextArea rMessage = new JTextArea("Outcome of kick will be shown here");
    JTextArea scoreMessage = new JTextArea("Score will be shown here");
    JLabel gameStatus = new JLabel(" ");
    JLabel showFinalScore = new JLabel(" ");
    JSlider accuracy, power;
    JButton b1, b2, b5, b6,b7,ball,jbGameOver;
    JLabel l1, l2, l3,countMessage, gAcc, gPow;
    JLabel showScore = new JLabel(" ");
    Timer tAccuracy;
    Timer tPower;
    Timer tWind;
    Timer tMessage;
    Timer tBall;
    Timer tFlip;
    Timer timer;
    int limit = 0;  
    int aDelay = 0;
    int dDelay = 0;
    int wDelay = 0;
    int mDelay = 0;
    int bDelay = 0;
    int fDelay = 0;
    int i = 0;
    int j = 0;
    int a = 1, vA = 1;
    int p = 1, vP = 1;
    int flipCount = 0;
    double animatex = 0, animatey = 0, distance;
    double setX = 0, setY = 0;
    int ballx = 625, bally = 500;
    double wRandom = Math.random() * 4;
    double wx = 1;
    double wy = 1;
    int kickPoint[];
    int winLose;
    int keyCounter = 0;
    int score = 0;
    long startTime = -1;
    long duration = 30*1000;
    Player[] play;
    Player tempPlay[];
    int pnum=0;
    int tempScore = 0;
    


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
    ImageIcon football2 = new ImageIcon("images/football2.png");
    ImageIcon start = new ImageIcon("images/start.png");
    ImageIcon stop = new ImageIcon("images/stop.png");
    ImageIcon gameover = new ImageIcon("images/gameover.png");
    ImageIcon accu = new ImageIcon ("images/acc.png");
    ImageIcon pow = new ImageIcon ("images/pow.png");

    public GameCard(GameController ctrl, OptionsCard opt, XML_240 xG, GameLeaderboard glead)
    {
        super();
        
        controller = ctrl;
        gameOpt = opt;
        xmlGame = xG;
        lb = glead;
        lb.jb2.addActionListener(this);
        
        setLayout(null);
        setBackground(Color.gray);
        
        //------Player setup ----------
        play = new Player[3];
        play[pnum] = new Player("Player 1", 0);
        play[1] = new Player("Player 2", 0);
        play[2] = new Player("Player 3", 0);
        play[pnum].setName("Player"+" "+ (pnum+1));
        tempPlay = new Player[3];
        tempPlay[0] = new Player(" ", 0);
        tempPlay[1] = new Player(" ", 0);
        tempPlay[2] = new Player(" ", 0);
        
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
        mDelay = 2*1000;
        tMessage = new Timer(mDelay, this);
        
        //--------Animation Timer-------------------------------------
        bDelay = 20;
        tBall = new Timer(bDelay, this);
        
        //-------Flip Timer---------------------------------------------
        fDelay = 75;
        tFlip = new Timer (fDelay, this);
        
        //-------Game Timer---------------------------------------------
        timer = new Timer(10, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (startTime < 0) {
                        startTime = System.currentTimeMillis();
                    }
                    long now = System.currentTimeMillis();
                    long clockTime = now - startTime;
                    if (clockTime >= duration) {
                        clockTime = duration;
                        timer.stop();
                        gameStatus.setText("TIME HAS EXPIRED!!");
                        showFinalScore.setText("You Made " + score + " Field Goals");
                        showFinalScore.setVisible(true);
                        jbGameOver.setVisible(true);
                        //----stop timers, reset game, etc
                        b1.setVisible(true);
                        accuracy.setValue(0);
                        power.setValue(0);
                        tPower.stop();
                        tAccuracy.stop();
                        keyCounter = 0;
                        b2.setVisible(false);
                        //---------XML stuff for leader board-------------                        
                        xmlGame.openReaderXML("test.xml");
                        play[0] = (Player)xmlGame.ReadObject();
                        play[1] = (Player)xmlGame.ReadObject();
                        play[2] = (Player)xmlGame.ReadObject();
                        xmlGame.closeReaderXML();
                        tempScore = play[pnum].pScore;
                        if (tempScore < score)
                        {
                            play[pnum].pScore = score;
                            xmlGame.openWriterXML("test.xml");
                            xmlGame.writeObject(play[0]);
                            xmlGame.writeObject(play[1]);
                            xmlGame.writeObject(play[2]);
                            xmlGame.closeWriterXML();         
                        }
                        lb.updateBoard();
                    }
                    SimpleDateFormat df = new SimpleDateFormat("ss:S");
                    countMessage.setText(df.format(duration - clockTime));
                }
            });
            timer.setInitialDelay(0);
            countMessage = new JLabel("Time Remaining");
        
        //Create JButtons
        b1 = new JButton();
        b1.addActionListener(this);
        b1.setHorizontalAlignment(JButton.CENTER);
        b1.setIcon(start);
    
        b2 = new JButton();
        b2.addActionListener(this);
        b2.setHorizontalAlignment(JButton.CENTER);
        b2.setIcon(stop);
        b2.setVisible(false);
        
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
        
        //-----Options button listeners----------
        gameOpt.jb1.addActionListener(this);
        gameOpt.jb2.addActionListener(this);
        gameOpt.jb3.addActionListener(this);
        gameOpt.jb7.addActionListener(this);
        gameOpt.jb8.addActionListener(this);
        gameOpt.jb9.addActionListener(this);
        
        
        //Football
        ball = new JButton("");
        ball.addActionListener(this);
        ball.setHorizontalAlignment(JButton.CENTER);
        ball.setHorizontalTextPosition(SwingConstants.CENTER);
        ball.setBorder(null);
        ball.setBorderPainted(false);
        ball.setContentAreaFilled(false);
        ball.setIcon(football);
        
        //game over
        jbGameOver = new JButton("");
        jbGameOver.addActionListener(this);
        jbGameOver.setHorizontalAlignment(JButton.CENTER);
        jbGameOver.setHorizontalTextPosition(SwingConstants.CENTER);
        jbGameOver.setBorder(null);
        jbGameOver.setBorderPainted(false);
        jbGameOver.setContentAreaFilled(false);
        jbGameOver.setIcon(gameover);
        
        //Create Sliders
        accuracy = new JSlider(JSlider.HORIZONTAL,0,100,0);
        accuracy.setMajorTickSpacing(25);
        accuracy.setBorder(BorderFactory.createTitledBorder("Accuracy"));
        accuracy.setPaintTicks(true);
        Color acc = new Color(118, 224, 92);
        accuracy.setBackground(acc);
        
        power = new JSlider(JSlider.VERTICAL,0,100,0);
        power.setMajorTickSpacing(25);
        power.setBorder(BorderFactory.createTitledBorder("power"));
        power.setPaintTicks(true);
        power.setBackground(acc);
        
        //Final Score
        showFinalScore.setForeground(Color.BLACK);
        showFinalScore.setFont(showScore.getFont().deriveFont(48.0f));
        showFinalScore.setHorizontalAlignment(SwingConstants.CENTER);
        showFinalScore.setVerticalAlignment(SwingConstants.CENTER);
        
        //Score or Miss Font
        showScore.setForeground(Color.BLACK);
        showScore.setFont(showScore.getFont().deriveFont(64.0f));
        showScore.setHorizontalAlignment(SwingConstants.CENTER);
        showScore.setVerticalAlignment(SwingConstants.CENTER);
        
        //Game Status Font
        gameStatus.setHorizontalAlignment(SwingConstants.CENTER);
        gameStatus.setVerticalAlignment(SwingConstants.CENTER);
        
        //Timer Font
        countMessage.setHorizontalAlignment(SwingConstants.CENTER);
        countMessage.setVerticalAlignment(SwingConstants.CENTER);
        
        
        //Create Graphics
        ImageIcon gameFar = new ImageIcon ("images/gameFar.png");
        ImageIcon gameAverage = new ImageIcon ("images/gameAverage.png");
        ImageIcon gameClose = new ImageIcon ("images/gameClose.png");
        l1 = new JLabel(gameClose);
        l2 = new JLabel (gameAverage);
        l3 = new JLabel (gameFar);
        l2.setVisible(false);
        l3.setVisible(false);
        gAcc = new JLabel (accu);
        gPow = new JLabel (pow);
        

            

        
        //Add Components
        add(gAcc);
        add(gPow);
        add(b1);
        add(b2);
        //add(b6);
        add(showFinalScore);
        add(showScore);
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
        add(countMessage);
        add(gameStatus);
        add(jbGameOver);
        add(l1);
        add(l2);
        add(l3);
        
        
        
    
        
        //------------Placing------------------------------------
        // x,y, length, height)
        accuracy.setBounds(new Rectangle(500,625,300,75));
        gAcc.setBounds(500, 595, 300, 30);
        power.setBounds(new Rectangle(800,400,75,300));
        gPow.setBounds(875, 400, 30, 300);
        b1.setBounds(new Rectangle(100,110,120,76));
        b2.setBounds(new Rectangle(100,110,120,76));
        b6.setBounds(300, 50, 750, 400);
        showScore.setBounds(new Rectangle(0, 0, 1300, 200));
        showFinalScore.setBounds(new Rectangle(0, 0, 1300, 200));
        pMessage.setBounds(new Rectangle(100,260,200,20));
        aMessage.setBounds(new Rectangle(100,230,200,20));
        wMessage.setBounds(new Rectangle(1000,230,200,20));
        rMessage.setBounds(new Rectangle(1000,500,200,20));
        scoreMessage.setBounds(new Rectangle(10,500,200,20));
        l1.setBounds(0, 0, 1300, 800);
        l2.setBounds(0, 0, 1300, 800);
        l3.setBounds(0, 0, 1300, 800);
        controller.optionsDifficulty.setBounds(new Rectangle(10,580,200,20));
        controller.optionsWind.setBounds(new Rectangle(10,620,200,20));
        controller.optionsDistance.setBounds(new Rectangle(10,660,200,20));
        b7.setBounds(new Rectangle(1000,60,160,160));
        ball.setBounds(new Rectangle(ballx,bally,40,70));
        countMessage.setBounds(new Rectangle(0,10,1300,20));
        gameStatus.setBounds(new Rectangle(0,30,1300,20));
        jbGameOver.setBounds(360, 200, 580, 130); jbGameOver.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        String choice = e.getActionCommand();        
	    if (obj == b1){
                tAccuracy.start();
                score = 0;
                scoreMessage.setText("Score: " + score);
                b1.setVisible(false);
                b2.setVisible(true);
                gameStatus.setText("");
                jbGameOver.setVisible(false);
                showFinalScore.setVisible(false);
                if (!timer.isRunning()) {
                        startTime = -1;
                        timer.start();
              }
            }
            
            if (obj == b2){
                //keyCounter determines which stage of the kick we are at
                //"0" is accuracy "1" is power
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
                    setX = ballx;
                    setY = bally;
                    //----------CALCULATES IF WIN ------------
                    kickPoint = controller.evaluateKick(p, a, wx, wy);
                    winLose = controller.evaluateGoal(kickPoint);
                    if (winLose == 1)
                    {
                        rMessage.setText("You Win!!");
                        //b6.setIcon(fieldgoal);
                        tAccuracy.stop();
                        tMessage.start();
                        score = (score + 1);
                        showScore.setText(""+score);
                        scoreMessage.setText("Score: " + score);                        
                    }
                    else {
                        rMessage.setText("You Lose :(");
                        b6.setIcon(missed);
                        showScore.setText("MISS!");
                        //b6.setIcon(missed);
                        tMessage.start();
                    }
                    kickPoint[0] = kickPoint[0] + ((1300 - (controller.kickX))/2);
                    kickPoint[1] = kickPoint[1] + (800 - controller.kickY);
                    tBall.start();
                    tFlip.start();
                    
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
                    wy = 1;
                    wMessage.setText("South");
                    b7.setIcon(south);
                }
                else if (wRandom <= 3) //West
                {
                    wx = 1;
                    wy = 0;
                    wMessage.setText("West");
                    b7.setIcon(west);
                }             
                else if (wRandom <= 4)//North
                {
                    wx = 0;
                    wy = -1;
                    wMessage.setText("North");
                    b7.setIcon(north);
                }
                else if (wRandom <= 5) //North West
                {
                    wx = 1;
                    wy = 1;
                    wMessage.setText("South East");
                    b7.setIcon(southEast);
                }
                else if (wRandom <= 6) //South West
                {
                    wx = -1;
                    wy = 1;
                    wMessage.setText("South West");
                    b7.setIcon(southWest);
                }
                else if (wRandom <= 7) //North East
                {
                    wx = 1;
                    wy = -1;
                    wMessage.setText("North East");
                    b7.setIcon(northEast);
                }
                else if (wRandom <= 8) //North West
                {
                    wx = -1;
                    wy = -1;
                    wMessage.setText("North West");
                    b7.setIcon(northWest);
                }
            }
            if (obj == tMessage) 
            {
                tAccuracy.start();
                tMessage.stop();
                tBall.stop();
                b6.setIcon(blank);
                showScore.setText("");
                animatex = 0;
                animatey = 0;
                ball.setBounds(ballx, bally, 40, 70);
                tBall.stop();
                ball.setIcon(football);
            }
            if (obj == tBall)
            {
                distance = Math.sqrt(animatex*animatex+animatey*animatey);
                animatex = ((double)kickPoint[0]-ballx)/20;
                animatey = ((double)kickPoint[1]-bally)/20;
                ball.setIcon(football2);
                if (distance >0)
                {
                    setX = (setX + animatex);
                    setY = (setY - animatey);
                    ball.setLocation((int)(setX + animatex), (int)(setY + animatey));
                }
            }
            if (obj == tFlip) 
            {
                if (flipCount == 0)
                {
                    ball.setIcon(football2);
                    flipCount = 1;
                }
                if (flipCount == 1)
                {
                    ball.setIcon(football);
                    flipCount = 0;
                }
            }
            if (obj == gameOpt.jb1)
            {
                //reset timers
                aDelay = 10;
                dDelay = 10;
                tAccuracy.stop();
                tPower.stop();
                tAccuracy = new Timer(aDelay, this);
                tPower = new Timer (dDelay, this);
                tAccuracy.start();
                tPower.start();
            }
            if (obj == gameOpt.jb2)
            {
                //reset timers
                aDelay = 6;
                dDelay = 6;
                tAccuracy.stop();
                tPower.stop();
                tAccuracy = new Timer(aDelay, this);
                tPower = new Timer (dDelay, this);
                tAccuracy.start();
                tPower.start();
            }
            if (obj == gameOpt.jb3)
            {
                //reset timers
                aDelay = 4;
                dDelay = 4;
                tAccuracy.stop();
                tPower.stop();
                tAccuracy = new Timer(aDelay, this);
                tPower = new Timer (dDelay, this);
                tAccuracy.start();
                tPower.start();
            }
            if (obj == gameOpt.jb7)
            {
                l1.setVisible(true);
                l2.setVisible(false);
                l3.setVisible(false);
            }
            if (obj == gameOpt.jb8)
            {
                l1.setVisible(false);
                l2.setVisible(true);
                l3.setVisible(false);
            }
            if (obj == gameOpt.jb9) 
            {
                l1.setVisible(false);
                l2.setVisible(false);
                l3.setVisible(true);
            }
            if (obj == lb.jb2)
            {
                lb.clearBoard();
            }
            
            repaint();
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}