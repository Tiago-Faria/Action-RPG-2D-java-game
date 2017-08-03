/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

/**
 *
 * @author marcio
 */
public abstract class HabilidadesGuerreiro extends Habilidades{
    
    protected int estaminaNecessaria;
    public boolean CanUseHabilidade(PersonagemModel  personagem){
        PersonagemGuerreiro m = (PersonagemGuerreiro)personagem;
        
        if(personagem.getCanAction() && super.getCooldown() == 0){
            if(m.stamina >= this.estaminaNecessaria)
                return true;
        }
    return false;
    }
    
}
