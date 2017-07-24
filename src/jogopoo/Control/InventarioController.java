/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JLabel;
import jogopoo.Model.InventarioModel;
import jogopoo.View.InventarioView;

/**
 *
 * @author Esdras Chaves
 */
public class InventarioController{
    private InventarioView theView;
    private InventarioModel theModel;
    
    private int numSlot = -1;
    public boolean windowOpened = false;
    
    public InventarioController(InventarioView theView, InventarioModel theModel) {
        this.theModel = theModel;
        this.theView = theView;
        
        this.theView.consumirItemButton(new useItem());
        this.theView.equiparItemButton(new equipItem());
        this.theView.removerItemButton(new removeItem());
        this.theView.setLabelsButton(new selectItem());

    }
    
    class selectItem implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            JLabel l = (JLabel) e.getSource();
            switch(l.getName()) {
                case "slot0":
                    numSlot = 0;
                    break;
                case "slot1":
                    numSlot = 1;
                    break;
                case "slot2":
                    numSlot = 2;
                    break;
                case "slot3":
                    numSlot = 3;
                    break;
                case "slot4":
                    numSlot = 4;
                    break;
                case "slot5":
                    numSlot = 5;
                    break;
                case "slot6":
                    numSlot = 6;
                    break;
                case "slot7":
                    numSlot = 7;
                    break;
                case "slot8":
                    numSlot = 8;
                    break;
                case "slot9":
                    numSlot = 9;
                    break;
                case "slot10":
                    numSlot = 10;
                    break;
                case "slot11":
                    numSlot = 11;
                    break;
                case "slot12":
                    numSlot = 12;
                    break;
                case "slot13":
                    numSlot = 13;
                    break;
                case "slot14":
                    numSlot = 14;
                    break;
                case "slot15":
                    numSlot = 15;
                    break;
                case "slot16":
                    numSlot = 16;
                    break;
                case "slot17":
                    numSlot = 17;
                    break;
                case "slot18":
                    numSlot = 18;
                    break;
                case "slot19":
                    numSlot = 19;
                    break;
                case "slot20":
                    numSlot = 20;
                    break;
                case "slot21":
                    numSlot = 21;
                    break;
                case "slot22":
                    numSlot = 22;
                    break;
                case "slot23":
                    numSlot = 23;
                    break;
                case "slot24":
                    numSlot = 24;
                    break;
                case "slot25":
                    numSlot = 25;
                    break;
                case "slot26":
                    numSlot = 26;
                    break;
                case "slot27":
                    numSlot = 27;
                    break;
                case "slot28":
                    numSlot = 28;
                    break;
                case "slot29":
                    numSlot = 29;
                    break;
                case "slot30":
                    numSlot = 30;
                    break;
                case "slot31":
                    numSlot = 31;
                    break;
                case "slot32":
                    numSlot = 32;
                    break;   
            }
            System.out.println("CLicou no " + numSlot);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
        
    }
    
    class equipItem implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(numSlot >= 0 && numSlot <=29) {
                theModel.equipItem(numSlot);
                theView.updateView(theModel.retornaEquipavel(), theModel.retornaItems());
            }
            numSlot = -1;
        }
    
    }
    
    class useItem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(numSlot >= 0 && numSlot <=29) {
                theModel.consumirItem(numSlot);
                theView.updateView(theModel.retornaEquipavel(), theModel.retornaItems());
            }
            numSlot = -1;
        }
        
    }
    
    class removeItem implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(numSlot >= 0 && numSlot <=32) {
                theModel.removerItem(numSlot);
                theView.updateView(theModel.retornaEquipavel(), theModel.retornaItems());
            }
            numSlot = -1;
        }
        
    }
}
