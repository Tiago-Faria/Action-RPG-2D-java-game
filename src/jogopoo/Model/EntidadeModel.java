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
public class Entidade implements Observer{
    private Sprite sprite;
    public int x;
    public int y;
    private float hp;
    private float dano;
    private float velocidade = 50;
    private float vel_ataque;
    private String nome;
    private float hp_max;
    private int nivel;
    Entidade(Subject s){
        s.registrarObservador(this);
    }
    

    @Override
    public void atualizar() {
       
    }
    
}
