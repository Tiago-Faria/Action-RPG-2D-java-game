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
public class HabilidadeAdrenalina extends HabilidadesArqueiro{
    
    
    public void usarHabilidade(PersonagemModel  personagem)
    {
        if(super.CanUseHabilidade(personagem)){
            //criar buff
        }
    }
    
}