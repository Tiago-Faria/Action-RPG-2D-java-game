/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.View;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;
import jogopoo.*;
import jogopoo.Engine.*;
import jogopoo.Model.*;

/**
 *
 * @author tiago
 */
public class Sprite implements Observer{
    private static ArrayList<Sprite> sprites = new ArrayList<Sprite>();
    private ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();
    private int index;
    private Entidade entidade;
    
    Sprite(Updater u){
        u.registrarObservador(this);
        sprites.add(this);
        this.index = 0;
    }
    public void atualizar() {
        if(++index > imagens.size())index = 0;
    }
    public void draw(Graphics bbg,Application a){
        bbg.drawImage(this.imagens.get(index).getImage(),entidade.x,entidade.y,a);
    }
    public static void atualizarSprites(){
        for(int i=0;i<sprites.size();i++){
            sprites.get(i).atualizar();
        }
    }
    public static void drawSprites(Graphics bgg,Application a){
        for(int i=0;i<sprites.size();i++){
            sprites.get(i).draw(bgg,a);
        }
    }
    
}
