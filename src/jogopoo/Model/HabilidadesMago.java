package jogopoo.Model;

import java.awt.event.KeyEvent;
import jogopoo.Control.Application;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Marcio55
 */
public abstract class HabilidadesMago extends Habilidades{
    
    protected int manaNecessaria;
    public boolean CanUseHabilidade(PersonagemModel  personagem){
        Mago m = (Mago)personagem;
        
        if(personagem.getCanAction() && super.getCooldown() == 0){
            if(m.mana >= this.manaNecessaria){
                return true;
            }
        }
    return false;
    }
}
