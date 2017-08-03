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
public class HabilidadeGolpeGiratorio extends HabilidadesGuerreiro{
   
    public HabilidadeGolpeGiratorio() {
        
        Application.Application.updater.registrarObservador(this);
        super.duracao = 8;
        super.velocidaDoDisparo = 7;
        this.raio = 60;
        this.dmg = 30;
        
        
        //left animation
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/left/a1.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/top/a2.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/right/a3.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/bottom/a4.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/left/a1.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/top/a2.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/right/a3.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/bottom/a4.png"));
        
        
        this.tamanhoSprite = 8;
    
    
    }
    
    
    
    public void usarHabilidade(PersonagemModel  personagem)
    {
        if(super.CanUseHabilidade(personagem)){
            
            ObjetoAtaque arma = new ObjetoAtaque(personagem.posicao,this.dmg + personagem.dano,imagens,
                     super.duracao, personagem.lastDirectionX,personagem.lastDirectionY, super.raio);
            super.setCooldown(20);
        }
    }
}
