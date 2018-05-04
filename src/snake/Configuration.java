/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author alu20909379x
 */
public class Configuration {
    //atributos board
    public static Timer timer;
    public static Board.MyKeyAdapter myKeyAdepter;
    public static ScoreBoard scoreBoard;
    public static Cover cover;
    public static JFrame parentFrame;
    public static int deltaTime;
    public static Food food;
    public static Snake snake;
    public static SpecialFood specialFood;
    public static int countFoods;
    //atributos cover
    public static boolean modeHard;
    public static boolean modeNormal;
    public static boolean isSelected;
    //atributos food
    public static Node nodeFood;
    //atributos GameOver
    public static ScoreBoard b;
    //atributos Node
    public static int row;
    public static int col;
    public static Color color;
    //atributos RecordsDialogs
    public static final String RECORDS_FILE_NAME_HARD = "recordsHard.txt";
    public static final String RECORDS_FILE_NAME_NORMAL = "recordsNormal.txt";
    public static int score;
    public static JLabel[] recordLabels;
    public static int minRecord;
    //public static ArrayList<RecordsDialog.Record> listOfRecords;
    //public static Cover cover;
    
    //atributos ScoreBoard
     //public static int score;
    public static int level;
    //atributos Snake
    public static ArrayList<Node> listNodes;
    public static DireccionType direccion;
    public static int countGrowSnake;
    //atributos special food
     public static int visibleTimer;
    public static Timer time;
    public static Board board;
}
