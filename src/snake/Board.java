/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

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
                    
                    break;
                case KeyEvent.VK_RIGHT:
                    
                    break;
                case KeyEvent.VK_UP:
                   

                    break;
                case KeyEvent.VK_DOWN:
                    
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
    
    
    
    
    
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
