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
    
    
    
    public GameController()
    {
        super();
        
         //Display Options
        optionsDifficulty = new JTextArea("Game Type: "+options.difficulty);
        optionsWind = new JTextArea("Wind: "+options.wind);
        optionsDistance = new JTextArea("Distance: "+options.distance);    
        
    }
    
    public int[] evaluateKick(int p, int a, int xDir, int yDir){
        int x = 0;
        int y = 0;
        int coordinates[] = {x,y};        
        //if power
            //if options distance
        if (p > 0 && p < 100) 
        {
            if (options.difficulty == "Practice")
            {
                
            }
            if (options.difficulty == "Game Day")
            {
                
            }
            if (options.difficulty == "Championship")
            {
                
            }            
        }
            
        //if accuracy
           // if wind
        

        
        return coordinates;
        
    }
    
    int evaluateGoal() {
        
        //if distance = 1, 2, 3 boundingbox = ?
        
        
        
        int goal = 0;
        
        //if [x,y] is within bounding box goal = 1 else goal = 0

        
        return goal;
    }
    
    
    

}