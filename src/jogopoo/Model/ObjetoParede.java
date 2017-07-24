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
public class ObjetoParede implements ObserverColisao,Observer{
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
    public void setHitBoxColided(HitBox hitbox) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public HitBox getHitBoxColided(){
        return null;
    }

    @Override
    public void colide(ObserverColisao ObjColidido) {}

    @Override
    public void notificar() {
         }

    
    
}
