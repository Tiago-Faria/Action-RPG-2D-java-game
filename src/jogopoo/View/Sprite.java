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
public class Sprite{
    private ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();
    private int index = 0;
    private EntidadeModel entidade;
    public Coordenada Posicao;
    
    public Sprite(ArrayList<ImageIcon> sprite,Coordenada c){
        this.imagens = sprite;
        this.Posicao = c;
    }
    public void draw(Graphics bbg,Application a){
        if(++index > imagens.size())index = 0;
        bbg.drawImage(this.imagens.get(index).getImage(),(int)Posicao.x,(int)Posicao.y,a);
    }
    
    
    
}
