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
import jogopoo.View.*;

/**
 *
 * @author tiago
 */
public class NPCJavali extends NPC{
    private Coordenada Alvo;
    private Coordenada direcao;
    private boolean triggered;
    private int cooldownAtual;
    private final int cooldown = 2*Application.FPS;
    private final double distToTrigger = 200;
    private final float dano = 50;
    private int CooldownAtaque;
    public NPCJavali(Coordenada pos,Coordenada pers) {
        super(pos, new EntidadeView(), 24, pers);
        this.hp_max = 200;
        this.hp = hp_max;
        ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();
        imagens.add(new ImageIcon("src/imagens/boar.png"));
        Sprite spr = new Sprite(imagens, pos);
        super.View.setSprite(spr);
        Alvo = new Coordenada(0, 0);
        this.xp = 2;
        direcao = super.posicao.getDirectionTo(Alvo);
    }
    public void update(){
        if(hp <= 0)morrer();
        if(CooldownAtaque > 0)CooldownAtaque--;
        if(triggered == true){
            if(super.posicao.getDistanceTo(Alvo) < 2*super.velocidade){
                triggered = false;
                cooldownAtual = cooldown;
            }
            else movimentar();
        }
        else{
            if(cooldownAtual == 0 && super.posicao.getDistanceTo(super.posicaoPersonagem) <= distToTrigger ){
                triggered = true;
                Alvo.x = super.posicaoPersonagem.x;
                Alvo.y = super.posicaoPersonagem.y;
                direcao = super.posicao.getDirectionTo(Alvo);
            }
            else{
                if(cooldownAtual > 0)cooldownAtual--;
            }  
        }
    }
    public void movimentar(){
        super.posicao.x += super.velocidade*this.direcao.x;
        super.posicao.y -= super.velocidade*this.direcao.y;
    }
    
    public void colide(ObserverColisao objColidido) {
        if(objColidido.getClass().getSuperclass().getName().equalsIgnoreCase("jogopoo.model.PersonagemModel") && CooldownAtaque == 0){
            this.CooldownAtaque = Application.FPS;
            ((EntidadeModel)objColidido).receberDano(this.dano);
        }
            
    }
}
