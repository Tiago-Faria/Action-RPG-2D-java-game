/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

/**
 *
 * @author Marcio55
 */
public class HabilidadeBolaDeFogo extends HabilidadeMago{
     
    public void usarHabilidade(PersonagemModel  personagem)
    {
        Mago m = (Mago)personagem;
        if(super.getCooldown() == 0){
            if(m.mana >= super.manaNecessaria)
            {
                Projetil p = new Projetil(personagem.posicao, dmg, sprite, velocidadeDisparo, duracao, raio);
                
            }
        }
    }
    
}