package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.View.Sprite;

public class ArmaMagoVarinha extends ArmaMago {
    ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();
                
    public ArmaMagoVarinha(int nivel) {
        super(nivel);
        this.velocidadeDisparo = (float) (7 + 0.8*nivel);
        ArrayList<ImageIcon> iconeArma = new ArrayList<ImageIcon>();
        iconeArma.add(new ImageIcon("src/imagens/varinha.png"));
        this.sprite= new Sprite(iconeArma,new Coordenada(50, 50));
        imagens.add(new ImageIcon("src/imagens/fogo1.png"));
        imagens.add(new ImageIcon("src/imagens/fogo2.png"));
        imagens.add(new ImageIcon("src/imagens/fogo3.png"));
    }
    
    public void usarArma(PersonagemModel personagem) {
        if (this.getCooldown() == 0) {
            float value = super.getDano(personagem);
            ObjetoProjetil p = new ObjetoProjetil(personagem.posicao, value, imagens, velocidadeDisparo, duracao,personagem.lastDirectionX,personagem.lastDirectionY, raio);
            this.setCooldown(7);
        }
    }

    @Override
    public void usarArma(PersonagemModel personagem, int direcaox, int direcaoy,float dano) {
        personagem.CooldownAtaque = (int) (60 - personagem.getVel_ataque() - this.velocidadeDisparo);
                
                new ObjetoProjetil(personagem.posicao, dano, imagens,this.velocidadeDisparo, (int) (200/this.velocidadeDisparo),direcaox, direcaoy,8 );
    }
    @Override
    public void notificar() {
        if(this.getCooldown()>0){
            this.decreaseCooldown();
        }
    }
}
