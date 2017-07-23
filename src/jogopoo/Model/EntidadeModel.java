/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.awt.event.KeyEvent;
import jogopoo.Control.*;
import jogopoo.View.*;

/**
 *
 * @author tiago
 */
public abstract class EntidadeModel implements Observer,ObserverColisao{
    public Coordenada posicao;
    protected float hp;
    protected float dano;
    protected float velocidade = 5;
    public float defesa;
    protected float vel_ataque;
    protected String nome;
    protected float hp_max;
    protected int nivel;
    public HitBoxCircle hitbox;
    
    EntidadeView View;
    public EntidadeModel(Coordenada pos, EntidadeView view,float raioHitbox){
        this.posicao = pos;
        this.View = view;
        this.hitbox = new HitBoxCircle(posicao, raioHitbox);
        Application.Application.updater.registrarObservador(this);
        Application.Application.colisionHandler.registrarObservador(this);
        
    }
    @Override
    public void notificar() {
        update();
        View.draw();
    }
    
    public void update(){}
    public void receberDano(float dano){
        this.hp -= Math.abs(dano-getDefesa());
    }
    public abstract float getDefesa();
    public abstract void movimentar();

    @Override
    public HitBoxCircle getHitBox() {
        return this.hitbox;
    }

    public float getVel_ataque() {
        return vel_ataque;
    }

    public void setVel_ataque(float vel_ataque) {
        this.vel_ataque = vel_ataque;
    }
    
    

    @Override
    public void colide(ObserverColisao objColidido) {}

    
    
}
