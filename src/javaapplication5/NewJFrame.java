/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    private int mode;
    private static void doCopy(InputStream is, OutputStream os) throws IOException {
        byte[] bytes = new byte[64];
            int numBytes;
            while ((numBytes = is.read(bytes)) != -1) {
                os.write(bytes, 0, numBytes);
            }
            os.flush();
            os.close();
            is.close();
    }
    
    public static void encrypt(String key, InputStream is, OutputStream os) throws Throwable {
        encryptOrDecrypt(key, Cipher.ENCRYPT_MODE, is, os);
    }
    
    public static void decrypt(String key, InputStream is, OutputStream os) throws Throwable {
        encryptOrDecrypt(key, Cipher.DECRYPT_MODE, is, os);
    }
    
    public static void encryptOrDecrypt(String key, int mode, InputStream is, OutputStream os) throws Throwable {
        DESKeySpec dks = new DESKeySpec(key.getBytes());
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
        SecretKey desKey = skf.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        
        if (mode == Cipher.ENCRYPT_MODE) {
            cipher.init(Cipher.ENCRYPT_MODE, desKey);
            CipherInputStream cis = new CipherInputStream(is, cipher);
            doCopy(cis, os);
        } else if (mode == Cipher.DECRYPT_MODE) {
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            CipherOutputStream cos = new CipherOutputStream(os, cipher);
            doCopy(is, cos);
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

        txtInput = new javax.swing.JTextField();
        btnMahoa = new javax.swing.JButton();
        btnHienthi = new javax.swing.JButton();
        btnGhifile = new javax.swing.JButton();
        txtPlain = new javax.swing.JTextField();
        txtCipher = new javax.swing.JTextField();
        btnGiaima = new javax.swing.JButton();
        btnAllshow = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnMahoa.setText("Ma hoa");
        btnMahoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMahoaActionPerformed(evt);
            }
        });

        btnHienthi.setText("Hien thi");
        btnHienthi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienthiActionPerformed(evt);
            }
        });

        btnGhifile.setText("Ghi file");
        btnGhifile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGhifileActionPerformed(evt);
            }
        });

        btnGiaima.setText("Giai ma");
        btnGiaima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGiaimaActionPerformed(evt);
            }
        });

        btnAllshow.setText("All show");
        btnAllshow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllshowActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnMahoa)
                        .addGap(72, 72, 72)
                        .addComponent(btnHienthi)
                        .addGap(57, 57, 57)
                        .addComponent(btnGhifile))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPlain)
                            .addComponent(txtCipher, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE))))
                .addContainerGap(109, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(btnGiaima)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAllshow)
                .addGap(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(txtInput, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnMahoa)
                    .addComponent(btnHienthi)
                    .addComponent(btnGhifile))
                .addGap(30, 30, 30)
                .addComponent(txtPlain, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(txtCipher, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGiaima)
                    .addComponent(btnAllshow))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGiaimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGiaimaActionPerformed
        // TODO add your handling code here:
        FileInputStream fis2 = null;
        try {
            String key = txtInput.getText();
            fis2 = new FileInputStream("M:\\EnDes.txt");
            FileOutputStream fos2 = new FileOutputStream("M:\\DeDes.txt");
            decrypt(key, fis2, fos2);
            
            BufferedReader br = null;
            
            String fileName = "M:\\DeDes.txt";
            
            br = new BufferedReader(new FileReader(fileName));
            StringBuffer sb = new StringBuffer();
            JOptionPane.showMessageDialog(null, "Da giai ma");
            char[] ca = new char[5];
            
            while (br.ready()) {
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            
            br.close();
            
            System.out.println("Du lieu la:" + " " + sb);
            String chuoi = sb.toString();
            
            txtCipher.setText(chuoi);
        } catch (Throwable ex) {
            Logger.getLogger(JavaApplication5.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis2.close();
            } catch (IOException ex) {
                Logger.getLogger(JavaApplication5.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGiaimaActionPerformed

    private void btnMahoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMahoaActionPerformed
        // TODO add your handling code here:
         try {
            String key = txtInput.getText();
            
            FileInputStream fis = new FileInputStream("M:\\Des.txt");
            FileOutputStream fos = new FileOutputStream("M:\\EnDes.txt");
            encrypt(key, fis, fos);
            
            JOptionPane.showMessageDialog(null, "Da ma hoa van ban");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnMahoaActionPerformed

    private void btnGhifileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGhifileActionPerformed
        // TODO add your handling code here:
        try {
            BufferedWriter bw = null;
            String fileName = "M:\\Des.txt";
            
            String s = txtPlain.getText();
            bw = new BufferedWriter(new FileWriter(fileName));
            
            bw.write(s);
            bw.close();
            JOptionPane.showMessageDialog(null, "Da ghi file");
            //txtCipher.setText(s);
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGhifileActionPerformed

    private void btnHienthiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienthiActionPerformed
        // TODO add your handling code here:
        try {
            BufferedReader br = null;
            
            String fileName = "M:\\EnDes.txt";
            br = new BufferedReader(new FileReader(fileName));
            
            StringBuffer sb = new StringBuffer();
            
            JOptionPane.showMessageDialog(null, "Da luu file");
            char[] ca = new char[5];
            
            while (br.ready()) {
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            
            br.close();
            
            System.out.println("Du lieu la:" + " " + sb);
            String chuoi = sb.toString();
            
            txtPlain.setText(chuoi);
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnHienthiActionPerformed

    private void btnAllshowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllshowActionPerformed
        // TODO add your handling code here:
        try {
            BufferedReader br = null;
            
            String fileName = "M:\\DeDes.txt";
            br = new BufferedReader(new FileReader(fileName));
            StringBuffer sb = new StringBuffer();
            
            JOptionPane.showMessageDialog(null, "Da mo file");
            char[] ca = new char[5];
            while(br.ready()) {
                int len = br.read(ca);
                sb.append(ca, 0, len);
            }
            br.close();
            
            System.out.println("Du lieu la:" + " " + sb);
            String chuoi = sb.toString();
            
            txtPlain.setText(chuoi);
        } catch (IOException ex) {
            Logger.getLogger(JavaApplication5.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAllshowActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAllshow;
    private javax.swing.JButton btnGhifile;
    private javax.swing.JButton btnGiaima;
    private javax.swing.JButton btnHienthi;
    private javax.swing.JButton btnMahoa;
    private javax.swing.JTextField txtCipher;
    private javax.swing.JTextField txtInput;
    private javax.swing.JTextField txtPlain;
    // End of variables declaration//GEN-END:variables
}
