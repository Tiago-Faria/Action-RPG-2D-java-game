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
public abstract class HabilidadesArqueiro extends Habilidades{

    protected int manaNecessaria;
    public boolean CanUseHabilidade(PersonagemModel  personagem){
        PersonagemArqueiro m = (PersonagemArqueiro)personagem;
        if(personagem.getCanAction() && super.getCooldown() == 0){
            if(m.mana >= this.manaNecessaria)
                return true;
        }
    return false;
    }
    
}
