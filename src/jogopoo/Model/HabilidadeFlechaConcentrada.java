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
public class HabilidadeFlechaConcentrada extends HabilidadesArqueiro{
    
    public HabilidadeFlechaConcentrada() {
        Application.Application.updater.registrarObservador(this);
        super.duracao = 20;
        super.velocidaDoDisparo = 7;
        this.raio = 8;
        imagens.add(new ImageIcon("src/imagens/confusion.png"));
      
    }
    
    public void usarHabilidade(PersonagemModel  personagem)
    {
        
        if(super.CanUseHabilidade(personagem)){
            super.cooldown = this.duracao;
            ObjetoProjetil p = new ObjetoProjetil(personagem.posicao, dmg,imagens, velocidaDoDisparo, duracao,
                    personagem.lastDirectionX,personagem.lastDirectionY, raio, 3);
        }
    }

}
