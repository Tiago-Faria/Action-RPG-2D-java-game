/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.View;

import jogopoo.Application;

/**
 *
 * @author tiago
 */
public class EntidadeView {
    private Sprite sprite;
    public EntidadeView(Sprite s){
        this.sprite = s;
    }
    public EntidadeView(){}
    public void draw(){
        this.sprite.draw(Application.bbg, Application.Application);
    }
    public void setSprite(Sprite s){
        this.sprite = s;
    }
}
