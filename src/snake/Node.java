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
public class Node {

    public int row;
    public int col;
    public Color color;

    public Node(int row, int col, Color color) {
        this.row = row;
        this.col = col;
        this.color = color;
    }
    
    public int getFirstRow(){
        return 0;
    }
    
     public int getFirstCol(){
        return 0;
    }
    
     public int getLastRow(){
        return ConfigSingleton.getInstance().getNum_rows();
    }
     
    public int getLastCol(){
        return ConfigSingleton.getInstance().getNum_cols();
    }

}
