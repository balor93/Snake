package snake;


import java.awt.Color;
import java.awt.Graphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alu20909379x
 */
public class Util {
    
    
     public static void drawSquare(Graphics g, Node nodo, int squareWidth, int squareHeight) {
       

        int x = nodo.col * squareWidth;
        int y = nodo.row * squareHeight;
        
        g.setColor(nodo.color);
        g.fillRect(x + 1, y + 1, squareWidth - 2, squareHeight - 2);
        g.setColor(nodo.color.brighter());
        g.drawLine(x, y + squareHeight - 1, x, y);
        g.drawLine(x, y, x + squareWidth - 1, y);
        g.setColor(nodo.color.darker());
        g.drawLine(x + 1, y + squareHeight - 1, x + squareWidth - 1, y + squareHeight  - 1);
        g.drawLine(x + squareWidth  - 1, y + squareHeight  - 1, x + squareWidth  - 1, y + 1);
    }
    
}
