package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.View.Sprite;

public class PocaoMana extends Consumivel {

    public PocaoMana() {
        ArrayList<ImageIcon> iconeArma = new ArrayList<ImageIcon>();
        iconeArma.add(new ImageIcon("src/imagens/PoteMana.png"));
        this.sprite= new Sprite(iconeArma,new Coordenada(50, 50));
    }

    public void consumir(PersonagemModel personagem) {
        if (personagem.getInventario().getItems().contains(this)) {
            if (personagem.getClass().getName().equals("jogopoo.Model.Mago"))
                ((PersonagemMago)personagem).regenerarMana(60);
           
        }
    }
    
}
