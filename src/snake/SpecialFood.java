/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author alu20909379x
 */
public class SpecialFood extends Food implements ActionListener {

    private int visibleTimer;
    private Timer time;
    private Board board;

    public SpecialFood(Snake snake, Board board) {
        super(snake);
        visibleTimer = getTimeVisible();
        time = new Timer(visibleTimer, this);
        this.board = board;
        nodeFood.color = Color.BLUE;
        time.start();
    }

    public int getTimeVisible() {
        return (int) (Math.random() * 10 + 5) * 1000;
    }

    

    @Override
    public void actionPerformed(ActionEvent al) {
        board.removeSpecialFood();
        time.stop();
    }

}
