/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import javax.swing.ImageIcon;
import jogopoo.Control.*;

/**
 *
 * @author tiago
 */
public class Parede implements ObserverColisao,Observer{
    public Coordenada inicio;
    public Coordenada fim;
    private HitBoxSquare hitbox;
    public Parede(Coordenada inicio, Coordenada fim,ColisionHandler col,Updater upd){
        this.fim = fim;
        this.inicio = inicio;
        col.registrarObservador(this);
        upd.registrarObservador(this);
        hitbox = new HitBoxSquare(inicio, fim);
    }
    @Override
    public HitBox getHitBox() {
        return (HitBox)this.hitbox;
    }

    @Override
    public void colide(ObserverColisao ObjColidido) {}

    @Override
    public void notificar() {}
    
}
