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

    private Timer timer;
    private MyKeyAdapter myKeyAdepter;
    public ScoreBoard scoreBoard;
    public Cover cover;
    private JFrame parentFrame;
    private Personalized personalized;
    private NormalFood normalFood;
    private Snake snake;
    private SpecialFood specialFood;
    private FactoryFood factoryFood;

    public Board() {

        super();

        myKeyAdepter = new MyKeyAdapter();

        timer = new Timer(ConfigSingleton.getInstance().getDeltaTime(), this);
        
        setFocusable(true);
        requestFocusInWindow();
        snake = new Snake();

    }

    public void initGame() {

        if (ConfigSingleton.getInstance().isModeHard()) {
            modeHard();
        }
        if (ConfigSingleton.getInstance().isModeNormal()) {
            modeNormal();
        }
        if (timer != null) {
            timer.stop();
        }
        timer = new Timer(ConfigSingleton.getInstance().getDeltaTime(), this);
        scoreBoard.reset();
        ConfigSingleton.getInstance().setNumNormalFood(0);
        timer.start();
        snake = new Snake();
        factoryFood = new FactoryFood(this, snake);
        buildFood();
        removeKeyListener(myKeyAdepter);
        addKeyListener(myKeyAdepter);

    }

    public void buildFood() {
        Food food = factoryFood.createFood();
        if (food instanceof NormalFood) {
            normalFood = (NormalFood) food;
        } else {
            specialFood = (SpecialFood) food;
        }

    }

    public void modeHard() {
        ConfigSingleton.getInstance().setDeltaTime(100);

    }

    public void modeNormal() {
        ConfigSingleton.getInstance().setDeltaTime(200);

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
        if (ConfigSingleton.getInstance().getScore() % 5 == 0 && ConfigSingleton.getInstance().getDeltaTime() != 0) {

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
                
                normalFood = null;
                buildFood();
                /*if(specialFood==null){
                    buildFood();
                }*/

                if (incrementLevels()) {
                    ConfigSingleton.getInstance().setDeltaTime(ConfigSingleton.getInstance().getDeltaTime() - 20);
                    timer.setDelay(ConfigSingleton.getInstance().getDeltaTime());
                }

            } else {
                if (eatSpecialFood()) {
                    int grow = specialFood.getRamdomGrowSnake();
                    snake.setCountGrowSnake(grow);
                    scoreBoard.increment(grow);
                    removeSpecialFood();
                    

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
        if (normalFood != null) {
            normalFood.drawFood(g, squareWidth(), squareHeight());
        }

        if (specialFood != null) {
            specialFood.drawFood(g, squareWidth(), squareHeight());
        }

        if (snake != null) {
            snake.drawSnake(g, squareWidth(), squareHeight());
        }

    }

    private int squareWidth() {
        return getWidth() / ConfigSingleton.getInstance().getNum_cols();
    }

    private int squareHeight() {
        return getHeight() / ConfigSingleton.getInstance().getNum_rows();
    }

    public void gameOver() {
        scoreBoard.setText("game over");
        removeKeyListener(myKeyAdepter);
        timer.stop();
        GameOver d = new GameOver(parentFrame, true, scoreBoard);
        d.setVisible(true);
        RecordsDialog r = new RecordsDialog(parentFrame, true, ConfigSingleton.getInstance().getScore(), Game.getC());
        r.setVisible(true);

    }

    public boolean eat() {
        if (normalFood != null) {
            if (snake.getHeadSnake().col == normalFood.getCol() && snake.getHeadSnake().row == normalFood.getRow()) {
                return true;
            }
        }
        return false;

    }

    public boolean eatSpecialFood() {
        if (specialFood != null) {
            if (snake.getHeadSnake().col == specialFood.getCol() && snake.getHeadSnake().row == specialFood.getRow()) {
                return true;
            }
        }
        return false;
    }

    public void drawBorder(Graphics g) {
        g.setColor(Color.black);
        g.drawRect(0, 0, ConfigSingleton.getInstance().getNum_cols() * squareWidth(), ConfigSingleton.getInstance().getNum_rows() * squareHeight());
    }

    public void removeSpecialFood() {
        specialFood = null;
        buildFood();
    }

}
