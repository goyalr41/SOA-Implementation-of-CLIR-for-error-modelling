/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CLIR.client.GUI;



import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class hin_error extends javax.swing.JFrame {

    /**
     * Creates new form hin_error
     */
    public hin_error() {
        initComponents();
        hin_scroll.setVisible(false);
        hin_table.setVisible(false);
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
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        hin_button = new javax.swing.JButton();
        hin_scroll = new javax.swing.JScrollPane();
        hin_table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Word");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(27, 36, 60, 22);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1);
        jTextField1.setBounds(90, 40, 230, 20);

        hin_button.setIcon(new javax.swing.ImageIcon("C:/Users/hp/workspace/CLIRserver1/src/CLIR/client/GUI/button.png")); // NOI18N
        hin_button.setBorder(javax.swing.BorderFactory.createBevelBorder(0));
        hin_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hin_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(hin_button);
        hin_button.setBounds(280, 90, 99, 30);

        hin_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Suggested Word", "Edit Distance"
            }
        ));
        hin_scroll.setViewportView(hin_table);

        jPanel1.add(hin_scroll);
        hin_scroll.setBounds(40, 180, 331, 90);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:/Users/hp/workspace/CLIRserver1/src/CLIR/client/GUI/the_big_question_mark.png")); // NOI18N
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 400, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void hin_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hin_buttonActionPerformed
        hin_scroll.setVisible(true);
        hin_table.setVisible(true);
        String data[][] = {{}};
        String col[] = {"Suggested word", "Edit distance"};
        DefaultTableModel t = new DefaultTableModel(data, col);
       // String g[][][] ={"ratna", "2", "3"} ;
        t.insertRow(0, new Object[]{"ratna", "3"});
         hin_table.setModel(t);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_hin_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(hin_error.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(hin_error.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(hin_error.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(hin_error.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new hin_error().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton hin_button;
    private javax.swing.JScrollPane hin_scroll;
    private javax.swing.JTable hin_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}