/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import jogopoo.Control.Observer;
import jogopoo.Control.ObserverColisao;

/**
 *
 * @author marcio
 */
public abstract class ObjetoConcreto implements ObserverColisao, Observer {
    
    
    
    public void setHitBoxColided(HitBox hitbox) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public HitBox getHitBoxColided(){
        return null;
    }
}
