/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sokoban;
  
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import static sokoban.chracter.move;
import static sokoban.Sokoban.block_x;
import static sokoban.Sokoban.i;
import static sokoban.Sokoban.bg;
import static sokoban.Sokoban.block_y;
import static sokoban.Sokoban.player_i;
import static sokoban.Sokoban.player_j;
import static sokoban.Sokoban.player_x;
import static sokoban.Sokoban.player_y;
import static sokoban.Sokoban.c;
import static sokoban.Sokoban.player_level;
import static sokoban.Sokoban.r;
import static sokoban.designform.wall_number;
import static sokoban.designform.box_number;
import static sokoban.chracter.down;
import static sokoban.designform.bg_number;
import static sokoban.designform.chracter_number;


 
public  class level extends draw{
    
      //  private JButton b1;
   static public int[][] map   = new int[10][10];
//   {
//      {0,1,1,1,1,1,1,1,0,0},
//      {1,1,6,6,1,6,6,1,1,0},
//      {1,6,3,2,4,2,3,6,1,0},
//      {1,6,6,6,1,6,6,6,1,0},
//      {1,1,6,6,4,6,6,1,1,0},
//       
//      {0,1,5,6,4,6,6,1,0,0},
//      {0,1,1,1,1,1,1,1,0,0},
//      {0,0,0,0,0,0,0,0,0,0},
//      {0,0,0,0,0,0,0,0,0,0},
//      {0,0,0,0,0,0,0,0,0,0}
//   };

    
    
   static public int [][] maps=new int [][]{
      //sobhy
       //1
    {0,1,1,1,1,1,0,0,0,0, 0,1,6,6,6,1,1,0,0,0, 1,1,6,4,6,3,1,1,0,0, 1,6,2,2,4,6,6,1,0,0 ,1,6,6,4,6,3,6,1,0,0,
     1,1,6,5,6,1,1,1,0,0, 0,1,1,1,1,1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       //2
    {1,1,1,1,1,1,0,0,0,0, 1,6,6,6,6,1,0,0,0,0, 1,6,1,1,2,1,1,1,0,0, 1,6,3,6,4,6,6,1,0,0, 1,6,6,6,4,6,5,1,0,0,
     1,1,6,6,2,6,6,1,0,0, 0,1,6,1,4,1,1,1,0,0, 0,1,6,6,6,1,0,0,0,0, 0,1,1,1,1,1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       //3
    {1,1,1,1,1,1,1,1,1,0, 1,6,3,5,3,2,3,6,1,0, 1,6,1,6,2,6,6,6,1,0, 1,6,1,1,2,1,1,1,1,0, 1,6,6,6,2,6,6,1,1,0,
     1,1,1,6,3,6,6,6,1,1, 0,0,1,1,1,6,6,6,6,1, 0,0,0,0,1,1,6,6,6,1, 0,0,0,0,0,1,1,1,1,1, 0,0,0,0,0,0,0,0,0,0},
       //4
    {0,0,0,0,1,1,1,1,0,0, 0,0,1,1,1,6,6,1,0,0, 0,0,1,6,6,6,3,1,0,0, 1,1,1,6,6,1,6,1,0,0, 1,6,4,2,6,4,4,1,1,0,
     1,6,1,6,5,1,6,6,1,0, 1,6,6,1,6,6,6,6,1,0, 1,1,6,6,6,6,1,1,1,0, 0,1,1,1,1,1,1,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       //5
    {0,0,1,1,1,1,1,1,0,0, 1,1,1,6,6,6,6,1,0,0, 1,6,6,4,1,1,3,1,0,0, 1,6,1,3,6,6,3,1,0,0, 1,6,2,6,2,6,6,1,0,0,
     1,1,2,1,2,1,5,1,0,0, 0,1,6,6,6,6,3,1,0,0, 0,1,1,1,1,1,1,1,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       //6
    {0,0,1,1,1,1,0,0,0,0, 1,1,1,6,6,1,0,0,0,0, 1,6,3,4,6,1,1,0,0,0, 1,6,1,6,6,6,1,0,0,0, 1,5,4,4,6,6,1,0,0,0,
     1,6,1,6,6,6,1,0,0,0, 1,6,2,4,6,1,1,0,0,0, 1,1,1,6,6,1,0,0,0,0, 0,0,1,1,1,1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       //7
    {0,0,1,1,1,1,0,0,0,0, 1,1,1,6,6,1,1,1,1,0, 1,6,2,6,6,6,6,6,1,0, 1,6,3,6,4,1,6,6,1,0, 1,1,1,3,5,1,2,1,1,0,
     1,6,3,6,4,1,6,6,1,0, 1,6,2,6,6,6,6,6,1,0, 1,1,1,1,1,1,6,6,1,0, 0,0,0,0,0,1,1,1,1,0, 0,0,0,0,0,0,0,0,0,0},
       //8
    {0,1,1,1,1,0,0,0,0,0, 0,1,6,6,1,1,1,1,1,1, 0,1,6,6,6,6,6,6,6,1, 1,1,6,1,6,1,3,2,6,1, 1,6,6,4,6,1,1,6,1,1,
     1,6,4,4,6,1,6,5,1,0, 1,1,1,6,6,6,4,6,1,0, 0,0,1,1,1,1,6,6,1,0, 0,0,0,0,0,1,1,1,1,0, 0,0,0,0,0,0,0,0,0,0},
       //9
    {0,0,1,1,1,1,1,0,0,0, 1,1,1,6,6,6,1,0,0,0, 1,6,6,6,1,6,1,1,0,0, 1,6,6,4,4,5,6,1,0,0, 1,1,6,4,6,2,4,1,1,0,
     0,1,6,1,6,1,6,6,1,0, 0,1,6,6,6,6,6,6,1,0, 0,1,1,1,6,6,1,1,1,0, 0,0,0,1,1,1,1,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       //10
    {0,1,1,1,1,1,1,1,0,0, 1,1,6,6,1,6,6,1,1,0, 1,6,3,2,4,2,3,6,1,0, 1,6,6,6,1,6,6,6,1,0, 1,1,6,6,4,6,6,1,1,0,
     0,1,5,6,4,6,6,1,0,0, 0,1,1,1,1,1,1,1,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
      //Nada
       //1
    {0,1,1,1,1,1,1,1,0,0, 0,1,6,6,6,6,6,1,0,0, 0,1,6,3,2,3,6,1,0,0, 1,1,6,2,5,2,6,1,0,0, 1,6,6,3,2,3,6,1,0,0,
     1,6,6,6,6,6,6,1,0,0, 1,1,1,1,1,1,1,1,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       //2
    {1,1,1,1,1,0,0,0,0,0, 1,5,6,6,1,1,0,0,0,0, 1,3,2,4,6,1,0,0,0,0, 1,6,6,1,6,1,0,0,0,0, 1,6,6,6,6,1,0,0,0,0,
     1,1,1,1,1,1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       //3
    {1,1,1,1,1,1,0,0,0,0, 1,6,6,6,6,1,0,0,0,0, 1,6,1,1,6,1,1,1,0,0, 1,6,3,2,5,3,1,1,1,0, 1,1,6,2,2,6,6,6,1,0, 
     0,1,6,6,1,3,6,6,1,0, 0,1,1,1,1,1,1,1,1,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       //4
    {0,1,1,1,1,1,1,1,1,1, 0,1,6,6,6,6,1,6,6,1, 1,1,6,2,1,2,1,6,6,1, 1,6,6,3,2,3,5,6,6,1, 1,6,6,3,1,6,6,6,6,1, 
     1,1,1,1,1,1,1,1,1,1, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       // 5
    {1,1,1,1,1,0,0,0,0,0, 1,6,6,6,1,1,0,0,0,0, 1,6,1,6,6,1,0,0,0,0, 1,5,2,4,3,1,1,0,0,0, 1,1,6,6,3,6,1,0,0,0, 
     0,1,6,2,1,6,1,0,0,0, 0,1,1,6,6,6,1,0,0,0, 0,0,1,1,1,1,1,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       //6
    {1,1,1,1,1,1,1,1,0,0, 1,1,5,6,3,1,1,1,0,0, 1,6,2,2,2,6,6,1,0,0, 1,6,1,3,6,6,6,1,0,0, 1,6,3,6,6,1,1,1,0,0, 
     1,1,1,1,1,1,1,1,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       //7
    {0,0,1,1,1,1,1,0,0,0, 0,0,1,5,6,6,1,0,0,0, 1,1,1,6,1,6,1,1,1,0, 1,6,6,3,2,4,2,6,1,0, 1,6,1,6,6,6,1,6,1,0, 
     1,6,6,3,1,6,6,6,1,0, 1,1,1,1,1,1,1,1,1,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       //8
    {0,1,1,1,1,0,0,0,0,0, 1,1,6,6,1,0,0,0,0,0, 1,5,2,6,1,0,0,0,0,0, 1,1,2,6,1,1,0,0,0,0, 1,1,6,2,6,1,0,0,0,0, 
     1,3,2,6,6,1,0,0,0,0, 1,3,3,4,3,1,0,0,0,0, 1,1,1,1,1,1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       //9
    {1,1,1,1,1,1,1,0,0,0, 1,3,3,2,3,3,1,0,0,0, 1,3,3,2,3,3,1,0,0,0, 1,6,2,2,2,6,1,0,0,0, 1,6,6,2,6,6,1,0,0,0, 
     1,6,2,2,2,6,1,0,0,0, 1,6,6,1,5,6,1,0,0,0, 1,1,1,1,1,1,1,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
       //10
    {0,0,0,1,1,1,1,1,1,0, 0,0,0,1,6,6,6,6,1,0, 0,0,0,1,6,1,1,5,1,1, 1,1,1,1,6,1,6,2,6,1, 1,6,3,3,6,1,6,2,6,1, 
     1,6,6,6,6,6,6,6,6,1, 1,6,6,1,1,1,1,1,1,1, 1,1,1,1,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0,},
       //abdullah
       //1
    {0,0,0,0,0,0,0,0,0,0, 0,0,0,1,1,1,0,0,0,0, 0,0,0,1,3,1,0,0,0,0, 0,0,0,1,6,1,1,1,1,0, 0,1,1,1,2,6,2,3,1,0, 
     0,1,3,6,2,5,1,1,1,0, 0,1,1,1,1,2,1,0,0,0, 0,0,0,0,1,3,1,0,0,0, 0,0,0,0,1,1,1,0,0,0, 0,0,0,0,0,0,0,0,0,0},   
       //2 
    {1,1,1,1,1,0,0,0,0,0, 1,5,6,6,1,0,0,0,0,0, 1,6,2,2,1,0,1,1,1,0, 1,6,2,6,1,0,1,3,1,0, 1,1,1,6,1,1,1,3,1,0, 
     0,1,1,6,6,6,6,3,1,0, 0,1,6,6,6,1,6,6,1,0, 0,1,6,6,6,1,1,1,1,0, 0,1,1,1,1,1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0}, 
       //3
    {0,0,0,0,0,0,0,0,0,0, 0,0,1,1,1,1,1,0,0,0, 0,0,1,5,6,1,1,1,0,0, 0,0,1,6,2,6,6,1,0,0, 0,1,1,1,6,1,6,1,1,0,
     0,1,3,1,6,1,6,6,1,0, 0,1,3,2,6,6,1,6,1,0, 0,1,3,6,6,6,2,6,1,0, 0,1,1,1,1,1,1,1,1,0, 0,0,0,0,0,0,0,0,0,0},  
       //4 
    {0,0,0,0,0,0,0,0,0,0, 0,0,0,1,1,1,1,0,0,0, 0,0,1,1,6,6,1,0,0,0, 0,0,1,5,2,6,1,0,0,0, 0,0,1,1,2,6,1,1,0,0, 
     0,0,1,1,6,2,6,1,0,0, 0,0,1,3,2,6,6,1,0,0, 0,0,1,3,3,1,3,1,0,0, 0,0,1,1,1,1,1,1,0,0, 0,0,0,0,0,0,0,0,0,0},  
       //5 
    {0,0,0,0,0,0,0,0,0,0, 0,0,0,1,1,1,1,0,0,0, 0,0,0,1,3,3,1,0,0,0, 0,0,1,1,6,3,1,1,0,0, 0,0,1,6,6,2,3,1,0,0,
     0,1,1,6,2,6,6,1,1,0, 0,1,6,6,1,2,2,6,1,0, 0,1,6,6,5,6,6,6,1,0, 0,1,1,1,1,1,1,1,1,0, 0,0,0,0,0,0,0,0,0,0}, 
       //6 
    {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 1,1,1,1,1,1,1,1,0,0, 1,3,3,3,3,3,3,1,0,0, 1,6,6,2,6,1,6,1,1,0, 
     1,6,2,6,1,6,2,6,1,0, 1,1,2,6,2,6,2,6,1,0, 0,1,6,6,5,6,6,6,1,0, 0,1,1,1,1,1,1,1,1,0, 0,0,0,0,0,0,0,0,0,0},  
       //7 
    {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,1,1,1,1,1,1,0,0,0, 0,1,6,6,6,6,1,0,0,0, 0,1,6,2,2,2,1,1,0,0, 
     0,1,6,6,1,3,3,1,1,1, 0,1,1,6,6,3,3,2,6,1, 0,0,1,6,5,6,6,6,6,1, 0,0,1,1,1,1,1,1,1,1, 0,0,0,0,0,0,0,0,0,0},  
      //8 
    {0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,1,1,1,1,1,1,0,0, 0,1,1,6,6,6,6,1,1,0, 0,1,6,2,6,2,2,6,1,0, 
     0,1,3,3,3,3,3,3,1,0, 0,1,6,2,2,6,2,6,1,0, 0,1,1,1,6,5,1,1,1,0, 0,0,0,1,1,1,1,0,0,0, 0,0,0,0,0,0,0,0,0,0},  
      //9
    {0,0,0,0,0,0,0,0,0,0, 0,0,0,1,1,1,1,1,0,0, 0,1,1,1,6,6,5,1,0,0, 0,1,6,6,2,3,6,1,1,0, 0,1,6,6,3,2,3,6,1,0, 
     0,1,1,1,6,1,2,6,1,0, 0,0,0,1,6,6,6,1,1,0, 0,0,0,1,1,1,1,1,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
      //10
    {0,0,0,0,0,0,0,0,0,0, 0,0,1,1,1,1,1,1,0,0, 0,0,1,6,6,6,6,1,1,1, 0,0,1,6,2,6,6,6,6,1, 1,1,1,6,2,6,1,1,6,1, 
     1,3,3,3,6,2,6,6,6,1, 1,3,3,3,2,1,2,6,1,1, 1,1,1,1,6,1,6,2,6,1, 0,0,0,1,6,6,5,6,6,1, 0,0,0,1,1,1,1,1,1,1},
     //esraa
     //1 
     {0,0,0,0,1,1,1,1,1,0, 0,0,0,1,1,6,6,6,1,1, 0,0,1,1,6,3,1,6,6,1, 0,1,1,6,6,6,5,6,6,1, 1,1,6,6,6,6,1,6,6,1, 
      1,6,6,2,6,1,1,1,1,1, 1,6,4,6,1,1,0,0,0,0, 1,6,6,1,1,0,0,0,0,0, 1,1,1,1,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
     //2
      {0,0,0,1,1,1,1,0,0,0, 1,1,1,1,6,6,1,0,0,0, 1,6,2,6,6,6,1,0,0,0, 1,6,6,3,1,6,1,1,0,0, 1,1,6,1,3,6,6,1,0,0, 
       1,6,5,6,6,2,6,1,0,0, 1,6,6,6,1,1,1,1,0,0, 1,1,1,1,1,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},    
     //3  
      {0,1,1,1,1,1,0,0,0,0, 0,1,6,6,6,1,1,0,0,0, 1,1,3,1,2,6,1,1,0,0, 1,6,2,6,6,6,6,1,0,0, 1,3,6,3,1,2,6,1,0,0, 
       1,1,1,6,5,6,1,1,0,0, 0,0,1,6,1,6,1,0,0,0, 0,0,1,6,6,6,1,0,0,0, 0,0,1,1,1,1,1,0,0,0, 0,0,0,0,0,0,0,0,0,0}, 
     //4      
      {0,1,1,1,1,1,1,1,0,0, 0,1,6,6,1,6,6,1,1,0, 1,1,6,4,4,2,3,6,1,0, 1,6,6,6,1,6,6,6,1,0, 1,6,6,6,5,6,1,1,1,0, 
       1,6,6,1,1,1,1,0,0,0, 1,1,1,1,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
     //5 
      {0,0,0,0,0,0,1,1,1,1, 1,1,1,1,1,1,1,6,6,1, 1,6,6,6,6,6,6,6,6,1, 1,6,6,2,6,1,3,1,6,1, 1,6,2,2,1,1,6,1,6,1, 
       1,1,1,6,3,6,5,6,6,1, 0,0,1,1,1,6,6,1,6,1, 0,0,0,0,1,1,3,6,6,1, 0,0,0,0,0,1,1,1,1,1, 0,0,0,0,0,0,0,0,0,0},
     //6 
      {0,0,1,1,1,1,0,0,0,0, 0,1,1,6,6,1,0,0,0,0, 1,1,6,3,6,1,1,0,0,0, 1,5,2,2,2,6,1,0,0,0, 1,3,6,3,1,6,1,0,0,0,
       1,6,1,6,6,6,1,0,0,0, 1,6,6,6,1,1,1,0,0,0, 1,1,1,1,1,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},      
     //7 
      {0,0,0,0,1,1,1,1,0,0, 0,0,0,0,1,5,6,1,0,0, 1,1,1,1,1,6,3,1,0,0, 1,6,2,6,2,6,2,1,0,0, 1,6,6,6,3,6,6,1,0,0,
       1,1,1,6,3,6,6,1,0,0, 0,0,1,1,1,1,1,1,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
     //8   
      {0,0,1,1,1,1,0,0,0,0, 0,1,1,6,6,1,0,0,0,0, 1,1,6,6,6,1,1,0,0,0, 1,6,6,4,2,6,1,0,0,0, 1,6,1,6,1,5,1,0,0,0,
       1,6,6,4,3,6,1,0,0,0, 1,1,1,6,6,1,1,0,0,0, 0,0,1,6,6,1,0,0,0,0, 0,0,1,1,1,1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
     //9     
      {0,0,0,1,1,1,1,1,0,0, 0,0,0,1,6,5,6,1,0,0, 0,1,1,1,6,6,6,1,0,0, 0,1,6,2,6,2,1,1,0,0, 1,1,6,2,6,6,1,0,0,0,
       1,3,6,6,1,6,1,0,0,0, 1,3,3,6,6,6,1,0,0,0, 1,1,1,1,1,1,1,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},           
     //10     
      {1,1,1,1,1,1,0,0,0,0, 1,6,6,6,5,1,0,0,0,0, 1,6,2,2,1,1,1,1,0,0, 1,6,2,6,3,6,6,1,0,0, 1,1,6,1,3,1,6,1,0,0,
       1,3,6,6,6,1,6,1,0,0, 1,6,6,6,6,6,6,1,0,0, 1,1,1,1,1,1,1,1,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0} ,
     //menna
     //1
      {0,0,1,1,1,1,1,0,0,0, 1,1,1,6,6,6,1,0,0,0, 1,6,2,6,1,6,1,1,0,0, 1,6,1,6,6,3,6,1,0,0, 1,6,6,6,6,1,6,1,0,0, 
       1,1,2,1,3,6,6,1,0,0, 0,1,5,6,6,1,1,1,0,0, 0,1,1,1,1,1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
     //2
      {0,0,0,0,1,1,1,1,0,0, 1,1,1,1,1,6,6,1,0,0, 1,6,6,6,2,6,6,1,0,0, 1,6,6,3,1,6,6,1,0,0, 1,1,6,1,1,6,1,1,0,0,
       1,6,6,6,6,6,6,1,0,0, 1,6,5,1,6,6,6,1,0,0, 1,6,6,1,1,1,1,1,0,0, 1,1,1,1,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
     //3
      {0,1,1,1,1,1,0,0,0,0, 1,1,6,6,6,1,1,1,0,0, 1,6,3,6,3,6,6,1,0,0, 1,6,1,6,1,1,6,1,1,0, 1,6,6,6,6,2,2,5,1,0,
       1,1,1,6,1,6,6,6,1,0, 0,0,1,6,6,6,1,1,1,0, 0,0,1,1,1,1,1,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
     //4
      {0,1,1,1,1,1,0,0,0,0, 0,1,6,6,6,1,0,0,0,0, 1,1,2,1,6,1,1,1,0,0, 1,6,6,6,2,5,6,1,0,0, 1,6,1,6,6,1,6,1,0,0, 
       1,6,1,3,6,3,6,1,0,0, 1,6,6,6,1,1,1,1,0,0, 1,1,1,1,1,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
     //5
      {0,0,0,0,1,1,1,1,0,0, 0,1,1,1,1,6,6,1,0,0, 1,1,6,2,6,6,6,1,0,0, 1,6,6,1,6,1,2,1,0,0, 1,3,5,3,6,6,6,1,1,0,
       1,1,6,1,6,1,6,6,1,0, 0,1,6,6,6,6,6,6,1,0, 0,1,6,6,1,1,1,1,1,0, 0,1,1,1,1,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
     //6 
       {0,1,1,1,1,1,0,0,0,0, 1,1,6,6,6,1,1,1,0,0, 1,6,3,6,3,6,3,1,0,0, 1,6,1,6,1,1,6,1,1,0, 1,6,6,6,6,2,2,5,1,0,
        1,1,1,6,1,6,2,6,1,0, 0,0,1,6,6,6,1,1,1,0, 0,0,1,1,1,1,1,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
     //7           
       {1,1,1,1,0,0,0,0,0,0, 1,6,6,1,1,1,1,0,0,0, 1,6,6,6,6,6,1,0,0,0, 1,6,6,6,6,6,1,0,0,0, 1,1,1,6,1,1,1,0,0,0, 
        1,6,2,2,2,6,1,1,0,0, 1,6,3,3,3,5,6,1,0,0, 1,1,1,1,6,6,6,1,0,0, 0,0,0,1,1,1,1,1,0,0, 0,0,0,0,0,0,0,0,0,0},
     //8
        {1,1,1,1,1,1,1,1,0,0, 1,6,6,6,1,6,6,1,0,0, 1,6,6,6,6,6,6,1,0,0, 1,1,6,1,3,6,6,1,0,0, 1,6,6,6,6,1,1,1,0,0,
         1,6,1,6,3,6,1,0,0,0, 1,6,2,2,1,6,1,0,0,0, 1,1,1,6,6,5,1,0,0,0, 0,0,1,1,1,1,1,0,0,0, 0,0,0,0,0,0,0,0,0,0},
     //9
        {1,1,1,1,1,0,0,0,0,0, 1,5,6,6,1,1,1,0,0,0, 1,6,2,2,2,6,1,0,0,0, 1,1,6,3,3,3,1,0,0,0, 1,6,6,6,1,6,1,0,0,0,
         1,6,6,6,6,6,1,0,0,0, 1,1,1,1,1,1,1,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
     //10
        {1,1,1,1,1,1,0,0,0,0, 1,5,6,6,3,1,0,0,0,0, 1,2,2,2,6,1,0,0,0,0, 1,3,6,1,6,1,0,0,0,0, 1,6,6,3,6,1,0,0,0,0,
         1,1,1,1,1,1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
     //salma
      //1
        {0,1,1,1,1,1,1,0,0,0, 1,1,6,6,3,6,1,0,0,0, 1,6,4,6,1,6,1,0,0,0, 1,6,3,2,6,6,1,0,0,0, 1,6,6,1,2,1,1,0,0,0,
         1,1,6,5,6,1,0,0,0,0, 0,1,1,1,1,1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
      //2
        {1,1,1,1,1,1,1,0,0,0, 1,6,6,3,5,6,1,0,0,0, 1,6,1,3,1,6,1,0,0,0, 1,6,6,6,2,6,1,0,0,0, 1,3,2,2,6,1,1,0,0,0,
         1,6,6,1,1,1,0,0,0,0, 1,1,1,1,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},      
      // 3 
        {0,0,0,1,1,1,1,0,0,0, 1,1,1,1,6,5,1,0,0,0, 1,6,6,4,2,6,1,0,0,0, 1,6,6,6,6,6,1,0,0,0, 1,1,6,3,1,1,1,0,0,0, 
         0,1,2,6,1,0,0,0,0,0, 0,1,6,3,1,0,0,0,0,0, 0,1,1,1,1,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
      //4 
        {1,1,1,0,1,1,1,0,0,0, 1,3,1,1,1,3,1,0,0,0, 1,6,1,6,6,3,1,0,0,0, 1,6,2,2,6,5,1,0,0,0, 1,6,6,2,6,6,1,0,0,0,
         1,6,6,1,6,6,1,0,0,0, 1,6,6,1,1,1,1,0,0,0, 1,1,1,1,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},     
      //5
        {0,0,0,1,1,1,1,0,0,0, 0,0,0,1,6,5,1,1,0,0, 1,1,1,1,6,6,6,1,0,0, 1,3,6,1,2,2,6,1,0,0, 1,6,6,6,6,6,1,1,0,0,
         1,3,6,6,2,1,1,0,0,0, 1,1,3,6,6,1,0,0,0,0, 0,1,1,1,1,1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},   
      //6
        {1,1,1,1,1,0,0,0,0,0, 1,6,3,3,1,1,1,1,0,0, 1,6,2,6,6,6,6,1,0,0, 1,6,6,1,2,1,6,1,0,0, 1,6,5,6,3,2,6,1,0,0,
         1,1,1,1,1,1,1,1,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
      //7
        {1,1,1,1,1,1,1,0,0,0, 1,3,6,6,5,3,1,0,0,0, 1,6,6,2,1,6,1,1,0,0, 1,6,1,6,2,3,6,1,0,0, 1,6,6,6,2,1,6,1,0,0,
         1,1,1,1,6,6,6,1,0,0, 0,0,0,1,1,1,1,1,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},   
      //8 
        {1,1,1,1,1,0,0,0,0,0, 1,3,6,3,1,1,1,0,0,0, 1,3,1,2,2,6,1,0,0,0, 1,6,6,6,5,6,1,0,0,0, 1,6,2,1,6,6,1,0,0,0,
         1,1,6,6,6,1,1,0,0,0, 0,1,1,1,1,1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
         
      //9
        {1,1,1,1,1,0,0,0,0,0, 1,3,6,6,1,1,1,0,0,0, 1,6,1,6,6,6,1,0,0,0, 1,6,3,6,1,6,1,0,0,0, 1,6,2,4,2,6,1,0,0,0,
         1,1,5,6,1,1,1,0,0,0, 0,1,6,6,1,0,0,0,0,0, 0,1,1,1,1,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0},
         
      //10  
        {1,1,1,1,0,0,0,0,0,0, 1,6,6,1,0,0,0,0,0,0, 1,6,6,1,1,1,1,1,0,0, 1,6,3,4,6,6,6,1,0,0, 1,1,2,6,6,6,6,1,0,0,
         0,1,6,1,2,1,1,1,0,0, 0,1,3,6,5,1,0,0,0,0, 0,1,1,1,1,1,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0}
           
            }
           ;
     Image block,box,ground,point,box2;
     static boolean first=false;
     public static int ex_player_i,ex_player_j,_c=0;
     int map_size_x;
     int map_size_y;
     ImageIcon block_, box_,ground_,point_,box2_;

    public level() {
        
        block_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\Wall_Brown.png");
        box_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\CrateDark_Beige.png");
        ground_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\GroundGravel_Sand.png");
        point_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\EndPoint_Yellow.png");
        box2_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\Crate_Yellow.png");
       // System.out.println(wall_number+" wwwwwwwwwwwww");
        
       
        
        
        

       block=block_.getImage();
        box=box_.getImage();
        ground =ground_.getImage();
        point=point_.getImage();
        box2=box2_.getImage();
        block_x=0;
        block_y=0;
        
        /* b1.setBackground(Color.red);
         b1.setSize(200, 200);
          b1.setForeground(new java.awt.Color(255, 255, 255));
       */
         
    }
   
   public void change_design()
   {
       if(wall_number==1)
        {
            block_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\Wall_Beige.png");
        }
        else if(wall_number==2)
        {
           block_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\Wall_Black.png");
        }
        else if(wall_number==3)
        {
            block_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\Wall_Brown.png");
        }
        else if(wall_number==4)
        {
           block_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\Wall_Gray.png");
        }
        else 
        {
            
        }
       if (box_number==1)
        {
            box_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\Crate_Blue.png");
        }
        if (box_number==2)
        {
            box_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\CrateDark_Beige.png");
        }
        if (box_number==3)
        {
            box_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\CrateDark_Black.png");
        }
        if (box_number==4)
        {
            box_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\Crate_Gray.png");
        }
        if (box_number==5)
        {
            box_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\Crate_Red.png");
        }
        if (box_number==6)
        {
            box_ =new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\Crate_Purple.png");
        }
       block=block_.getImage();
       box=box_.getImage();
   }
    public void change_Background()
     {
         if (bg_number==1)
         {
             i=new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\gl.jpg");
         }
         if (bg_number==2)
         {
             i=new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\golden.jpg");
         }
         if (bg_number==3)
         {
             i=new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\blue.jpg");
         }
         if (bg_number==4)
         {
             i=new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\grey.jpg");
         }
         if (bg_number==5)
         {
             i=new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\pla.jpg");   
         }
         if (bg_number==6)
         {
             i=new ImageIcon("C:\\Users\\abdelrhman\\Desktop\\sokoban_5 (1)\\sokoban_5\\src\\sokoban\\g.jpg");
         }
          bg=i.getImage();
     }
    public  void display_level(int number)
    {
       int map_counter=0;
        for(int i=0;i<10;++i)
        {
            for(int j=0;j<10;++j)
            {
              
                map[i][j]=maps[number-1][map_counter];
                map_counter++;
            }
        }
         block_x=set_blocks_x();
        block_y=set_blocks_y();
        map_counter=0;
      Sokoban.moves=0;
        Sokoban.pushes =0;
    }
    int calculate_size_x()
    {
        boolean calc=true;
        int size_x=0;
        int max_size_x=0;
        for(int i=0;i<10;++i)
        {
            for(int j=0;j<10;++j)
            {
              if (map[i][j]==0&&calc==true)
              {
                  size_x++;
              }
              if (map[i][j]!=0)
              {
                  size_x++;
                  calc=false;
              }
      
            }
            if (size_x>max_size_x)
                max_size_x=size_x;
            size_x=0;
                
        }
        return max_size_x;
    }
    int calculate_size_y()
    {
        boolean calc=true;
        int size_y=0;
        int max_size_y=0;
        for(int i=0;i<10;++i)
        {
            for(int j=0;j<10;++j)
            {
              if (map[j][i]==0&&calc==true)
              {
                  size_y++;
              }
              if (map[j][i]!=0)
              {
                  size_y++;
                  calc=false;
              }
      
            }
            if (size_y>max_size_y)
                max_size_y=size_y;
            size_y=0;
                
        }
        return max_size_y;
    }
    int set_blocks_x()
    {
        int size_x=calculate_size_x()*65; 
        size_x=800-size_x;
        size_x=size_x/2;
       // System.out.println(size_x);
        return size_x;
    }
    int set_blocks_y()
    {
        int size_y=calculate_size_y()*65;
        size_y=800-size_y;
        size_y=size_y/2;
       // System.out.println(size_y);
        return size_y;
    }
       @Override
       void paint(Graphics g)
     {
         
         for(int i=0;i<10;++i)
        {
            for(int j=0;j<10;++j)
            {
               
                 if(map[i][j]==6)
                {
                    g.drawImage(ground, block_x, block_y, null);
                    
                }
                if(map[i][j]==1)
                {
                    g.drawImage(block, block_x, block_y, null);
                    
                }
                if(map[i][j]==2)
                {
                    g.drawImage(ground, block_x, block_y, null);
                    g.drawImage(box, block_x, block_y, null);
                 
                }
                 if(map[i][j]==3)
                {
                     g.drawImage(ground, block_x, block_y, null);
                    g.drawImage(point, block_x+15, block_y+15, null);
                 
                }
                 if(map[i][j]==4)
                {
                    g.drawImage(ground, block_x, block_y, null);
                    g.drawImage(box2, block_x, block_y, null);
                 
                }
                 if(map[i][j]==5)
                {
                    
                    g.drawImage(ground, block_x, block_y, null);
                 
                }
                 if(map[i][j]==5&&first==false)
                {
                     if (c instanceof character1) {
                         player_x=block_x+10;
                         player_y=block_y;
                    }
                     else
                     {
                     player_x=block_x+15;
                    player_y=block_y+15;
                     }
                   
                    player_i=i;
                    player_j=j;
                    ex_player_i=i;
                    ex_player_j=j;
                    g.drawImage(down.get(0), block_x, block_y, null);
                    first=true;
                    
                 
                }
                 
                 if (move==true&&_c==0)
                 {
                     
                     map[ex_player_i][ex_player_j]=6;
                     _c++;
                 }
                 
               
                block_x=block_x+65;
                
            }
            block_x=set_blocks_x();
            block_y=block_y+65;
        }
        block_x=set_blocks_x();
       block_y=set_blocks_y();
       
     }
}
