/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Control;

import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class ColisionHandler{
    private static ArrayList<ObserverColisao> objetos = new ArrayList<ObserverColisao>();
    public void registrarObservador(ObserverColisao o) {
        objetos.add(o);
    }

    public void removerObservador(ObserverColisao o) {
        objetos.remove(o);
    }
    
    public void notificarObservadores() {
        for(ObserverColisao u: objetos){
            for(ObserverColisao j: objetos){
                if(u.getHitBox().isColiding(j.getHitBox()))u.colide(j);
            }
        }
    }
    public static boolean isColiding(ObserverColisao o,String classe){
        for(ObserverColisao u: objetos){
            
            if(u.getClass().getName().equalsIgnoreCase(classe)){
                if(u.getHitBox().isColiding(o.getHitBox()))
                {
                    return true;
                }
            }
        }
        return false;
    }
}