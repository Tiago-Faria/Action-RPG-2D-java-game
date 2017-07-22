/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.awt.event.KeyEvent;
import jogopoo.Application;
import jogopoo.Engine.*;
import jogopoo.View.*;

/**
 *
 * @author tiago
 */
public abstract class EntidadeModel{
    public Coordenada posicao;
    protected float hp;
    protected float dano;
    protected float velocidade = 50;
    public float defesa;
    protected float vel_ataque;
    protected String nome;
    protected float hp_max;
    protected int nivel;
    
    EntidadeModel(Coordenada pos){
        this.posicao = pos;
    }
    public void update(){
        
    }
    public void receberDano(float dano){
        this.hp -= Math.abs(dano-getDefesa());
    }
    public abstract float getDefesa();
    public abstract void movimentar();
    
}
