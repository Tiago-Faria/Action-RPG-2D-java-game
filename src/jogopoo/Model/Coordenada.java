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
    public double x;
    public double y;
    public Coordenada(double x,double y){
        this.x = x;
        this.y = y;
    }
    public double getDistanceTo(Coordenada c){
        return Math.sqrt(Math.abs((this.x-c.x)*(this.x-c.x)+(this.y-c.y)*(this.y-c.y)));
    }
    public double getDistanceTo(Coordenada c1,Coordenada c2){
        return Math.abs((c2.x-c1.x)*(c1.y-y)-(c1.x-x)*(c2.y-c1.y)) % c1.getDistanceTo(c2);
    }
    public Coordenada getDirectionTo(Coordenada p){
        return new Coordenada((p.x-x)/getDistanceTo(p),(y-p.y)/getDistanceTo(p));
    }
}
