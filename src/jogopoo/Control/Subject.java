/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Control;

import jogopoo.Control.Observer;
import jogopoo.Model.Coordenada;

/**
 *
 * @author tiago
 */
public interface Subject {
    void registrarObservador(Observer o );
    void removerObservador(Observer o );
    void notificarObservadores();
}
