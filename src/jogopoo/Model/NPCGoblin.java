/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.Control.Application;
import jogopoo.Control.ObserverColisao;
import jogopoo.View.EntidadeView;
import jogopoo.View.Sprite;

/**
 *
 * @author tiago
 */
public class NPCGoblin extends NPC{
    private final float distanciaAtaque = 200;
    public NPCGoblin(Coordenada pos,Coordenada pers) {
        super(pos, new EntidadeView(), 16, pers);
        ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();
        imagens.add(new ImageIcon("src/imagens/goblin.png"));
        Sprite spr = new Sprite(imagens, pos);
        super.View.setSprite(spr);
        this.hp_max = 200;
        this.dano = 50;
        this.hp = hp_max;
        this.velocidade *= 0.7;
        this.xp = 2;
    }
    public void update(){
        if(hp <= 0 )morrer();
        if(CooldownAtaque>0)CooldownAtaque--;
        if(super.posicao.getDistanceTo(posicaoPersonagem) < this.distanciaAtaque || hp < hp_max){
            Coordenada direcao = this.posicao.getDirectionTo(posicaoPersonagem);
            super.posicao.x += super.velocidade*direcao.x;
            super.posicao.y -= super.velocidade*direcao.y;
        }
    }
    public void colide(ObserverColisao objColidido) {
        if(objColidido.getClass().getSuperclass().getName().equalsIgnoreCase("jogopoo.model.PersonagemModel") && CooldownAtaque == 0){
            this.CooldownAtaque = Application.FPS;
            ((EntidadeModel)objColidido).receberDano(this.dano);
        }
            
    }
}
