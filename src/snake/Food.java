/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author alu20909379x
 */
public class Food {
    private Node nodeFood;

    
    
    public Food(Snake snake){
        
       nodeFood=new Node(getRandomRow(), getRandomCol(), Color.green);
       while(checkRowColSnake(snake)){
        nodeFood=new Node(getRandomRow(), getRandomCol(), Color.green);
        }
        
        
    }
    
    public void drawFood(Graphics g , int squareWidth, int squareHeight) {
             Util.drawSquare(g, nodeFood , squareWidth, squareHeight);
         
    }
    
    public int getRandomRow(){
        return (int) (Math.random() * Board.NUM_ROWS);
    }
    
    public int getRandomCol(){
    
        return (int) (Math.random() * Board.NUM_COLS);
    }
    
     public boolean checkRowColSnake(Snake snake) {
          
         boolean check=true;
          for(Node n : snake.listNodes){
             if(n.row==getRandomRow() && n.col==getRandomCol()){
                 return true;
             }else{
                 check= false;
             }
         }
          return check;
        
         
    }
     public int getRow(){
         return nodeFood.row;
     }
     public int getCol(){
         return nodeFood.col;
     }
    
    
    
    
    
    
}
