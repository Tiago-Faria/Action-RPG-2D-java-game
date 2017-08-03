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
public class ObjetoParede extends ObjetoConcreto {
    public Coordenada inicio;
    public Coordenada fim;
    private HitBoxSquare hitbox;
    public ObjetoParede(Coordenada inicio, Coordenada fim,ColisionHandler col,Updater upd){
        this.fim = fim;
        this.inicio = inicio;
        col.registrarObservador(this);
        Application.Application.updater.registrarObservador(this);
        hitbox = new HitBoxSquare(inicio, fim);
        Application.colisionHandler.registrarObservador(this);
    }
    @Override
    public HitBox getHitBox() {
        return (HitBox)this.hitbox;
    }

    @Override
    public void colide(ObserverColisao ObjColidido) {}

    @Override
    public void notificar() {
         }

    
    
}
