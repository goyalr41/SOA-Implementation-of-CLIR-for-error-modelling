/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CLIR.client.GUI;


import irenglish.upload.EnFileUploader;
import irenglish.upload.EnFileUploaderServiceLocator;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.rpc.ServiceException;

import CLIR.server.Precalculation;
import CLIR.server.PrecalculationServiceLocator;

//import static trygui.Hin_error.centreWindow;

/**
 *
 * @author Administrator
 */
public class mainpage extends javax.swing.JFrame {

    /**
     * Creates new form mainpage
     */
    public static void centreWindow(Window frame) {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
    frame.setLocation(x, y);
    }
    
    
    public mainpage() throws RemoteException, ServiceException {
    	PrecalculationServiceLocator locator1 = new PrecalculationServiceLocator();
		Precalculation requestor1 = locator1.getPrecalculation();
	
		requestor1.doit();
         //pre.doit();
        initComponents();
        centreWindow(this);
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
        doc = new javax.swing.JButton();
        query = new javax.swing.JButton();
        eng_corr = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        doc.setText("Document Upload");
        doc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docActionPerformed(evt);
            }
        });
        jPanel1.add(doc);
        doc.setBounds(103, 70, 180, 23);

        query.setText("Query");
        query.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryActionPerformed(evt);
            }
        });
        jPanel1.add(query);
        query.setBounds(103, 130, 180, 23);

        eng_corr.setText("English Error Correction");
        eng_corr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eng_corrActionPerformed(evt);
            }
        });
        //jPanel1.add(eng_corr);
        //eng_corr.setBounds(103, 180, 180, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:/Users/hp/workspace/CLIRserverfi/src/CLIR/client/GUI/QuestionMark.jpg"));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 400, 300);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void docActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docActionPerformed
        try {
            doc_upload d = new doc_upload();
            d.setVisible(true);
            
            // TODO add your handling code here:
        } catch (IOException ex) {
            Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_docActionPerformed

    private void queryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryActionPerformed

        gui g;
        try {
            g = new gui();
             g.setVisible(true);
            
        
        } catch (IOException ex) {
            Logger.getLogger(mainpage.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        // TODO add your handling code here:
    }//GEN-LAST:event_queryActionPerformed

    private void eng_corrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eng_corrActionPerformed
       
        
         
       
       
        
        // TODO add your handling code here:
    }//GEN-LAST:event_eng_corrActionPerformed

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
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainpage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
					new mainpage().setVisible(true);
				} catch (RemoteException | ServiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton doc;
    private javax.swing.JButton eng_corr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton query;
    // End of variables declaration//GEN-END:variables
}
