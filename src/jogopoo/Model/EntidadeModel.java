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
    protected Defesa defesa;
    protected float vel_ataque;
    protected String nome;
    protected float hp_max;
    public int nivel;
    public HitBox hitBoxColided;
    public HitBoxCircle hitbox;
    public Efeito[] efeitos;
    
    EntidadeView View;
    public EntidadeModel(Coordenada pos, EntidadeView view,float raioHitbox){
        this.posicao = pos;
        this.View = view;
        this.hitbox = new HitBoxCircle(posicao, raioHitbox);
        Application.Application.updater.registrarObservador(this);
        Application.Application.colisionHandler.registrarObservador(this);
	efeitos = new Efeito[6];
        for(Efeito e: efeitos)
            e=null;
        this.defesa = new DefesaPersonagem();
        
    }

    public float getHp() {
        return hp;
    }

    public float getHp_max() {
        return hp_max;
    }
    
        @Override
    public void setHitBoxColided(HitBox hitBoxColided) {
        this.hitBoxColided = hitBoxColided;
    }

    @Override
    public HitBox getHitBoxColided() {
        return this.hitBoxColided;
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
        if(!(this.defesa.devolveDefesa() >= dano))
            this.hp -= Math.abs(dano-this.defesa.devolveDefesa());
        System.out.println("VIda" + this.hp);
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
    public void setMoveSpeed() {
        if(efeitos[4] == null) {
            efeitos[4] = new EfeitoMoveSpeed(this);
        } else {
            efeitos[4].zeraContador();
        }
    }
    
    public void setAttackSpeed() {
        if(efeitos[5] == null) {
            efeitos[5] = new EfeitoAtaqueSpeed(this);
        } else {
            efeitos[5].zeraContador();
        }
    }

    @Override
    public void colide(ObserverColisao objColidido) {}

    public abstract void morrer();
    
}
