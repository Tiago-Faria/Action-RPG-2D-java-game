package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.View.Sprite;

public class ArmaMagoLivro extends ArmaMago {
    
    public ArmaMagoLivro(int nivel) {
        super(nivel);
        this.velocidadeDisparo = (float) (7 + 0.8*nivel);
        ArrayList<ImageIcon> iconeArma = new ArrayList<ImageIcon>();
        iconeArma.add(new ImageIcon("src/imagens/Livro.png"));
        this.sprite= new Sprite(iconeArma,new Coordenada(50, 50));
    }
    
    public void usarArma(PersonagemModel personagem) {
        if (this.getCooldown() == 0) {
            float value = super.getDano(personagem);
            ObjetoProjetil p = new ObjetoProjetil(personagem.posicao, value, imagens, velocidadeDisparo, duracao,personagem.lastDirectionX,personagem.lastDirectionY, raio);
            this.setCooldown(9);
        }
    }

    @Override
    public void usarArma(PersonagemModel personagem, int direcaox, int direcaoy, float dano) {
        personagem.CooldownAtaque = (int) (60 - personagem.getVel_ataque() - this.velocidadeDisparo);
                ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();
                imagens.add(new ImageIcon("src/imagens/fogo1.png"));
                imagens.add(new ImageIcon("src/imagens/fogo2.png"));
                imagens.add(new ImageIcon("src/imagens/fogo3.png"));
                if(direcaox ==0||direcaoy == 0){
                    if(direcaox == 0){
                        new ObjetoProjetil(personagem.posicao, (float) (dano*0.6), imagens,this.velocidadeDisparo,150,-1, direcaoy,8 );
                        new ObjetoProjetil(personagem.posicao, (float) (dano*0.6), imagens,this.velocidadeDisparo,150,1, direcaoy,8 );
                    }
                    else{
                       new ObjetoProjetil(personagem.posicao, (float) (dano*0.6), imagens,this.velocidadeDisparo,150,direcaox, -1,8 );
                       new ObjetoProjetil(personagem.posicao, (float) (dano*0.6), imagens,this.velocidadeDisparo,150,direcaox, 1,8 );
                    }                     
                }
                else{
                    new ObjetoProjetil(personagem.posicao, (float) (dano*0.6), imagens,this.velocidadeDisparo,150,0, direcaoy,8 );
                    new ObjetoProjetil(personagem.posicao, (float) (dano*0.6), imagens,this.velocidadeDisparo,150,direcaox, 0,8 );
                }        
    }
    @Override
    public void notificar() {
        if(this.getCooldown()>0){
            this.decreaseCooldown();
        }
    }
}
