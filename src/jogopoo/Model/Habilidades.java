package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.Control.Application;
import jogopoo.Control.Observer;
import jogopoo.View.EntidadeView;
import jogopoo.View.Sprite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Marcio55
 */
public abstract class Habilidades implements Observer{
    
    protected float dmg;
    protected int duracao;
    protected float raio = 10;
    protected float velocidaDoDisparo;
    protected int cooldown = 0;
    ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();
    protected Sprite sprite;
    protected int efeito;
    
    public abstract void usarHabilidade(PersonagemModel  personagem);

    public void update(){
        //if(cooldown>0){
         //   cooldown--;
        //}
    }
    public void notificar(){
        if(cooldown>0){
            cooldown--;
        }
    }
    
    public int getCooldown(){
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
    
}
