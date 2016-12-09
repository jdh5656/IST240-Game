/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import javax.swing.*;

/**
 *
 * @author John
 */
public class Player extends JButton
{
    String name;
    int pScore;
    public Player (String n, int s)
    {
        
    }
    public String getName() 
    {
    return name;
    }
    public void setName(String name)
    {
         this.name = name;
    }
    public int getScore() 
    {
        return pScore;
    }
    public void setScore(int pscore)
    {
        this.pScore = pscore;
    }
}

