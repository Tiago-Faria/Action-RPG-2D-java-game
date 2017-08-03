/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import javax.swing.ImageIcon;
import jogopoo.Control.Application;

/**
 *
 * @author marcio
 */
public class HabilidadeAdrenalina extends HabilidadesArqueiro{
    
    public HabilidadeAdrenalina() {
        Application.Application.updater.registrarObservador(this);
        super.duracao = 20;
        }
      
    
    
    public void usarHabilidade(PersonagemModel  personagem)
    {
        
        if(super.CanUseHabilidade(personagem)){
            super.cooldown = this.duracao;
            personagem.setMoveSpeed();
            personagem.setAttackSpeed();
        }
    }
    
}
