package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.View.Sprite;

public class ColarCura extends Acessorio {
    
    public ColarCura(int nivel, float valor) {
        super(nivel, 0, 0, valor);
        ArrayList<ImageIcon> iconeArma = new ArrayList<ImageIcon>();
        iconeArma.add(new ImageIcon("src/imagens/ColarCura.png"));
        this.sprite= new Sprite(iconeArma,new Coordenada(50, 50));
    }
    
}
