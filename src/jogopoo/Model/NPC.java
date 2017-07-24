/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.util.ArrayList;
import jogopoo.Control.Application;
import jogopoo.Control.ObserverColisao;
import jogopoo.View.EntidadeView;

/**
 *
 * @author tiago
 */
public class NPC extends EntidadeModel{
    Item drop;
    float xp;
    public ArrayList<Item> itens = new ArrayList<Item>();
    public ArrayList<Double> range = new ArrayList<Double>();
    public Coordenada posicaoPersonagem;
    public NPC(Coordenada pos, EntidadeView view, float raioHitbox,Coordenada pers) {
        super(pos, view, raioHitbox);
        this.posicaoPersonagem = pers;
    }
    public Item ChooseItem(){
        double i = Math.random();
        int itemIndex = 0;
        while(itemIndex < range.size() && range.get(itemIndex)< i){
            itemIndex++;
        }
        if(--itemIndex >= itens.size())return null;
        return itens.get(itemIndex);
    }
    @Override
    public float getDefesa() {
        return this.defesa;
    }

    @Override
    public void movimentar() {}
    public void morrer(){
        //new Loot(ChooseItem(),super.posicao,this.xp);
        Application.Application.updater.removerObservador(this);
        Application.Application.colisionHandler.removerObservador(this);
                
    }
    
    
}
