/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Control;

import jogopoo.Model.*;

/**
 *
 * @author tiago
 */
public interface ObserverColisao {
    public HitBox getHitBox();
    public void colide(ObserverColisao ObjColidido);
}
