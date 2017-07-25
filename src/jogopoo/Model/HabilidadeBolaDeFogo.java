/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.Control.Application;
import jogopoo.View.Sprite;

/**
 *
 * @author Marcio55
 */
public class HabilidadeBolaDeFogo extends HabilidadesMago{
        
        public HabilidadeBolaDeFogo() {
        Application.Application.updater.registrarObservador(this);
        super.duracao = 20;
        super.velocidaDoDisparo = 7;
        this.raio = 8;
        imagens.add(new ImageIcon("src/imagens/fogo1.png"));
        imagens.add(new ImageIcon("src/imagens/fogo2.png"));
        imagens.add(new ImageIcon("src/imagens/fogo3.png"));
        }
      
    
    
    public void usarHabilidade(PersonagemModel  personagem)
    {
        
        if(super.CanUseHabilidade(personagem)){
            super.cooldown = this.duracao;
            ObjetoProjetil p = new ObjetoProjetil(personagem.posicao, dmg,imagens, velocidaDoDisparo, duracao,
                    personagem.lastDirectionX,personagem.lastDirectionY, raio,efeito);
        }
    }

    
}