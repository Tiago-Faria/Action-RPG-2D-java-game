/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.util.ArrayList;

/**
 *
 * @author Esdras Chaves
 */
public class InventarioModel {
    private PersonagemModel personagem;
    
    public InventarioModel(PersonagemModel personagem) {
        this.personagem = personagem;
    }
    public void equipItem(int numSlot) {
        if(personagem.inventario.getItems().size() > numSlot) {
            if(personagem.inventario.getItems().get(numSlot).getClass().getSuperclass().getSuperclass().getName().equalsIgnoreCase("jogopoo.Model.Arma")){
                personagem.equipavel[0] = null;
                personagem.equipavel[0] =  (Equipavel) personagem.inventario.getItems().get(numSlot);
            }else if(personagem.inventario.getItems().get(numSlot).getClass().getSuperclass().getName().equalsIgnoreCase("jogopoo.Model.Acessorio")) {
                personagem.equipavel[1] = null;
                personagem.equipavel[1] =  (Equipavel) personagem.inventario.getItems().get(numSlot);
            }else if(personagem.inventario.getItems().get(numSlot).getClass().getName().equalsIgnoreCase("jogopoo.Model.Armadura")) {
                personagem.equipavel[2] = null;
                personagem.equipavel[2] =  (Equipavel) personagem.inventario.getItems().get(numSlot);
            }
        }
    }
    
    public void consumirItem(int numSlot) {
        if(personagem.inventario.getItems().size() > numSlot) {
            if(personagem.inventario.getItems().get(numSlot).getClass().getSuperclass().getName().equalsIgnoreCase("jogopoo.Model.Consumivel")) {
                ((Consumivel)personagem.inventario.getItems().get(numSlot)).consumir(personagem);
                personagem.inventario.removeItem(numSlot);
            }
        }
    }
    
    public void removerItem(int numSlot) {
        if(personagem.inventario.getItems().size() > numSlot) {
            for(int i = 0; i < 3; i++) {
                if(personagem.inventario.getItems().get(numSlot) == personagem.equipavel[i]) {
                    personagem.equipavel[i] = null;
                    break;
                }
            }
            
            personagem.inventario.removeItem(numSlot);
        }
        
    }
    
    public Equipavel[] retornaEquipavel() {
        return this.personagem.equipavel;
    }
    
    public ArrayList<Item> retornaItems() {
        return this.personagem.inventario.getItems();
    }
}
