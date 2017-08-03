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
public class HabilidadeInvestida extends HabilidadesGuerreiro{
    
    
    
    private int velocidaDaInvestida;
    private int condition=0;
    
    public HabilidadeInvestida() {
        Application.Application.updater.registrarObservador(this);
        super.duracao = 10;
        this.velocidaDaInvestida= 10;
        this.raio = 8;
        super.dmg = 80;
        imagens.add(new ImageIcon("src/imagens/fogo1.png"));
        imagens.add(new ImageIcon("src/imagens/fogo2.png"));
        imagens.add(new ImageIcon("src/imagens/fogo3.png"));
        imagens.add(new ImageIcon("src/imagens/fogo4.png"));
        }
      
    
    
    public void usarHabilidade(PersonagemModel  personagem)
    {
        if(super.CanUseHabilidade(personagem) && this.condition==0){
            super.cooldown = 40;
            ObjetoInvestida p = new ObjetoInvestida(personagem.posicao, dmg,imagens, 
                    velocidaDaInvestida, duracao,
                    personagem.lastDirectionX,personagem.lastDirectionY, raio);
        }
    }
    
}
