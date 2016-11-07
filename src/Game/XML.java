/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.event.ActionEvent;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JButton;

/**
 *
 * @author jacobdhayes
 */
class XML {
    
        XMLEncoder xe;
        XMLDecoder de;
        
	String name = "joe";
	int age = 22;

	public XML()
	{
             
	}
        
        String write() {
            try {
                xe = new XMLEncoder(new BufferedOutputStream(new FileOutputStream("info.xml")));
            }
            catch(Exception xx) {xx.printStackTrace();}

            try {
                xe.writeObject(name);
                xe.writeObject(age);
            }
            catch(Exception xx) {xx.printStackTrace();}

            try {
                xe.close();
            }
            catch(Exception xx) {xx.printStackTrace();}

            return "Info Saved OK - check the XML file to see the results";
        }
        
        String read(){
            try {
                de = new XMLDecoder(new BufferedInputStream(new FileInputStream("info.xml")));
            }
            catch(Exception xx) {xx.printStackTrace();}
            
            try {
                name = (String)de.readObject();
                age = (Integer)de.readObject();

            }
            catch(Exception xx) {xx.printStackTrace();}
            
            try {
                de.close();
            }
            catch(Exception xx) {xx.printStackTrace();}
            
            return "completed";
        
        }
    
}
