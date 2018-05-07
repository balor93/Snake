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
public class Game extends javax.swing.JFrame {
   
    public static Cover c;

    public static Cover getC() {
        return c;
    }
//public static Cover cover;
    /**
     * Creates new form Game
     */
    public Game() {
        setLocationRelativeTo(null);
        initComponents();
        c = new Cover(this, true);  
        c.setVisible(true);
        board.setScoreBoard(scoreBoard);
        board.setCover(c);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        scoreBoard = new snake.ScoreBoard();
        board = new snake.Board();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemInitGame = new javax.swing.JMenuItem();
        jMenuItemChangeMode = new javax.swing.JMenuItem();
        jMenuItemExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        scoreBoard.setText("Score:");
        jPanel1.add(scoreBoard, java.awt.BorderLayout.PAGE_END);

        board.setBackground(new java.awt.Color(102, 255, 102));
        board.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout boardLayout = new javax.swing.GroupLayout(board);
        board.setLayout(boardLayout);
        boardLayout.setHorizontalGroup(
            boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );
        boardLayout.setVerticalGroup(
            boardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 327, Short.MAX_VALUE)
        );

        jPanel1.add(board, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Game");

        jMenuItemInitGame.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemInitGame.setText("Init Game");
        jMenuItemInitGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInitGameActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemInitGame);

        jMenuItemChangeMode.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemChangeMode.setText("Change Mode");
        jMenuItemChangeMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemChangeModeActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemChangeMode);

        jMenuItemExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_W, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jMenuItemInitGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInitGameActionPerformed

        board.initGame();


    }//GEN-LAST:event_jMenuItemInitGameActionPerformed

    private void jMenuItemChangeModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemChangeModeActionPerformed
        c = new Cover(this, true);  
        c.setVisible(true);
        
        board.setCover(c);
    }//GEN-LAST:event_jMenuItemChangeModeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private snake.Board board;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemChangeMode;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemInitGame;
    private javax.swing.JPanel jPanel1;
    private snake.ScoreBoard scoreBoard;
    // End of variables declaration//GEN-END:variables
}
