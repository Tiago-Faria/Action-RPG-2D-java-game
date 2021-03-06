/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.View;

import jogopoo.Control.Application;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;
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
        if(++index >= imagens.size())index = 0;
        
        bbg.drawImage(imagens.get(index).getImage(),(int)Posicao.x - imagens.get(index).getImage().getWidth(a)/2,(int)Posicao.y- imagens.get(index).getImage().getHeight(a)/2,a);
    }
    public void draw(Graphics bbg,Application a,int start,int tamanho){
        int f = start+tamanho;
        if(index < start)index = start;
        if(index >= f)index = start;
        
        bbg.drawImage(imagens.get(index).getImage(),(int)Posicao.x - imagens.get(index).getImage().getWidth(a)/2,(int)Posicao.y- imagens.get(index).getImage().getHeight(a)/2,a);
        index++;
    }
    
    public ImageIcon getFirstImage() {
       
        if(imagens.size() > 0)return imagens.get(0);
        return null;
        
    }
    
}