/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.View.Sprite;

/**
 *
 * @author Esdras Chaves
 */
public class Armadura extends Equipavel implements Defesa {
    private Defesa personagem = null;
    private float defesa; 
    
    public Armadura(int nivel) {
        super(nivel);
        this.defesa = 10 + 3*nivel;
        ArrayList<ImageIcon> iconeArma = new ArrayList<ImageIcon>();
        iconeArma.add(new ImageIcon("src/imagens/Armadura.png"));
        this.sprite= new Sprite(iconeArma,new Coordenada(50, 50));
    }
  
    public void setPersonagem(Defesa personagem) {
        this.personagem = personagem;
    }
    
    public Defesa getPersonagem() {
        return this.personagem;
    }
    
    public void setDefesa(float defesa) {
        this.defesa = defesa;
    }
    
    @Override
    public float devolveDefesa() {
        if(personagem==null) return this.defesa;
        return this.defesa + personagem.devolveDefesa();
    }

    @Override
    public float getDefesa() {
        return this.defesa;
    }
    
}
