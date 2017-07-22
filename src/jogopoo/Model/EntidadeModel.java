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
    
    EntidadeView View;
    public EntidadeModel(Updater updt, Coordenada pos, EntidadeView view){
        this.posicao = pos;
        this.View = view;
        updt.registrarObservador(this);
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
    public HitBox getHitBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void colide() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
