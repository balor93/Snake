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
public class Board extends JPanel implements ActionListener{

    class MyKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if(snake.getDireccion()!=DireccionType.RIGHT){
                        snake.setDireccion(DireccionType.LEFT);
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                     if(snake.getDireccion()!=DireccionType.LEFT){
                        snake.setDireccion(DireccionType.RIGHT);
                     }
                    break;
                case KeyEvent.VK_UP:
                     if(snake.getDireccion()!=DireccionType.DOWN){
                        snake.setDireccion(DireccionType.UP);
                     }
                    break;
                case KeyEvent.VK_DOWN:
                     if(snake.getDireccion()!=DireccionType.UP){
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
    private JFrame parentFrame;
    private int deltaTime;
    private Food food;    
    private Snake snake;

    public Board() {
        
        super();
        
        myKeyAdepter = new MyKeyAdapter();
        deltaTime = 500;
        timer = new Timer(deltaTime, this);
        setFocusable(true);
        requestFocusInWindow();
        snake=new Snake();
    }
    
    public void initGame(){
       
        timer.start();
       snake=new Snake();
       food=new Food(snake);
       // scoreBoard.reset();
        removeKeyListener(myKeyAdepter);
        addKeyListener(myKeyAdepter);
        
    
    }
    
    
    
    
    
    
    
    
    public void setParentFrame(JFrame parentFrame) {
        this.parentFrame = parentFrame;
    }
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Toolkit.getDefaultToolkit().sync();
        if(!snake.hitWall()){
           if(eat()){
                snake.move(true); 
                food= new Food(snake);
           }else{
                snake.move(false); 
           }
         
        repaint();
        
       }else{
           gameOver();
       }
       
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(snake!=null){
        snake.drawSnake(g, squareWidth(), squareHeight());
        }
         if(food!=null ){
        food.drawFood(g, squareWidth(), squareHeight());
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
        

    }
     
    public boolean eat(){
        if(snake.getHeadSnake().col== food.getCol() && snake.getHeadSnake().row == food.getRow()){
            return true;
        }else{
            return false;
        }
        
    }
    
    
    
}
