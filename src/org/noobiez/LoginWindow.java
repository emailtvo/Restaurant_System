/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.noobiez;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thanh
 */
public class LoginWindow extends javax.swing.JFrame {

    /**
     * Creates new form LoginWindow
     */
    public LoginWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLogin = new javax.swing.JButton();
        txtPasswordEntry = new javax.swing.JTextField();
        lblError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        txtPasswordEntry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordEntryActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblError.setForeground(new java.awt.Color(255, 0, 0));
        lblError.setText("Invalid Login");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtPasswordEntry, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(171, 171, 171))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblError)
                        .addGap(157, 157, 157))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(txtPasswordEntry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin)
                .addGap(18, 18, 18)
                .addComponent(lblError)
                .addContainerGap(103, Short.MAX_VALUE))
        );

        lblError.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String userPasswordEntry = "";
        String userType[] = {};

        //Get text from password textbox
        userPasswordEntry = txtPasswordEntry.getText();
        LoginProcessor loginProcessor = new LoginProcessor(userPasswordEntry);
        
        try {
            userType = loginProcessor.determineUserTypeAndName();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginWindow.class.getName()).log(Level.SEVERE, null, ex);
            lblError.setText("Database Error"); // Error shows users file was not found
            lblError.setVisible(true);
        }

        if (!userType[0].isEmpty()) //If the user was found
        {
            //Reset the login view
            lblError.setVisible(false);
            txtPasswordEntry.setText("");
            this.dispose();

            //Launch window depending on user type
            if (userType[0].equals("mgr")) {
                //ServerView.main(userType[1]);
                ServerView.main(null);
            } else if (userType[0].equals("srv")) {
                //ServerView.main(userType[1]);
                ServerView.main(null);
            }
        } else //If no user found, output error message
        {
            txtPasswordEntry.setText("");
            lblError.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
            lblError.setForeground(new java.awt.Color(255, 0, 0));
            lblError.setText("Invalid Login");
            lblError.setVisible(true);
        }

    }//GEN-LAST:event_btnLoginActionPerformed

    // Accept Button code
    private void txtPasswordEntryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordEntryActionPerformed
        btnLoginActionPerformed(evt);
    }//GEN-LAST:event_txtPasswordEntryActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new LoginWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel lblError;
    private javax.swing.JTextField txtPasswordEntry;
    // End of variables declaration//GEN-END:variables
}
