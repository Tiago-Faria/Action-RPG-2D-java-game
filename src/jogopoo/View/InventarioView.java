/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.View;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import jogopoo.Control.Application;
import jogopoo.Model.Equipavel;
import jogopoo.Model.Item;

/**
 *
 * @author Esdras Chaves
 */
public class InventarioView extends javax.swing.JFrame {

    /**
     * Creates new form inventarioView
     */
    
    
   final ArrayList<JLabel> listaSlots = new ArrayList<>();
    
    public InventarioView() {
        initComponents();
        listaSlots.add(slot0);
        listaSlots.add(slot1);
        listaSlots.add(slot2);
        listaSlots.add(slot3);
        listaSlots.add(slot4);
        listaSlots.add(slot5);
        listaSlots.add(slot6);
        listaSlots.add(slot7);
        listaSlots.add(slot8);
        listaSlots.add(slot9);
        listaSlots.add(slot10);
        listaSlots.add(slot11);
        listaSlots.add(slot12);
        listaSlots.add(slot13);
        listaSlots.add(slot14);
        listaSlots.add(slot15);
        listaSlots.add(slot16);
        listaSlots.add(slot17);
        listaSlots.add(slot18);
        listaSlots.add(slot19);
        listaSlots.add(slot20);
        listaSlots.add(slot21);
        listaSlots.add(slot22);
        listaSlots.add(slot23);
        listaSlots.add(slot24);
        listaSlots.add(slot25);
        listaSlots.add(slot26);
        listaSlots.add(slot27);
        listaSlots.add(slot28);
        listaSlots.add(slot29);
        listaSlots.add(slot30);
        listaSlots.add(slot31);
        listaSlots.add(slot32);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slot0 = new javax.swing.JLabel();
        slot1 = new javax.swing.JLabel();
        slot2 = new javax.swing.JLabel();
        slot3 = new javax.swing.JLabel();
        slot4 = new javax.swing.JLabel();
        slot5 = new javax.swing.JLabel();
        slot6 = new javax.swing.JLabel();
        slot7 = new javax.swing.JLabel();
        slot8 = new javax.swing.JLabel();
        slot9 = new javax.swing.JLabel();
        slot10 = new javax.swing.JLabel();
        slot11 = new javax.swing.JLabel();
        slot12 = new javax.swing.JLabel();
        slot13 = new javax.swing.JLabel();
        slot14 = new javax.swing.JLabel();
        slot15 = new javax.swing.JLabel();
        slot16 = new javax.swing.JLabel();
        slot17 = new javax.swing.JLabel();
        slot18 = new javax.swing.JLabel();
        slot19 = new javax.swing.JLabel();
        slot20 = new javax.swing.JLabel();
        slot21 = new javax.swing.JLabel();
        slot22 = new javax.swing.JLabel();
        slot23 = new javax.swing.JLabel();
        slot24 = new javax.swing.JLabel();
        slot25 = new javax.swing.JLabel();
        slot26 = new javax.swing.JLabel();
        slot27 = new javax.swing.JLabel();
        slot28 = new javax.swing.JLabel();
        slot29 = new javax.swing.JLabel();
        slot30 = new javax.swing.JLabel();
        slot31 = new javax.swing.JLabel();
        slot32 = new javax.swing.JLabel();
        equipItem = new javax.swing.JButton();
        removeItem = new javax.swing.JButton();
        consumeItem = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(567, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        slot0.setName("slot0"); // NOI18N
        getContentPane().add(slot0);
        slot0.setBounds(260, 24, 50, 50);

        slot1.setName("slot1"); // NOI18N
        getContentPane().add(slot1);
        slot1.setBounds(320, 20, 50, 50);

        slot2.setName("slot2"); // NOI18N
        getContentPane().add(slot2);
        slot2.setBounds(380, 20, 40, 50);

        slot3.setName("slot3"); // NOI18N
        getContentPane().add(slot3);
        slot3.setBounds(440, 20, 40, 50);

        slot4.setName("slot4"); // NOI18N
        getContentPane().add(slot4);
        slot4.setBounds(490, 20, 50, 50);

        slot5.setName("slot5"); // NOI18N
        getContentPane().add(slot5);
        slot5.setBounds(260, 80, 50, 50);

        slot6.setName("slot6"); // NOI18N
        getContentPane().add(slot6);
        slot6.setBounds(320, 80, 50, 50);

        slot7.setName("slot7"); // NOI18N
        getContentPane().add(slot7);
        slot7.setBounds(380, 80, 40, 50);

        slot8.setName("slot8"); // NOI18N
        getContentPane().add(slot8);
        slot8.setBounds(440, 80, 40, 50);

        slot9.setName("slot9"); // NOI18N
        getContentPane().add(slot9);
        slot9.setBounds(500, 80, 40, 50);

        slot10.setName("slot10"); // NOI18N
        getContentPane().add(slot10);
        slot10.setBounds(260, 140, 50, 50);

        slot11.setName("slot11"); // NOI18N
        getContentPane().add(slot11);
        slot11.setBounds(320, 140, 50, 50);

        slot12.setName("slot12"); // NOI18N
        getContentPane().add(slot12);
        slot12.setBounds(380, 140, 50, 50);

        slot13.setName("slot13"); // NOI18N
        getContentPane().add(slot13);
        slot13.setBounds(440, 140, 40, 50);

        slot14.setName("slot14"); // NOI18N
        getContentPane().add(slot14);
        slot14.setBounds(500, 140, 50, 50);

        slot15.setName("slot15"); // NOI18N
        getContentPane().add(slot15);
        slot15.setBounds(260, 200, 50, 50);

        slot16.setName("slot16"); // NOI18N
        getContentPane().add(slot16);
        slot16.setBounds(320, 200, 50, 50);

        slot17.setName("slot17"); // NOI18N
        getContentPane().add(slot17);
        slot17.setBounds(380, 200, 50, 50);

        slot18.setName("slot18"); // NOI18N
        getContentPane().add(slot18);
        slot18.setBounds(440, 200, 40, 50);

        slot19.setName("slot19"); // NOI18N
        getContentPane().add(slot19);
        slot19.setBounds(500, 200, 50, 50);

        slot20.setName("slot20"); // NOI18N
        getContentPane().add(slot20);
        slot20.setBounds(260, 260, 50, 50);

        slot21.setName("slot21"); // NOI18N
        getContentPane().add(slot21);
        slot21.setBounds(320, 260, 50, 50);

        slot22.setName("slot22"); // NOI18N
        getContentPane().add(slot22);
        slot22.setBounds(380, 260, 50, 50);

        slot23.setName("slot23"); // NOI18N
        getContentPane().add(slot23);
        slot23.setBounds(440, 260, 40, 50);

        slot24.setName("slot24"); // NOI18N
        getContentPane().add(slot24);
        slot24.setBounds(500, 260, 50, 50);

        slot25.setName("slot25"); // NOI18N
        getContentPane().add(slot25);
        slot25.setBounds(260, 320, 50, 40);

        slot26.setName("slot26"); // NOI18N
        getContentPane().add(slot26);
        slot26.setBounds(320, 320, 50, 40);

        slot27.setName("slot27"); // NOI18N
        getContentPane().add(slot27);
        slot27.setBounds(380, 320, 50, 50);

        slot28.setName("slot28"); // NOI18N
        getContentPane().add(slot28);
        slot28.setBounds(440, 320, 50, 40);

        slot29.setName("slot29"); // NOI18N
        getContentPane().add(slot29);
        slot29.setBounds(500, 320, 40, 40);

        slot30.setName("slot30"); // NOI18N
        getContentPane().add(slot30);
        slot30.setBounds(70, 50, 40, 40);

        slot31.setName("slot31"); // NOI18N
        getContentPane().add(slot31);
        slot31.setBounds(150, 50, 50, 50);

        slot32.setName("slot32"); // NOI18N
        getContentPane().add(slot32);
        slot32.setBounds(40, 140, 40, 40);

        equipItem.setText("Equipar");
        equipItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equipItemActionPerformed(evt);
            }
        });
        getContentPane().add(equipItem);
        equipItem.setBounds(30, 290, 100, 23);

        removeItem.setText("Remover");
        getContentPane().add(removeItem);
        removeItem.setBounds(130, 290, 100, 23);

        consumeItem.setText("Consumir");
        getContentPane().add(consumeItem);
        consumeItem.setBounds(70, 330, 120, 23);

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/inventory.jpg"))); // NOI18N
        jLabel36.setName(""); // NOI18N
        getContentPane().add(jLabel36);
        jLabel36.setBounds(0, 0, 570, 370);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void equipItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equipItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_equipItemActionPerformed

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
            java.util.logging.Logger.getLogger(InventarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InventarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InventarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InventarioView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InventarioView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consumeItem;
    private javax.swing.JButton equipItem;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JButton removeItem;
    private javax.swing.JLabel slot0;
    private javax.swing.JLabel slot1;
    private javax.swing.JLabel slot10;
    private javax.swing.JLabel slot11;
    private javax.swing.JLabel slot12;
    private javax.swing.JLabel slot13;
    private javax.swing.JLabel slot14;
    private javax.swing.JLabel slot15;
    private javax.swing.JLabel slot16;
    private javax.swing.JLabel slot17;
    private javax.swing.JLabel slot18;
    private javax.swing.JLabel slot19;
    private javax.swing.JLabel slot2;
    private javax.swing.JLabel slot20;
    private javax.swing.JLabel slot21;
    private javax.swing.JLabel slot22;
    private javax.swing.JLabel slot23;
    private javax.swing.JLabel slot24;
    private javax.swing.JLabel slot25;
    private javax.swing.JLabel slot26;
    private javax.swing.JLabel slot27;
    private javax.swing.JLabel slot28;
    private javax.swing.JLabel slot29;
    private javax.swing.JLabel slot3;
    private javax.swing.JLabel slot30;
    private javax.swing.JLabel slot31;
    private javax.swing.JLabel slot32;
    private javax.swing.JLabel slot4;
    private javax.swing.JLabel slot5;
    private javax.swing.JLabel slot6;
    private javax.swing.JLabel slot7;
    private javax.swing.JLabel slot8;
    private javax.swing.JLabel slot9;
    // End of variables declaration//GEN-END:variables
    
    
    public void updateView(Equipavel[] equipavel, ArrayList<Item> items) {
       for(int i = 0; i < 30; i++) {
           if(i < items.size()) {
               this.listaSlots.get(i).setIcon(items.get(i).getSprite().getFirstImage());
               
           }else {
               listaSlots.get(i).setIcon(null);
           }
       }
       
       for(int i = 0; i < 3; i++) {
           if(equipavel[i] != null) {
               listaSlots.get(30 + i).setIcon(equipavel[i].getSprite().getFirstImage());
           }else {
               listaSlots.get(30 + i).setIcon(null);
           }
       }
    }
    
    public void consumirItemButton(ActionListener listenForConsumeButton){
	consumeItem.addActionListener(listenForConsumeButton);
    }
    
    public void equiparItemButton(ActionListener listenForEquipButton) {
        equipItem.addActionListener(listenForEquipButton);
    }
    
    public void removerItemButton(ActionListener listenForRemoveButton) {
        removeItem.addActionListener(listenForRemoveButton);
    }
    
    public void setLabelsButton(MouseListener listenForLabelsButtons) {
       
        for(int i = 0; i < 33; i++) {
            listaSlots.get(i).addMouseListener(listenForLabelsButtons);
        }
    }
    
    public int fechaTela() {
        Application.Application.gamePaused = false;
        this.dispose();
        return 1;
    }
}
