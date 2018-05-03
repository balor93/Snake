/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author alu20909379x
 */
public class ImagePanel extends JPanel{
    public ImagePanel(){
        super();
    }
    @Override
   public void paintComponent(Graphics g){
      super.paintComponent(g);
      Dimension tamanio = getSize();
      ImageIcon imagenFondo = new ImageIcon(getClass().
      getResource("/Snake2.jpg"));
      g.drawImage(imagenFondo.getImage(), 0, 0,
      tamanio.width, tamanio.height, null);
      setOpaque(false);
      
   }
    
}
