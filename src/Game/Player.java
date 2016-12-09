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
    public String name;
    public Integer pScore;
    public Player (String n, int s)
    {
        name = n;
        pScore = s;
    }
    public Player ()
    {
        
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the pScore
     */
    public int getpScore()
    {
        return pScore;
    }

    /**
     * @param pScore the pScore to set
     */
    public void setpScore(Integer pScore)
    {
        this.pScore = pScore;
    }

}

