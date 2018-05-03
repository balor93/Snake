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

    private int score;
    private int level;

    public ScoreBoard() {
        super(); //inicializamos la superclase
        score = 0;
        level=0;
    }

    public void increment(int points) {
        score += points;
        if (getScore() % 5 == 0 ){
        level++;
        }
        setText("Level:"+ level+ " Score:" + score);
    }

    public void reset() {
        score = 0;
        level=0;
        setText("Level:"+ level+ " Score:" + score);
    }

    public void pause() {
        setText("Paused");
    }

    public int getScore() {
        return score;
    }

    public void printScore() {
        setText("Level:"+ level+ " Score:" + score);
    }

    public String endScore() {
        return "Level:"+ getLevel()+ " Score : " + getScore();
    }
    public int getLevel() {
        return level;
    }
}
