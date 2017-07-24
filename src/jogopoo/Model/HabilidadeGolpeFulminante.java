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
public class HabilidadeGolpeFulminante extends HabilidadesGuerreiro{
    
    protected float dmg;
    protected int duracao;
    protected float raio;
    protected float velocidadeDisparo;
    
    public void usarHabilidade(PersonagemModel  personagem)
    {
        if(super.CanUseHabilidade(personagem)){
            ObjetoAtaque a = new ObjetoAtaque(dmg,personagem.posicao, duracao, raio);
        }
    }
}
