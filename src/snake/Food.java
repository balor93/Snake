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

    public Node nodeFood;

    public Food(Snake snake) {

        nodeFood = new Node(getRandomRow(), getRandomCol(), Color.orange);
        while (checkRowColSnake(snake)) {
            nodeFood = new Node(getRandomRow(), getRandomCol(), Color.orange);
        }

    }

    public void drawFood(Graphics g, int squareWidth, int squareHeight) {
        Util.drawSquare(g, nodeFood, squareWidth, squareHeight);
        

    }

    public int getRandomRow() {
        return (int) (Math.random() * ConfigSingleton.getInstance().NUM_ROWS);
    }

    public int getRandomCol() {

        return (int) (Math.random() * ConfigSingleton.getInstance().NUM_COLS);
    }

    public boolean checkRowColSnake(Snake snake) {

        boolean check = false;
        for (Node n : snake.listNodes) {
            if (n.row == nodeFood.row && n.col == nodeFood.col) {
                return true;
            }
        }
        return check;

    }

    public int getRow() {
        return nodeFood.row;
    }

    public int getCol() {
        return nodeFood.col;
    }

}
