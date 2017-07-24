/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import jogopoo.Control.Application;
import jogopoo.Control.Observer;
import jogopoo.Control.ObserverColisao;

/**
 *
 * @author Esdras Chaves
 */
public class Loot implements Observer, ObserverColisao{
    private Item item;
    private int xp;
    private HitBox hitbox;
    
    public Loot(Item item, Coordenada c, int xp) {
        this.item = item;
        this.xp = xp;
        this.hitbox = new HitBoxCircle(c, 5.0f);
        Application.Application.updater.registrarObservador(this);
    }

    @Override
    public void notificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HitBox getHitBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void colide(ObserverColisao ObjColidido) {
        if(ObjColidido.getClass().getName().equalsIgnoreCase("jogopoo.Model.PersonagemModel")) {
            PersonagemModel personagem = (PersonagemModel) ObjColidido;
            personagem.setLoot(item, xp);
        }
    }

    @Override
    public void setHitBoxColided(HitBox hitBox) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HitBox getHitBoxColided() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
