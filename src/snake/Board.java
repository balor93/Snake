/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author alu20909379x
 */
public class Board extends JPanel implements ActionListener {

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (snake.getDireccion() != DireccionType.RIGHT) {
                        snake.setDireccion(DireccionType.LEFT);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (snake.getDireccion() != DireccionType.LEFT) {
                        snake.setDireccion(DireccionType.RIGHT);
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (snake.getDireccion() != DireccionType.DOWN) {
                        snake.setDireccion(DireccionType.UP);
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (snake.getDireccion() != DireccionType.UP) {
                        snake.setDireccion(DireccionType.DOWN);
                    }
                    break;
                case KeyEvent.VK_P:
                    if (!timer.isRunning()) {
                        scoreBoard.printScore();
                        timer.start();

                    } else {
                        timer.stop();
                        scoreBoard.pause();

                    }
                    break;
                default:

                    break;
            }

            repaint();
        }

    }

    public static final int NUM_ROWS = 25;
    public static final int NUM_COLS = 25;
    private Timer timer;
    private MyKeyAdapter myKeyAdepter;
    public ScoreBoard scoreBoard;
    public Cover cover;
    private JFrame parentFrame;
    private int deltaTime;
    private Food food;
    private Snake snake;
    private SpecialFood specialFood;
    private int countFoods;

    public Board() {

        super();

        myKeyAdepter = new MyKeyAdapter();
        deltaTime = 200;
        timer = new Timer(deltaTime, this);
        setFocusable(true);
        requestFocusInWindow();
        snake = new Snake();
        countFoods = 0;
        
    }

    public void initGame() {
        if(cover.isModeHard()){
        modeHard();
        }
        if(cover.isModeNormal()){
        modeNormal();
        }
        timer.start();
        snake = new Snake();
        food = new Food(snake);
        scoreBoard.reset();
        removeKeyListener(myKeyAdepter);
        addKeyListener(myKeyAdepter);

    }
    
    
    
    public void modeHard(){
        deltaTime = 100;
        timer = new Timer(deltaTime, this);
    }
     public void modeNormal(){
        deltaTime = 200;
        timer = new Timer(deltaTime, this);
    }

    public void setScoreBoard(ScoreBoard scoreBoard) {
        this.scoreBoard = scoreBoard;
    }
    
    public void setCover(Cover cover) {
        this.cover = cover;
    }

    public void setParentFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }

    public boolean incrementLevels() {
        if (scoreBoard.getScore() % 5 == 0 && deltaTime!=0) {

            return true;
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (!snake.hitWall() && !snake.hitSnake()) {
            if (eat()) {
                snake.setCountGrowSnake(1);
                scoreBoard.increment(1);
                countFoods++;
                if (countFoods == 5) {
                    specialFood = new SpecialFood(snake, this);
                    countFoods = 0;
                }

                if (incrementLevels()) {
                    deltaTime = deltaTime - 20;
                    timer.setDelay(deltaTime);
                }
                food = new Food(snake);
            } else {
                if (eatSpecialFood()) {
                    snake.setCountGrowSnake(3);
                    scoreBoard.increment(3);
                    specialFood=null;

                }

            }
            snake.move();
            repaint();
            Toolkit.getDefaultToolkit().sync();

        } else {
            gameOver();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBorder(g);
        if (food != null) {
            food.drawFood(g, squareWidth(), squareHeight());
        }

        if (specialFood != null) {
            specialFood.drawFood(g, squareWidth(), squareHeight());
        }

        if (snake != null) {
            snake.drawSnake(g, squareWidth(), squareHeight());
        }

    }

    private int squareWidth() {
        return getWidth() / NUM_COLS;
    }

    private int squareHeight() {
        return getHeight() / NUM_ROWS;
    }

    public void gameOver() {
        scoreBoard.setText("game over");
        removeKeyListener(myKeyAdepter);
        timer.stop();
        GameOver d = new GameOver(parentFrame, true, scoreBoard);
        d.setVisible(true);
        RecordsDialog r = new RecordsDialog(parentFrame, true, scoreBoard.getScore(), cover );
        r.setVisible(true);

    }

    public boolean eat() {
        if (snake.getHeadSnake().col == food.getCol() && snake.getHeadSnake().row == food.getRow()) {
            return true;
        } else {
            return false;
        }

    }

    public boolean eatSpecialFood() {
        if(specialFood!=null){
            if (snake.getHeadSnake().col == specialFood.getCol() && snake.getHeadSnake().row == specialFood.getRow()) {
                return true;
             } 
         }
        return false;
    }

    public void drawBorder(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(0, 0, NUM_COLS * squareWidth(), NUM_ROWS * squareHeight());
    }

    public void removeSpecialFood() {
        specialFood = null;
    }

}
