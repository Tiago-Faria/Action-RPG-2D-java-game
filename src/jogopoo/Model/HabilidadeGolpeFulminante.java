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
public class HabilidadeGolpeFulminante extends HabilidadesGuerreiro{
    
    public HabilidadeGolpeFulminante() {
        
        Application.Application.updater.registrarObservador(this);
        super.duracao = 20;
        super.velocidaDoDisparo = 7;
        this.raio = 20;
        this.dmg = 30;
        
        
        //left animation
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/left/a1.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/left/a2.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/left/a3.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/left/a4.png"));
        //top animation
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/top/a1.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/top/a2.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/top/a3.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/top/a4.png"));
        //right animation
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/right/a1.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/right/a2.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/right/a3.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/right/a4.png"));
        //bottom animation
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/bottom/a1.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/bottom/a2.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/bottom/a3.png"));
        imagens.add(new ImageIcon("src/imagens/AtaqueGuerreiro/bottom/a4.png"));
        
        
        this.tamanhoSprite = 4;
    
    
    }
    
    
    
    public void usarHabilidade(PersonagemModel  personagem)
    {
        if(super.CanUseHabilidade(personagem)){
            
            ObjetoAtaque arma = new ObjetoAtaque(personagem.posicao,this.dmg + personagem.dano,imagens,tamanhoSprite,
                     super.duracao, personagem.lastDirectionX,personagem.lastDirectionY, super.raio);
            super.setCooldown(20);
        }
    }
}
