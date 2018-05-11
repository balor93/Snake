/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import sun.awt.X11.XConstants;

/**
 *
 * @author alu20909379x
 */
public class Snake {

    public ArrayList<Node> listNodes;
    public DireccionType direccion;
    public int countGrowSnake;

    public void setDireccion(DireccionType direccion) {
        this.direccion = direccion;
    }

    public DireccionType getDireccion() {
        return direccion;
    }

    public Snake() {
        listNodes = new ArrayList<Node>();
        listNodes.add(new Node(ConfigSingleton.getInstance().NUM_ROWS / 2, ConfigSingleton.getInstance().NUM_COLS / 2, Color.red));
        listNodes.add(new Node(ConfigSingleton.getInstance().NUM_ROWS / 2, ConfigSingleton.getInstance().NUM_COLS / 2 - 1, Color.black));
        listNodes.add(new Node(ConfigSingleton.getInstance().NUM_ROWS / 2, ConfigSingleton.getInstance().NUM_COLS / 2 - 2, Color.black));
        direccion = DireccionType.RIGHT;
        countGrowSnake = 0;
    }

    public void drawSnake(Graphics g, int squareWidth, int squareHeight) {

        for (Node n : listNodes) {
            Util.drawSquare(g, n, squareWidth, squareHeight);
        }
    }

    public Node getHeadSnake() {
        return listNodes.get(0);
    }

    public void move() {
        Node head = listNodes.get(0);
        switch (direccion) {
            case DOWN:
                if (ConfigSingleton.getInstance().isWithoutWalls() && head.row == ConfigSingleton.getInstance().getNum_rows()-1) {
                    listNodes.add(0, new Node(head.getFirstRow() + 1, head.col, Color.red));
                } else {
                    listNodes.add(0, new Node(head.row + 1, head.col, Color.red));
                }
                break;
            case UP:
                if (ConfigSingleton.getInstance().isWithoutWalls() && head.row == 0) {
                    listNodes.add(0, new Node(head.getLastRow() - 1, head.col, Color.red));
                } else {
                    listNodes.add(0, new Node(head.row - 1, head.col, Color.red));
                }
                break;
            case LEFT:
                if (ConfigSingleton.getInstance().isWithoutWalls() && head.col== 0) {
                    listNodes.add(0, new Node(head.row, head.getLastCol() - 1, Color.red));
                } else {
                    listNodes.add(0, new Node(head.row, head.col - 1, Color.red));
                }
                break;
            case RIGHT:
                if (ConfigSingleton.getInstance().isWithoutWalls() && head.col == ConfigSingleton.getInstance().getNum_cols()-1) {
                    listNodes.add(0, new Node(head.row, head.getLastCol() + 1, Color.red));
                } else {
                    listNodes.add(0, new Node(head.row, head.col + 1, Color.red));
                }
                break;
        }
        head.color = Color.black;
        if (countGrowSnake == 0) {
            listNodes.remove(listNodes.size() - 1);
        } else {
            countGrowSnake--;
        }

    }

    public void setCountGrowSnake(int countGrowSnake) {
        this.countGrowSnake = countGrowSnake;
    }

    public Node getNextNode() {
        Node head = listNodes.get(0);
        Node nextNode = null;
        switch (direccion) {
            case DOWN:
                if (ConfigSingleton.getInstance().isWithoutWalls() && head.row == ConfigSingleton.getInstance().getNum_rows() ) {
                    nextNode = new Node(head.getFirstRow() + 1, head.col, Color.red);
                } else {
                    nextNode = new Node(head.row + 1, head.col, Color.red);
                }
                break;
            case UP:
                if (ConfigSingleton.getInstance().isWithoutWalls() && head.row == 0) {
                    nextNode = new Node(head.getLastRow() - 1, head.col, Color.red);
                } else {
                    nextNode = new Node(head.row - 1, head.col, Color.red);
                }
                break;
            case LEFT:
                if (ConfigSingleton.getInstance().isWithoutWalls() && head.col== 0) {
                    nextNode = new Node(head.row, head.getLastCol() - 1, Color.red);
                } else {
                    nextNode = new Node(head.row, head.col - 1, Color.red);
                }
                break;
            case RIGHT:
                if (ConfigSingleton.getInstance().isWithoutWalls() && head.col == ConfigSingleton.getInstance().getNum_cols()) {
                    nextNode = new Node(head.row, head.getLastCol() + 1, Color.red);
                } else {
                    nextNode = new Node(head.row, head.col + 1, Color.red);
                }
                break;

        }
        return nextNode;
    }

    public boolean hitWall() {

        if (getNextNode().row > ConfigSingleton.getInstance().getNum_rows() - 1 || getNextNode().row < 0 || getNextNode().col > ConfigSingleton.getInstance().getNum_cols() - 1 || getNextNode().col < 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean hitSnake() {

        boolean check = false;
        for (int i = 1; i < listNodes.size(); i++) {
            if (listNodes.get(i).row == getNextNode().row && listNodes.get(i).col == getNextNode().col) {
                return true;
            }
        }
        return check;

    }

}
