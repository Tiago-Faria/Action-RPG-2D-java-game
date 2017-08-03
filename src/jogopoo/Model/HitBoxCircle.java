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
public class HitBoxCircle implements HitBox{
    
    public Coordenada inicio;
    Float raio;
    HitBoxCircle(Coordenada inicio,Float raio){
        this.inicio = inicio;
        this.raio = raio;
    }
    
    public boolean isColiding(HitBoxCircle h){
        if(inicio.getDistanceTo(h.inicio) <= this.raio+h.raio)return true;
        else return false;
    }
    
    
    @Override
    public boolean isColiding(HitBoxSquare h) {
        return h.isColiding(this);
    }

    @Override
    public boolean isColiding(HitBox hitBox) {
        if(hitBox.getClass().getName().equalsIgnoreCase("jogopoo.model.HitBoxCircle")){
            return isColiding((HitBoxCircle)hitBox);
        }
        else return isColiding((HitBoxSquare)hitBox);
    }
    
}
