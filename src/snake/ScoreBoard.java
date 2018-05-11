/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import javax.swing.JLabel;

/**
 *
 * @author alu20909379x
 */
public class ScoreBoard extends JLabel {

    
    private int level;

    public ScoreBoard() {
        super(); //inicializamos la superclase
        ConfigSingleton.getInstance().setScore(0);
        level=0;
    }

    public void increment(int points) {
        int score = ConfigSingleton.getInstance().getScore();
        score += points;
         ConfigSingleton.getInstance().setScore(score);
        if (ConfigSingleton.getInstance().getScore() % 5 == 0 ){
        level++;
        }
        setText("Level:"+ level+ " Score:" + ConfigSingleton.getInstance().getScore());
    }

    public void reset() {
       ConfigSingleton.getInstance().setScore(0);
        level=0;
        setText("Level:"+ level+ " Score:" + ConfigSingleton.getInstance().getScore());
    }

    public void pause() {
        setText("Paused");
    }

   

    public void printScore() {
        setText("Level:"+ level+ " Score:" + ConfigSingleton.getInstance().getScore());
    }

    public String endScore() {
        return "Level:"+ getLevel()+ " Score : " + ConfigSingleton.getInstance().getScore();
    }
    public int getLevel() {
        return level;
    }
}
