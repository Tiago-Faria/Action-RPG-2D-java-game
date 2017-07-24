/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.View.EntidadeView;
import jogopoo.View.Sprite;

/**
 *
 * @author tiago
 */
public class Goblin extends NPC{
    private final float distanciaAtaque = 100;
    public Goblin(Coordenada pos,Coordenada pers) {
        super(pos, new EntidadeView(), 16, pers);
        ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();
        imagens.add(new ImageIcon("src/imagens/goblin.png"));
        Sprite spr = new Sprite(imagens, pos);
        super.View.setSprite(spr);
        
        this.velocidade *= 0.7;
    }
    public void update(){
        if(super.posicao.getDistanceTo(posicaoPersonagem) < this.distanciaAtaque){
            Coordenada direcao = this.posicao.getDirectionTo(posicaoPersonagem);
            super.posicao.x += super.velocidade*direcao.x;
            super.posicao.y -= super.velocidade*direcao.y;
        }
    }
}
