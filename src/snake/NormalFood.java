/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author alu20909379x
 */
public class NormalFood extends Food {

    

    public NormalFood(Snake snake) {
        super(snake);
      ConfigSingleton.getInstance().setNumNormalFood(ConfigSingleton.getInstance().getNumNormalFood()+1);

    }

    

    
}
