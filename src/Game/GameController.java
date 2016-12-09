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
    public int kickX = 700; //in pixels, width
    public int kickY = 400; //in pixels, height
    public int winXMax = 615; //in pixels
    public int winXMin = 85; //in pixels
    public int winYMax = 300; //in pixels
    public int winYMin = 100; //in pixels
    public int wind = 1;
    public int dist = 1;
           
    
    
    
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
        double baseWind = 30;
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
        
        
            
        //Adjusts x based on wind direction and degree of adjustment
        System.out.println("x: " + (x+300) + " y: "+ (y+400));
        if (wind == 1)
        {
            x = x + (randomNum * xDir * baseWind);
            y = y + (randomNum * yDir * baseWind);
        }
           // if wind
        if (wind == 2)
        {
            x = x + (int) ((randomNum * xDir * baseWind) + (xDir*baseWind*2));   
            y = y + (int) ((randomNum * yDir * baseWind) + (yDir*baseWind*2)); 
        }
        if (wind == 3)
        {
            x = x + (int) ((randomNum * xDir * 10) + (xDir*baseWind*2.5));
            y = y + (int) ((randomNum * yDir * 10) + (yDir*baseWind*2.5));   
        }        
        //sets coordinates
        int coordinates[] = {(int)x,(int)y};
        return coordinates;
    }
    
    public int evaluateGoal(int coordinates[]) {
        int goal = 0; //1 for win 0 for lose
        //if distance = 1, 2, 3 boundingbox = ?
        System.out.println("x coord: "+ coordinates[0] + " winXMin: " + winXMin);
        System.out.println("y coord: "+ coordinates[1] + " winYMin: " + winYMin);
        if (dist == 1)
        {
            if (coordinates[0] >= winXMin && coordinates[0] <= winXMax && coordinates[1] >= winYMin) 
            {            
                System.out.println("test");
                goal = 1;
            }
            else {
                goal = 0;
            }     
        }
        if (dist == 2)
        {
            if (coordinates[0] >= winXMin && coordinates[0] <= winXMax && coordinates[1] >= winYMin)
            {
                goal = 1;
            }
            else {
                goal = 0;
            }
            
        }
        if (dist == 3)
        {
            if (coordinates[0] >= winXMin && coordinates[0] <= winXMax && coordinates[1] >= winYMin)
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