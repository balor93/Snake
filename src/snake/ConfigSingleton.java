/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author alu20909379x
 */
public class ConfigSingleton implements Serializable{

    private static ConfigSingleton instance = null;

    private int score;
    private boolean modeHard;
    private boolean modeNormal;
    private boolean withoutWalls;
    private boolean personalized;

    public static final int NUM_ROWS = 25;
    public static final int NUM_COLS = 25;
    private int num_rows;
    private int num_cols;
    private int deltaTime;
    private int numNormalFood;

    private ConfigSingleton() {
        score = 0;
        modeHard = false;
        modeNormal = false;
        withoutWalls = false;
        num_cols = NUM_COLS;
        num_rows = NUM_ROWS;
        deltaTime = 200;
        numNormalFood=0;

    }

    public int getNumNormalFood() {
        return numNormalFood;
    }

    public void setNumNormalFood(int numNormalFood) {
        this.numNormalFood = numNormalFood;
    }

    public boolean isPersonalized() {
        return personalized;
    }

    public void setPersonalized(boolean personalized) {
        this.personalized = personalized;
    }

    public void setDeltaTime(int deltaTime) {
        this.deltaTime = deltaTime;
    }

    public int getDeltaTime() {
        return deltaTime;
    }

    public void setNum_rows(int num_rows) {
        this.num_rows = num_rows;
    }

    public void setNum_cols(int num_cols) {
        this.num_cols = num_cols;
    }

    public int getNum_rows() {
        return num_rows;
    }

    public int getNum_cols() {
        return num_cols;
    }

    public void setModeHard(boolean modeHard) {
        this.modeHard = modeHard;
    }

    public void setModeNormal(boolean modeNormal) {
        this.modeNormal = modeNormal;
    }

    public boolean isModeHard() {
        return modeHard;
    }

    public boolean isModeNormal() {
        return modeNormal;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setWithoutWalls(boolean withoutWalls) {
        this.withoutWalls = withoutWalls;
    }

    public boolean isWithoutWalls() {
        return withoutWalls;
    }

    public static ConfigSingleton getInstance() {
        if (instance == null) {
            instance = new ConfigSingleton();
        }
        return instance;

    }

    //guardar
    public static void appendConfig() throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("ConfigSingleton.dat")));

            out.writeObject(instance);
        }catch(IOException ex){
            ex.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
    //leer

    public static void printConfig() throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("ConfigSingleton.dat")));

            while (true) {

                instance = (ConfigSingleton) in.readObject();
                System.out.println(instance);
            }

        } catch (EOFException e) {

        } finally {
            if (in != null) {
                in.close();
            }
        }
    }
}
