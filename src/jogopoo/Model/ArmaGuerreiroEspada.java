package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.Control.Application;
import jogopoo.View.Sprite;

public class ArmaGuerreiroEspada extends ArmaGuerreiro {
    
    public ArmaGuerreiroEspada(int nivel) {
        super(nivel);
        super.setDano(20);
        Application.Application.updater.registrarObservador(this);
        this.raio = 8;
        ArrayList<ImageIcon> iconeArma = new ArrayList<ImageIcon>();
        iconeArma.add(new ImageIcon("src/imagens/Espada.png"));
        this.sprite= new Sprite(iconeArma,new Coordenada(50, 50));
        this.dmg = 4;
        this.velocidadeDisparo = (float) (15 + 0.8*nivel);
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
    
    public void usarArma(PersonagemModel personagem) {
        if (this.getCooldown() == 0) {
            ObjetoAtaque arma = new ObjetoAtaque(personagem.posicao,this.getDano(personagem) + personagem.dano,imagens,tamanhoSprite,
                     super.duracao, personagem.lastDirectionX,personagem.lastDirectionY, super.raio);
            this.setCooldown(12);
        }
        
    }

    @Override
    public void usarArma(PersonagemModel personagem, int direcaox, int direcaoy, float dano) {
        ObjetoAtaque arma = new ObjetoAtaque(personagem.posicao,this.getDano(personagem),imagens,tamanhoSprite,
                     super.duracao, direcaox,direcaoy, super.raio);
            personagem.CooldownAtaque= ((int) (2*Application.FPS - this.velocidadeDisparo - personagem.getVel_ataque()));
    }

    @Override
    public void notificar() {
        if(this.getCooldown()>0){
            this.decreaseCooldown();
        }
    }
    
}
