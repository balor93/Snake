/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

/**
 *
 * @author alu20909379x
 */
public class FactoryFood {
    public Snake snake;
    public Board board;
    
    public FactoryFood(Board board, Snake snake){
    
        this.board=board;
        this.snake=snake;
    }
    
    public Food createFood(){
        if(ConfigSingleton.getInstance().getNumNormalFood()==5){
            ConfigSingleton.getInstance().setNumNormalFood(0);
            return new SpecialFood(snake, board);
        }else{
            return new NormalFood(snake);
        }
    }
    
}
