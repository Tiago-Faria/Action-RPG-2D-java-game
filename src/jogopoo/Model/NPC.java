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
    int xp;
    public ArrayList<Item> itens = new ArrayList<Item>();
    public ArrayList<Double> range = new ArrayList<Double>();
    public Coordenada posicaoPersonagem;
    protected int CooldownAtaque;
    
    public NPC(Coordenada pos, EntidadeView view, float raioHitbox,Coordenada pers) {
        super(pos, view, raioHitbox);
        this.posicaoPersonagem = pers;
        itens.add(new ArmaMagoVarinha(0));
        itens.add(new ArmaMagoLivro(0));
        itens.add(new ArmaMagoCajado(0));
        itens.add(new ArmaGuerreiroMachado(0));
        itens.add(new ArmaGuerreiroClava(0));
        //itens.add(new ArmaGuerreiroFacasDeArremesso(0));
        itens.add(new ArmaGuerreiroEspada(0));
        //itens.add(new ArmaArqueiroBesta(0));
       // itens.add(new ArmaArqueiroArcoFlecha(0));
        itens.add(new AnelDeCritico(0, (float) 0.5));
        itens.add(new AnelDeVelocidadeDeAtaque(0, 5));
        itens.add(new Armadura(0));
        itens.add(new BotaVelocidade(0, 5));
        itens.add(new ColarCura(0, 5));
        itens.add(new PocaoCura());
        itens.add(new PocaoMana());
        
        for(int i = 0;i<itens.size();i++){
            range.add(new Double((double)(i+1)/itens.size()));
            
            System.out.println(range.get(i));
        }
    }
    public Item ChooseItem(){
        double i = Math.random();
        int itemIndex = 0;
        while(itemIndex < range.size() && range.get(itemIndex)< i){
            itemIndex++;
        }
        if(itemIndex >= itens.size())return null;
        return itens.get(itemIndex);
    }
    @Override
    public float getDefesa() {
        return this.defesa.getDefesa();
    }
 //batata
    @Override
    public void movimentar() {}
    public void morrer(){
        new Loot(ChooseItem(),super.posicao,  this.xp);
        Application.Application.updater.removerObservador(this);
        Application.Application.colisionHandler.removerObservador(this);
                
    }


    
    
}
