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
public class Coordenada {
    public float x;
    public float y;
    public Coordenada(float x,float y){
        this.x = x;
        this.y = y;
    }
    public double getDistanceTo(Coordenada c){
        return Math.sqrt(Math.abs((this.x-c.x)*(this.x-c.x)+(this.y-c.y)*(this.y-c.y)));
    }
}
