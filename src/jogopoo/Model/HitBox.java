/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

/**
 *
 * @author tiago
 */
public class HitBox {
    Coordenada inicio;
    Float raio;
    
    boolean isColiding(HitBox h){
        if(inicio.getDistanceTo(h.inicio) <= this.raio+h.raio)return true;
        else return false;
    }
}
