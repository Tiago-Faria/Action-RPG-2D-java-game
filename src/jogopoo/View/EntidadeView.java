/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.View;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.Control.Application;

/**
 *
 * @author tiago
 */
public class EntidadeView {
    private Sprite sprite;
    private int tamanhoSprite = 0;
    public EntidadeView(Sprite s){
        this.sprite = s;
    }
    public EntidadeView(Sprite s, int tamanho){
        this.sprite = s;
        this.tamanhoSprite = tamanho;
    }
    public EntidadeView(){}
    
    public void setSprite(Sprite sprite){
        this.sprite = sprite;
    }
    public void draw(){
        this.sprite.draw(Application.bbg, Application.Application);          
    }
    
    public void drawL(){
        //Left
        this.sprite.draw(Application.bbg, Application.Application,0,this.tamanhoSprite);
    }
    public void drawT(){
        //Top
        this.sprite.draw(Application.bbg, Application.Application,this.tamanhoSprite,this.tamanhoSprite);
    }
    public void drawR(){
        //Right
        this.sprite.draw(Application.bbg, Application.Application,2*this.tamanhoSprite,this.tamanhoSprite);
    }
    public void drawD(){
        //Down
        this.sprite.draw(Application.bbg, Application.Application,3*this.tamanhoSprite,this.tamanhoSprite);
    }
}

