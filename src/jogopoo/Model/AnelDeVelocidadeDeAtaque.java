package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.View.Sprite;

public class AnelDeVelocidadeDeAtaque extends Acessorio {
    
    public AnelDeVelocidadeDeAtaque(int nivel, float valor) {
        super(nivel, valor, 0, 0);
        ArrayList<ImageIcon> iconeArma = new ArrayList<ImageIcon>();
        iconeArma.add(new ImageIcon("src/imagens/Anel2.png"));
        this.sprite= new Sprite(iconeArma,new Coordenada(50, 50));
    }
    
    @Override
    public void equipar(PersonagemModel personagem) {
        if (personagem.getClass().getName().equals("jogopoo.Model.Mago"))
            ((PersonagemMago)personagem).setMana_regen(super.getMp_regen());
        personagem.setVel_ataque(super.getVelocidade());
        personagem.setPc_crit(super.getPc_crit());
    }
}
