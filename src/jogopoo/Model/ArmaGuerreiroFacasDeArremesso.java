package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.View.Sprite;


public class ArmaGuerreiroFacasDeArremesso extends ArmaArqueiro {
    
    public ArmaGuerreiroFacasDeArremesso(int nivel) {
        super(nivel);
        ArrayList<ImageIcon> iconeArma = new ArrayList<ImageIcon>();
        iconeArma.add(new ImageIcon("src/imagens/FacaArremesso.png"));
        this.sprite= new Sprite(iconeArma,new Coordenada(50, 50));
    }
    
    public void usarArma(PersonagemModel personagem) {
        if (this.getCooldown() == 0) {
            float value = super.getDano(personagem);
            ObjetoProjetil p = new ObjetoProjetil(personagem.posicao, value, imagens, velocidadeDisparo, duracao,personagem.lastDirectionX,personagem.lastDirectionY, raio);
            this.setCooldown(2);
        }
    }

    @Override
    public void usarArma(PersonagemModel ataque, int direcaox, int direcaoy, float dano) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void notificar() {
        if(this.getCooldown()>0){
            this.decreaseCooldown();
        }
    }
}
