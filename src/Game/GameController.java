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
    int kickBoxX = 530;//width in pixels
    int kickBoxY = 300; //width in pixels
    
    
    
    public GameController()
    {
        super();
        
         //Display Options
        optionsDifficulty = new JTextArea("Game Type: "+options.difficulty);
        optionsWind = new JTextArea("Wind: "+options.wind);
        optionsDistance = new JTextArea("Distance: "+options.distance);    
        
    }
    
    public int[] evaluateKick(int pow, int acc, int xDir, int yDir){
        int x = 0;
        int y = 0;
        double randomNum = Math.random();
        int baseWind = 10;
        
        //if power
        // Calculates x and y values BEFORE wind factor
        if (pow >= 0 && pow <= 100) 
        {
            y = ((pow/100)*kickBoxY);
        }
        if (acc >= 0 && acc <=100)
        {
            x = (acc/100)*kickBoxX;
        }
        
            
        //Adjusts x based on wind direction and degree of adjustment
        if (options.wind == "Slight")
        {
            x = x + (int) (randomNum * xDir * baseWind);
            y = y + (int) (randomNum * xDir * baseWind);
        }
           // if wind
        if (options.wind == "Moderate")
        {
            x = x + (int) ((randomNum * xDir * baseWind) + baseWind);   
            y = y + (int) ((randomNum * xDir * baseWind) + baseWind); 
        }
        if (options.wind == "Heavy")
        {
            x = x + (int) ((randomNum * xDir * 10) + (baseWind+5));
            y = y + (int) ((randomNum * xDir * 10) + (baseWind+5));
            
        }
        
        //sets coordinates
        int coordinates[] = {x,y};
        return coordinates;
        
    }
    
    int evaluateGoal() {
        
        //if distance = 1, 2, 3 boundingbox = ?
        
        
        
        int goal = 0;
        
        //if [x,y] is within bounding box goal = 1 else goal = 0

        
        return goal;
    }
    
    
    

}