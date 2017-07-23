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
public class HitBoxSquare implements HitBox{
    private Coordenada c1;
    private Coordenada c2;
    private float distHorizontal;
    private float distVertical;        
    public HitBoxSquare(Coordenada c1,Coordenada c2){
        this.c1 = c1;
        this.c2 = c2;
    }
    
    @Override
    public boolean isColiding(HitBoxCircle h){
        
        if(isColiding(h.inicio))return true;
        if(h.inicio.getDistanceTo(c1)<h.raio||
           h.inicio.getDistanceTo(c2)<h.raio||
           h.inicio.getDistanceTo(new Coordenada(c1.x, c2.y))<h.raio||
           h.inicio.getDistanceTo(new Coordenada(c2.x, c1.y))<h.raio)return true;
        if(isColiding(new Coordenada(h.inicio.x+h.raio, h.inicio.y))||
           isColiding(new Coordenada(h.inicio.x-h.raio, h.inicio.y))||
           isColiding(new Coordenada(h.inicio.x, h.inicio.y+h.raio))||
           isColiding(new Coordenada(h.inicio.x, h.inicio.y-h.raio))
          )return true;
        return false;
        /*System.out.println("Batata");
        distHorizontal = Math.abs(Math.abs(h.inicio.x - c1.x) +(c2.x - c1.x)/2);
        distVertical = Math.abs(Math.abs(h.inicio.y - c2.y) + (c1.y - c2.y)/2);
        
        if(distHorizontal > ((c2.x - c1.x)/2 + h.raio)) return false;
        if(distVertical > ((c1.y - c2.y)/2 + h.raio)) return false;
        System.out.println("Frango");
        return true;*/
    }

    @Override
    public boolean isColiding(HitBoxSquare h) {
        if(isColiding(h.c1)||
           isColiding(h.c2)||
           isColiding(new Coordenada(h.c1.x,h.c2.y))||
           isColiding(new Coordenada(h.c2.x,h.c1.y)))
                return true;
        else return false;
    }
    public boolean isColiding(Coordenada c){
        if(   c.x > this.c1.x && c.x < this.c2.x
           && c.y > this.c1.y && c.y < this.c2.y)return true;
        else return false;
    }

    public boolean isColiding(HitBox hitBox) {
        System.out.println("classe: "+hitBox.getClass().getName());
        if(hitBox.getClass().getName().equalsIgnoreCase("jogopoo.Model.HitBoxCircle")){
            return isColiding((HitBoxCircle)hitBox);
        }
        else return isColiding((HitBoxSquare)hitBox);
    }
    
}
