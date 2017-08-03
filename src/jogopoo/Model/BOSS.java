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
public class BOSS extends NPC{
    private static int RaioHitBox = 47;
    private boolean triggered = false;
    private Coordenada Alvo;
    private Coordenada topLeft;
    private Coordenada downRight;
    private Coordenada direcao;
    private Sprite spr;
    private Sprite sprgrr ;
    public BOSS(Coordenada pos,Coordenada pers) {
        super(pos, new EntidadeView(), RaioHitBox, pers);
        this.CooldownAtaque=0;
        this.dano = 80;
        this.defesa.setDefesa(40);
        this.hp_max = 500;
        this.hp = hp_max;
        this.velocidade = 5;
        this.xp = 10;
        Alvo = new Coordenada(pos.x, pos.y);
        this.downRight = new Coordenada(pos.x - 275, pos.y+225);
        this.topLeft = new Coordenada(pos.x  + 275,pos.y-225);  
        
        ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();
        imagens.add(new ImageIcon("src/imagens/boss.png"));
        this.spr = new Sprite(imagens, pos);
        super.View.setSprite(spr);
        
        ArrayList<ImageIcon> imagensgrr = new ArrayList<ImageIcon>();
        imagensgrr.add(new ImageIcon("src/imagens/bossgrr.png"));
        sprgrr = new Sprite(imagensgrr, pos);
    }
    public void update(){
        if(this.CooldownAtaque>0)this.CooldownAtaque--;
        if(hp <= 0)morrer();
        if(hp<hp_max){
            triggered = true;
            View.setSprite(sprgrr);
            
        }
        if(triggered)movimentar();
        updateSpeed();
    }
    public void colide(ObserverColisao objColidido) {
        if(objColidido.getClass().getSuperclass().getName().equalsIgnoreCase("jogopoo.model.PersonagemModel") && this.CooldownAtaque==0)
        {
            ((EntidadeModel)objColidido).receberDano(this.dano);
            this.CooldownAtaque = Application.FPS;
        }
    }
    public void movimentar(){
        while(super.posicao.getDistanceTo(Alvo) < 2*super.velocidade){
                int x = (int) (Math.random()*(downRight.x-topLeft.x));
                int y = (int) (Math.random()*(downRight.y-topLeft.y));
                Alvo.x = topLeft.x + x;
                Alvo.y = topLeft.y + y;
                direcao = posicao.getDirectionTo(Alvo);
        }
        super.posicao.x += super.velocidade*this.direcao.x;
        super.posicao.y -= super.velocidade*this.direcao.y;
    }

    private void updateSpeed() {
        velocidade = (float) (5 + (hp_max -  hp)*0.02);
        
    }
}
