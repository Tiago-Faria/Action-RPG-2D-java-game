/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.View;

import java.awt.Checkbox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import jogopoo.Model.Habilidades;

/**
 *
 * @author Esdras Chaves
 */
public class menuEscolhaPersonagemView extends javax.swing.JFrame {

    /**
     * Creates new form menuEscolhaPersonagemView
     */
    
    final ArrayList<JCheckBox> listaHabilities = new ArrayList<>();
    public menuEscolhaPersonagemView() {
        initComponents();
        listaHabilities.add(hability01);
        listaHabilities.add(hability02);
        listaHabilities.add(hability03);
        listaHabilities.add(hability04);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chooseWarrior = new javax.swing.JButton();
        chooseMage = new javax.swing.JButton();
        chooseArcher = new javax.swing.JButton();
        gameInit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        hability01 = new javax.swing.JCheckBox();
        hability02 = new javax.swing.JCheckBox();
        hability03 = new javax.swing.JCheckBox();
        hability04 = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 740));
        setMinimumSize(new java.awt.Dimension(1280, 740));
        setPreferredSize(new java.awt.Dimension(1280, 740));
        setResizable(false);
        getContentPane().setLayout(null);

        chooseWarrior.setText("Guerreiro");
        getContentPane().add(chooseWarrior);
        chooseWarrior.setBounds(190, 360, 240, 50);

        chooseMage.setText("Mago");
        chooseMage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseMageActionPerformed(evt);
            }
        });
        getContentPane().add(chooseMage);
        chooseMage.setBounds(520, 360, 240, 50);

        chooseArcher.setText("Arqueiro");
        getContentPane().add(chooseArcher);
        chooseArcher.setBounds(840, 360, 240, 50);

        gameInit.setText("PLAY");
        getContentPane().add(gameInit);
        gameInit.setBounds(520, 460, 240, 50);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/warrior.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(190, 50, 240, 280);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/mage.jpg"))); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(520, 50, 240, 280);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/archer.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(840, 50, 240, 280);
        getContentPane().add(hability01);
        hability01.setBounds(520, 540, 240, 23);
        getContentPane().add(hability02);
        hability02.setBounds(520, 580, 240, 21);
        getContentPane().add(hability03);
        hability03.setBounds(520, 620, 240, 21);
        getContentPane().add(hability04);
        hability04.setBounds(520, 660, 240, 21);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/menuBackground.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1280, 720);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void addActionListenerMage(ActionListener e) {
        chooseMage.addActionListener(e);
    }
    
    public void addActionListenerWarrior(ActionListener e) {
        chooseWarrior.addActionListener(e);
    }
    
    public void addActionListenerArcher(ActionListener e) {
        chooseArcher.addActionListener(e);
    }
    
    public void addActionListenerGame(ActionListener e) {
        gameInit.addActionListener(e);
    }
    
    public int[] getHability() {
        int[] habilities = new int[2];
        int aux = 0;
        for(int i = 0; i < 4; i++) {
            if(listaHabilities.get(i).isSelected()) {
                habilities[aux] = i;
                aux++;
            }
            if(aux == 2)
                return habilities;
                
        }
        
        return null;
    }
    
    public void updateCheckbox() {
        for(int i = 0; i < 4; i++) 
            listaHabilities.get(i).setText(Habilidades.habilidadesDisponiveis.get(i).getClass().getSimpleName());
    }
    
    public int getNumHability() {
        int count = 0;
        for(int i = 0; i < 4; i++) {
            if(listaHabilities.get(i).isSelected())
                count++;
        }
        return count;
    }
    
    private void chooseMageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseMageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chooseMageActionPerformed
    
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
            java.util.logging.Logger.getLogger(menuEscolhaPersonagemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menuEscolhaPersonagemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menuEscolhaPersonagemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menuEscolhaPersonagemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menuEscolhaPersonagemView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseArcher;
    private javax.swing.JButton chooseMage;
    private javax.swing.JButton chooseWarrior;
    private javax.swing.JButton gameInit;
    private javax.swing.JCheckBox hability01;
    private javax.swing.JCheckBox hability02;
    private javax.swing.JCheckBox hability03;
    private javax.swing.JCheckBox hability04;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
