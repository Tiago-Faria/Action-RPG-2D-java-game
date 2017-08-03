package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.View.Sprite;

public class PocaoCura extends Consumivel {
     ArrayList<ImageIcon> iconeArma = new ArrayList<ImageIcon>();
    public PocaoCura() {
        iconeArma.add(new ImageIcon("src/imagens/PoteVida.png"));
        this.sprite= new Sprite(iconeArma,new Coordenada(50, 50));
    }

    @Override
    public void consumir(PersonagemModel personagem) {
        if (personagem.getInventario().getItems().contains(this)) {
            personagem.regenerarVida(60);
        }
        
        System.out.println("Vida dps de recuperar= " + personagem.hp);
    }
    
}