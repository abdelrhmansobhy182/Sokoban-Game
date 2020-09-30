package sokoban;

import java.awt.Graphics;
import java.awt.Image;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import javax.swing.ImageIcon;

import static sokoban.Sokoban.counter;
import static sokoban.Sokoban.counter_down;
import static sokoban.Sokoban.counter_left;
import static sokoban.Sokoban.counter_right;
import static sokoban.Sokoban.counter_up;
import static sokoban.Sokoban.d;
import static sokoban.Sokoban.l;
import static sokoban.Sokoban.player_x;
import static sokoban.Sokoban.player_y;
import static sokoban.Sokoban.player_i;
import static sokoban.Sokoban.player_j;
import static sokoban.Sokoban.pushes;
import static sokoban.Sokoban.moves;
import static sokoban.Sokoban.r;
import static sokoban.Sokoban.number_charcter;
import static sokoban.Sokoban.u;
import static sokoban.level.first;
import static sokoban.level.map;
import static sokoban.Al.back;
import static sokoban.designform.chracter_number;
/**
 *
 * @author Abdelrhman
 */
 public abstract class chracter {
static ArrayList<Image> right = new ArrayList<Image>();
static ArrayList<Image> left = new ArrayList<Image>();
static ArrayList<Image> up = new ArrayList<Image>();
ImageIcon r1,r2,r3,l1,l2,l3,u1,u2,u3,d1,d2,d3;
static ArrayList<Image> down = new ArrayList<Image>();

static boolean move=false;
   String characterMovingLocaion= "C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\Character_Moving.wav" ;
        sounds sound =new sounds() ;
        
   String gettingCoinLocaion= "C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\Getting_Coin.wav" ;
        sounds sound1 =new sounds() ;
    
        
    public chracter()
    { 
    }
   



    public void change_character()
    {
        System.out.println("sokoban_char "+chracter_number);
        if(chracter_number==2)
        {
         r1=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\right1.png");
         r2=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\right2.png");
         r3=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\right3.png");
      
        l1=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\left1.png");
        l2=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\left2.png");
        l3=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\left3.png");
      
        u1=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\up1.png");
        u2=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\up2.png");
        u3=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\up3.png");
        
         d1=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\down1.png");
         d2=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\down2.png");
         d3=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\down3.png");
        number_charcter=2;
        }
        else{
          r1=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\right1_1.png");
          r2=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\right2_1.png");
          r3=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\right3_1.png");
        
      
         l1=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\left1_1.png");
         l2=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\left2_1.png");
         l3=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\left3_1.png");
      
         u1=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\up1_1.png");
         u2=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\up2_1.png");
         u3=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\up3_1.png");
        
         d1=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\down1_1.png");
         d2=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\down2_1.png");
         d3=new ImageIcon("C:\\Users\\Dell\\Documents\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\down3_1.png");
         
        number_charcter=1;
        }
        right.add(0, r1.getImage()); right.add(1, r2.getImage());  
        right.add(2, r3.getImage()); 
        left.add(0, l1.getImage()); left.add(1, l2.getImage());
        left.add(2, l3.getImage()); 
        up.add(0, u1.getImage()); up.add(1, u2.getImage()); 
        up.add(2, u3.getImage()); 
        down.add(0, d1.getImage()); down.add(1, d2.getImage());
        down.add(2, d3.getImage()); 
    }
    abstract public void draw();
    public void paint(Graphics g)
    {
        if (first==true)
        {
            
        
         if (u==false&&r==false&&d==false&&l==false)
        {       
            g.drawImage(down.get(0), player_x, player_y, null);
            
        }
         else if (r)
        {
            g.drawImage(right.get(counter_right), player_x, player_y, null);
            counter=counter+1;
            if (counter<65)
            player_x=player_x+1;
            
        }
         else if (l)
        {
            g.drawImage(left.get(counter_left), player_x, player_y, null);
        
              counter=counter+1;
            if (counter<65)
            player_x=player_x-1;
        }
         else if (u)
        {
            g.drawImage(up.get(counter_up), player_x, player_y, null);
            
              counter=counter+1;
            if (counter<65)
            player_y=player_y-1;
        }
         else if (d)
        {
            g.drawImage(down.get(counter_down), player_x, player_y, null);
            
              counter=counter+1;
            if (counter<65)
            player_y=player_y+1;
        }
         else
         {};
        
    }
      
    }
    public void Move_UP()
    {
         sound.Character_Moving(characterMovingLocaion);
            move=true;
            back=false;
            if (counter==0||counter>65)
            {
                counter=0;
            if (map[player_i-1][player_j]==1)
            {
                Sokoban.u =false;
               Sokoban.l =false;
               Sokoban.r =false;
               Sokoban.d =false;
            }
            else  if (map[player_i-1][player_j]!=1)
            {
                if(map[player_i-1][player_j]==2&&map[player_i-2][player_j]==6)
                {
                    
                         map[player_i-2][player_j]=2;
                         map[player_i-1][player_j]=6;
                         pushes++;
                }
                if(map[player_i-1][player_j]==2&&map[player_i-2][player_j]==3)
                {
                    
                         map[player_i-2][player_j]=4;
                         map[player_i-1][player_j]=6;
                         sound1.Getting_Coin(gettingCoinLocaion);
                         pushes++;
                }
                 if(map[player_i-1][player_j]==4&&map[player_i-2][player_j]==6)
                {
                    
                         map[player_i-2][player_j]=2;
                         map[player_i-1][player_j]=3;
                         pushes++;
                         
                }
                 if(map[player_i-1][player_j]==4&&map[player_i-2][player_j]==3)
                {
                    
                         map[player_i-2][player_j]=4;
                         map[player_i-1][player_j]=3;
                          pushes++;
                }
                if (map[player_i-1][player_j]==6||map[player_i-1][player_j]==3)
                {
                player_i--;
            moves++;
                 Sokoban.player_y=Sokoban.player_y-1;
    
               Sokoban.u =true;
               Sokoban.l =false;
               Sokoban.r =false;
               Sokoban.d =false;
                if (Sokoban.counter_up>=Sokoban.number_charcter)
                    Sokoban.counter_up=0;
                else
                {
                    Sokoban.counter_up++;
                    Sokoban.counter_down=0;
                    Sokoban.counter_left=0;
                    Sokoban.counter_right=0;
                }
            
            
            
            }
            else
            {
                
                Sokoban.u =false;
               Sokoban.l =false;
               Sokoban.r =false;
               Sokoban.d =false;
            
            }
        
            }
            }  
    }
    public void Move_Down()
    {
        sound.Character_Moving(characterMovingLocaion);
            move=true;
            back=false;
            if (counter==0||counter>65)
            {
                counter=0;
             if (map[player_i+1][player_j]==1)
            {
                Sokoban.u =false;
               Sokoban.l =false;
               Sokoban.r =false;
               Sokoban.d =false;
            }
             else if (map[player_i+1][player_j]!=1)
            {
                
                if(map[player_i+1][player_j]==2&&map[player_i+2][player_j]==6)
                {
                    map[player_i+2][player_j]=2;
                    map[player_i+1][player_j]=6;
                    pushes++;
                }
                if(map[player_i+1][player_j]==2&&map[player_i+2][player_j]==3)
                {
                    sound1.Getting_Coin(gettingCoinLocaion);
                         map[player_i+2][player_j]=4;
                         map[player_i+1][player_j]=6;
                          pushes++;
                }
                 if(map[player_i+1][player_j]==4&&map[player_i+2][player_j]==6)
                {
                    
                         map[player_i+2][player_j]=2;
                         map[player_i+1][player_j]=3;
                          pushes++;
                }
                 if(map[player_i+1][player_j]==4&&map[player_i+2][player_j]==3)
                {
                    
                         map[player_i+2][player_j]=4;
                         map[player_i+1][player_j]=3;
                          pushes++;
                }
                if (map[player_i+1][player_j]==6||map[player_i+1][player_j]==3)
                {
                 player_i++;
                 moves++;
            
                Sokoban.u =false;
               Sokoban.l =false;
               Sokoban.r =false;
               Sokoban.d =true;
               
                  Sokoban.player_y=Sokoban.player_y+1;
                  
                if (Sokoban.counter_down>=Sokoban.number_charcter)
                    Sokoban.counter_down=0;
                else 
                {
                    Sokoban.counter_left=0;
                    Sokoban.counter_down++;
                    Sokoban.counter_right=0;
                    Sokoban.counter_up=0;
                } 
            
            }
            else{
                Sokoban.u =false;
               Sokoban.l =false;
               Sokoban.r =false;
               Sokoban.d =false;
            }
            }
            }  
    }
    public void Move_Right()
    {
        sound.Character_Moving(characterMovingLocaion);
            move=true;
            back=false;
            if (counter==0||counter>65)
             {
                 counter=0;
            if (map[player_i][player_j+1]==1)
            {
                Sokoban.u =false;
               Sokoban.l =false;
               Sokoban.r =false;
               Sokoban.d =false;
            }
            else  if (map[player_i][player_j+1]!=1)
            {
                if(map[player_i][player_j+1]==2&&map[player_i][player_j+2]==6)
                {
                    map[player_i][player_j+2]=2;
                    map[player_i][player_j+1]=6;
                     pushes++;
                }
                if(map[player_i][player_j+1]==2&&map[player_i][player_j+2]==3)
                {
                    sound1.Getting_Coin(gettingCoinLocaion);
                         map[player_i][player_j+2]=4;
                         map[player_i][player_j+1]=6;
                          pushes++;
                }
                 if(map[player_i][player_j+1]==4&&map[player_i][player_j+2]==6)
                {
                    
                         map[player_i][player_j+2]=2;
                         map[player_i][player_j+1]=3;
                          pushes++;
                }
                 if(map[player_i][player_j+1]==4&&map[player_i][player_j+2]==3)
                {
                    
                         map[player_i][player_j+2]=4;
                         map[player_i][player_j+1]=3;
                          pushes++;
                }
                if(map[player_i][player_j+1]==6||map[player_i][player_j+1]==3)
                {
                 player_j++;
                moves++;
                 Sokoban.u =false;
               Sokoban.l =false;
               Sokoban.r =true;
               Sokoban.d =false;
               
                   Sokoban.player_x=Sokoban.player_x+1;
                
                if (Sokoban.counter_right>=Sokoban.number_charcter)
                    Sokoban.counter_right=0;
                else
                {
                    Sokoban.counter_right++;
                    Sokoban.counter_left=0;
                    Sokoban.counter_down=0;
                    Sokoban.counter_up=0;
                }
             
            }
            else
            {
                 Sokoban.u =false;
               Sokoban.l =false;
               Sokoban.r =false;
               Sokoban.d =false;
            }
           
            
            } 
             }
    }
    public void Move_Left()
    {
        sound.Character_Moving(characterMovingLocaion);
            move=true;
            back=false;
            if (counter==0||counter>65)
            {
                counter=0;
            if (map[player_i][player_j-1]==1)
            {
                Sokoban.u =false;
               Sokoban.l =false;
               Sokoban.r =false;
               Sokoban.d =false;
            }
            else  if (map[player_i][player_j-1]!=1)
            {
                if(map[player_i][player_j-1]==2&&map[player_i][player_j-2]==6)
                {
                    map[player_i][player_j-2]=2;
                    map[player_i][player_j-1]=6;
                     pushes++;
                }
                if(map[player_i][player_j-1]==2&&map[player_i][player_j-2]==3)
                {
                    sound1.Getting_Coin(gettingCoinLocaion);
                    
                         map[player_i][player_j-2]=4;
                         map[player_i][player_j-1]=6;
                          pushes++;
                }
                 if(map[player_i][player_j-1]==4&&map[player_i][player_j-2]==6)
                {
                    
                         map[player_i][player_j-2]=2;
                         map[player_i][player_j-1]=3;
                          pushes++;
                }
                  if(map[player_i][player_j-1]==4&&map[player_i][player_j-2]==3)
                {
                    
                         map[player_i][player_j-2]=4;
                         map[player_i][player_j-1]=3;
                          pushes++;
                }
                if(map[player_i][player_j-1]==6||map[player_i][player_j-1]==3)
                {
                 player_j--;
               moves++;
              Sokoban.u =false;
               Sokoban.l =true;
               Sokoban.r =false;
               Sokoban.d =false;
		Sokoban.player_x=Sokoban.player_x-1;
                
                if (Sokoban.counter_left>=Sokoban.number_charcter)
                    Sokoban.counter_left=0;
                else 
                {
                Sokoban.counter_left++;
                Sokoban.counter_down=0;
                Sokoban.counter_right=0;
                Sokoban.counter_up=0;
                }  
            
            }
            else
            {
                Sokoban.u =false;
               Sokoban.l =false;
               Sokoban.r =false;
               Sokoban.d =false;
            }
            
           
            
            }
            }  
    }
}
