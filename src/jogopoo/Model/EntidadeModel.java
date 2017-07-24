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
    public Efeito[] efeitos;
    
    EntidadeView View;
    public EntidadeModel(Coordenada pos, EntidadeView view,float raioHitbox){
        this.posicao = pos;
        this.View = view;
        this.hitbox = new HitBoxCircle(posicao, raioHitbox);
        Application.Application.updater.registrarObservador(this);
        Application.Application.colisionHandler.registrarObservador(this);
	efeitos = new Efeito[4];
        for(Efeito e: efeitos)
            e=null;
        
    }
    
        @Override
    public void setHitBoxColided(HitBox hitBox) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HitBox getHitBoxColided() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public void notificar() {
	for(Efeito e: efeitos) {
            if(e != null)
                e.updateEfeito();
        }
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
   
    public void setLentidao() {
        if(efeitos[0] == null) {
            efeitos[0] = new EfeitoLentidao(this);
        } else {
            efeitos[0].zeraContador();
        }
    }
    
    public void setQueimadura() {
        if(efeitos[1] == null) {
            efeitos[1] = new EfeitoQueimadura(this);
        } else {
            efeitos[0].zeraContador();
        }
    }
    
    public void setEnvenenamento() {
        if(efeitos[2] == null) {
            efeitos[2] = new EfeitoEnvenenamento(this);
        } else {
            efeitos[2].zeraContador();
        }
    }
    
    public void setEnraizamento() {
        if(efeitos[3] == null) {
            efeitos[3] = new EfeitoEnraizado(this);
        } else {
            efeitos[3].zeraContador();
        }
    }

    @Override
    public void colide(ObserverColisao objColidido) {}

    public abstract void morrer();
    
}
