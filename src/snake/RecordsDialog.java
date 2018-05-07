package snake;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20909379x
 */
public class RecordsDialog extends javax.swing.JDialog {

    private class Record {

        public int record;
        public String name;

        public Record(int record, String name) {
            this.record = record;
            this.name = name;
        }
    }

    private static final String RECORDS_FILE_NAME_HARD = "recordsHard.txt";
    private static final String RECORDS_FILE_NAME_NORMAL = "recordsNormal.txt";
    private int score;
    private JLabel[] recordLabels;
    private int minRecord;
    private ArrayList<Record> listOfRecords;
    public Cover cover;

    /**
     * Creates new form RecordsDialog
     */
    public RecordsDialog(java.awt.Frame parent, boolean modal, int score, Cover cover) {
        super(parent, modal);
        initComponents();
        this.cover=cover;
        initRecordLabels();
        
        minRecord = 0;
        this.score = score;

        listOfRecords = new ArrayList<Record>();
        
        try {
            readRecords();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        processRecords();
    }

    public void processRecords() {
        jLabelCurrentScore.setText("Your score: " + score);
        if (score > minRecord) {

        } else {
            jLabelName.setVisible(false);
            jTextFieldName.setVisible(false);
        }
    }

    private void readRecords() throws IOException {
        BufferedReader input = null;
         
        try {
            if(cover.isModeNormal()){
            input = new BufferedReader(new FileReader(RECORDS_FILE_NAME_NORMAL));
            } 
            if(cover.isModeHard()){
                input = new BufferedReader(new FileReader(RECORDS_FILE_NAME_HARD));
            }
            int lineCount = 0;
            String line;
            String[] lineRecord = null;

            while ((line = input.readLine()) != null && (lineCount < 5)) {

                lineRecord = line.split(",");
                recordLabels[lineCount].setText(lineRecord[0] + ": " + lineRecord[1]);
                lineCount++;

                listOfRecords.add(new Record(Integer.parseInt(lineRecord[0]), lineRecord[1]));
            }
            
            if (lineCount == 5 ) {
                try {
                    minRecord = Integer.parseInt(lineRecord[0]);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }

            }

        } finally {
            if (input != null) {
                input.close();
            }
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelName = new javax.swing.JLabel();
        jTextFieldName = new javax.swing.JTextField();
        jLabelCurrentScore = new javax.swing.JLabel();
        jLabelRecord1 = new javax.swing.JLabel();
        jLabelRecord3 = new javax.swing.JLabel();
        jLabelRecord4 = new javax.swing.JLabel();
        jLabelRecord5 = new javax.swing.JLabel();
        jLabelRecord2 = new javax.swing.JLabel();
        jButtonOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocationByPlatform(true);

        jLabelName.setText("NAME :");

        jTextFieldName.setText(".");
        jTextFieldName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNameActionPerformed(evt);
            }
        });

        jLabelCurrentScore.setText("jLabel2");

        jLabelRecord1.setText("0..NoName");
        jLabelRecord1.setToolTipText("");

        jLabelRecord3.setText("0..NoName");

        jLabelRecord4.setText("0..NoName");

        jLabelRecord5.setText("0..NoName");

        jLabelRecord2.setText("0..NoName");

        jButtonOk.setText("OK");
        jButtonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelCurrentScore)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRecord3)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jButtonOk))
                            .addComponent(jLabelRecord2)
                            .addComponent(jLabelRecord5)
                            .addComponent(jLabelRecord4)
                            .addComponent(jLabelRecord1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelCurrentScore)
                .addGap(18, 18, 18)
                .addComponent(jLabelRecord1)
                .addGap(18, 18, 18)
                .addComponent(jLabelRecord2)
                .addGap(18, 18, 18)
                .addComponent(jLabelRecord4)
                .addGap(18, 18, 18)
                .addComponent(jLabelRecord5)
                .addGap(18, 18, 18)
                .addComponent(jLabelRecord3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelName)
                    .addComponent(jTextFieldName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonOk)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOkActionPerformed
        if (score > minRecord) {
            try {
                saveRecords();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        dispose();
    }//GEN-LAST:event_jButtonOkActionPerformed

    private void jTextFieldNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNameActionPerformed
    private void saveRecords() throws IOException {
        PrintWriter output = null;
        try {
            
             if(cover.isModeNormal()){
                  output = new PrintWriter(new FileWriter(RECORDS_FILE_NAME_NORMAL));
            } 
             if(cover.isModeHard()){
                output = new PrintWriter(new FileWriter(RECORDS_FILE_NAME_HARD));
            }
           
            int lineCounter = 0;
            boolean alredyWrittenScore = false;

            for (Record record : listOfRecords) {
                if (score>record.record && !alredyWrittenScore) {

                    output.println(score + ", " + jTextFieldName.getText());
                    alredyWrittenScore = true;
                    lineCounter++;
                }
                if (lineCounter < 5) {
                    output.println(record.record + ", " + record.name);
                    lineCounter++;
                }
            }
            if (!alredyWrittenScore) {
                output.println(score + ", " + jTextFieldName.getText());
            }

        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    private void initRecordLabels() {
        recordLabels = new JLabel[5];
        recordLabels[0] = jLabelRecord1;
        recordLabels[1] = jLabelRecord2;
        recordLabels[2] = jLabelRecord3;
        recordLabels[3] = jLabelRecord4;
        recordLabels[4] = jLabelRecord5;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonOk;
    private javax.swing.JLabel jLabelCurrentScore;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelRecord1;
    private javax.swing.JLabel jLabelRecord2;
    private javax.swing.JLabel jLabelRecord3;
    private javax.swing.JLabel jLabelRecord4;
    private javax.swing.JLabel jLabelRecord5;
    private javax.swing.JTextField jTextFieldName;
    // End of variables declaration//GEN-END:variables
}
