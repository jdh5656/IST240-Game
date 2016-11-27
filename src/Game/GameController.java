package Game;

import java.awt.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import javax.swing.*;
import javax.swing.event.ChangeEvent;

/**
 *
 * @author jacobhayes
 */
public class GameController {

    public GameOptions options = new GameOptions();
    
    public JTextArea optionsDifficulty;
    public JTextArea optionsWind;
    public JTextArea optionsDistance;
    public int kickX = 530; //in pixels, width
    public int kickY = 300; //in pixels, height
    public int winXMax = 415; //in pixels
    public int winXMin = 115; //in pixels
    public int winYMax = 250; //in pixels
    public int winYMin = 50; //in pixels
    
    
    
    public GameController()
    {
        super();
        
         //Display Options
        optionsDifficulty = new JTextArea("Game Type: "+options.difficulty);
        optionsWind = new JTextArea("Wind: "+options.wind);
        optionsDistance = new JTextArea("Distance: "+options.distance);    
        
    }
    
    public int[] evaluateKick(double pow, double acc, double xDir, double yDir){
        double x = 0;
        double y = 0;
        double randomNum = Math.random();
        System.out.println(randomNum);
        double baseWind = 10;
        System.out.println("x and y before sending through 'if' option evaluate kick: "+ x+ " "+ y);
        //if power
        // Calculates x and y values BEFORE wind factor
        if (pow >= 0 && pow <= 100) 
        {
            y = (pow/100)*kickY;
        }
        if (acc >= 0 && acc <=100)
        {
            x = (double)(acc/100)*kickX;
        }
        System.out.println("x and y before sending through 'if' option evaluate kick: "+ x+ " "+ y);
        
        
            
        //Adjusts x based on wind direction and degree of adjustment
        if (options.wind == "Slight")
        {
            System.out.println(xDir + " " + yDir + " "+ baseWind);
            x = x + (randomNum * xDir * baseWind);
            y = y + (randomNum * yDir * baseWind);
            System.out.println("x and y after evaluateKick calculation for 'Slight' wind "+x+" "+y);
        }
           // if wind
        if (options.wind == "Moderate")
        {
            x = x + (int) ((randomNum * xDir * baseWind) + baseWind);   
            y = y + (int) ((randomNum * yDir * baseWind) + baseWind); 
        }
        if (options.wind == "Heavy")
        {
            x = x + (int) ((randomNum * xDir * 10) + (baseWind+5));
            y = y + (int) ((randomNum * yDir * 10) + (baseWind+5));
            
        }
        
        //sets coordinates
        int coordinates[] = {(int)x,(int)y};
        return coordinates;
        
    }
    
    public int evaluateGoal(int coordinates[]) {
        int goal = 0; //1 for win 0 for lose
        //if distance = 1, 2, 3 boundingbox = ?
        if (options.distance == "Close")
        {
            if (coordinates[0] >= winXMin && coordinates[0] <= winXMax && coordinates[1] >= winYMin && coordinates[1] <= winYMin)
            {
                goal = 1;
            }
            else {
                goal = 0;
            }
            
        }
        if (options.distance == "Average")
        {
            if (coordinates[0] >= winXMin && coordinates[0] <= winXMax && coordinates[1] >= winYMin && coordinates[1] <= winYMin)
            {
                goal = 1;
            }
            else {
                goal = 0;
            }
            
        }
        if (options.distance == "NFL Record")
        {
            if (coordinates[0] >= winXMin && coordinates[0] <= winXMax && coordinates[1] >= winYMin && coordinates[1] <= winYMin)
            {
                goal = 1;
            }
            else {
                goal = 0;
            }            
        }
        
        //if [x,y] is within bounding box goal = 1 else goal = 0

        
        return goal;
    }
    
    
    

}