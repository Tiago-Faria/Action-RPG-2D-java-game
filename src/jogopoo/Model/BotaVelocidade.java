package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.View.Sprite;

public class BotaVelocidade extends Acessorio {
    
    public BotaVelocidade(int nivel, float valor) {
        super(nivel, valor, 0, 0);
        ArrayList<ImageIcon> iconeArma = new ArrayList<ImageIcon>();
        iconeArma.add(new ImageIcon("src/imagens/BotaVelocidade.png"));
        this.sprite= new Sprite(iconeArma,new Coordenada(50, 50));
    }
    
}
