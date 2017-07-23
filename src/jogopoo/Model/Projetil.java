/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import jogopoo.Control.Application;
import jogopoo.Control.Observer;
import jogopoo.Control.ObserverColisao;
import jogopoo.Control.Updater;
import jogopoo.View.Sprite;

/**
 *
 * @author Marcio55
 */
public class Projetil implements Observer, ObserverColisao{
    private HitBox hitbox;
    private float dmg;
    private float velocidade;
    private Coordenada coordenada;
    private int duracao;
    private int countDuracao;
    Updater updt;
    
    /* imagem */        
            
    public Projetil(Coordenada coordenadaP,float dmg,Sprite sprite,float velocidade,int duracao,float raio){
        this.updt = Application.Application.updater;
        this.dmg = dmg;
        this.coordenada = coordenada;
        this.velocidade = velocidade;
        this.duracao = duracao;
        this.countDuracao = duracao;
        hitbox = new HitBoxCircle(coordenadaP,raio);
        updt.registrarObservador(this);
    }

    @Override
    public HitBox getHitBox(){
        return hitbox;
    }

    @Override
    public void colide(ObserverColisao ObjColidido) {
        
    }

    @Override
    public void notificar() {
        countDuracao--;    
        if(countDuracao<0)
        {
            updt.removerObservador(this);
            /*destroi objeto*/
        }
    }
}
