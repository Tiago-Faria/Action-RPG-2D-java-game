/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Control;

import jogopoo.Control.Observer;
import java.util.ArrayList;

/**
 *
 * @author tiago
 */
public class Updater implements Subject{
    private static ArrayList<Observer> updaters = new ArrayList<Observer>();
    public void registrarObservador(Observer o ){
        updaters.add(o);
    }
    public void removerObservador(Observer o ){
        updaters.remove(o);
    }
    public void notificarObservadores(){
        ArrayList<Observer> updatersCopy = (ArrayList<Observer>) updaters.clone();
        for(int i = 0;i < updatersCopy.size();i++){
            Observer observador = (Observer) updatersCopy.get(i);
            observador.notificar();
        }
    }
}
