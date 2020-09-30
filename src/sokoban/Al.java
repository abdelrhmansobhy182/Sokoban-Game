/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;

import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static sokoban.Sokoban.counter;
import static sokoban.Sokoban.player_i;
import static sokoban.Sokoban.player_j;
 
import  static sokoban.Sokoban.c;
import static sokoban.level.map;


/**
 *
 * @author Abdelrhman
 */
//inthertance
public class Al extends KeyAdapter{
public static boolean back=false;
   
        
   
    public void keyPressed(KeyEvent e) {
        
	switch (e.getKeyCode()) {
            
	case KeyEvent.VK_UP:
           c.Move_UP();
		break;
	case KeyEvent.VK_LEFT:
           c.Move_Left();
		break;
	case KeyEvent.VK_DOWN:
            c.Move_Down();
		break;
        case KeyEvent.VK_RIGHT:
            c.Move_Right();
		break;
            case KeyEvent.VK_SPACE:
                if(Sokoban.u&&back==false)
                {
                    c.Move_Down();
                    back=true;
                }
                    
                if(Sokoban.d&&back==false)
                {
                    c.Move_UP(); 
                    back=true;
                }
                   
                if(Sokoban.l&&back==false)
                {
                    c.Move_Right();
                    back=true;
                }
                    
                if(Sokoban.r&&back==false)
                {
                    c.Move_Left();
                    back=true;
                }
                    
                break;

        }
    }
}
