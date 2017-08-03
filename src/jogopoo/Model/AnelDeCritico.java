package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.View.Sprite;

public class AnelDeCritico extends Acessorio {
    
    public AnelDeCritico(int nivel, float valor) {
        super(nivel, 0, valor, 0);ArrayList<ImageIcon> iconeArma = new ArrayList<ImageIcon>();
        iconeArma.add(new ImageIcon("src/imagens/Anel1.png"));
        this.sprite= new Sprite(iconeArma,new Coordenada(50, 50));
    }
    
}
