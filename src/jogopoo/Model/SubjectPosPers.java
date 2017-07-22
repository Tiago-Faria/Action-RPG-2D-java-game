/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.util.ArrayList;
import jogopoo.Engine.*;

/**
 *
 * @author tiago
 */
public class SubjectPosPers{
    private static ArrayList<ObserverPosicaoPersonagem> inimigos = new ArrayList<ObserverPosicaoPersonagem>();

    public void registrarObservador(ObserverPosicaoPersonagem o) {
        inimigos.add(o);
    }


    public void removerObservador(ObserverPosicaoPersonagem o) {
        inimigos.remove(o);
    }

    public void notificarObservadores(Coordenada c) {
        for(ObserverPosicaoPersonagem o:inimigos){
            o.notificarPosicao(c);
        }
    }
    
}
