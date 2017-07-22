/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Control;

import jogopoo.Model.Coordenada;

/**
 *
 * @author tiago
 */
public interface ObserverPosicaoPersonagem {
    public void notificarPosicao(Coordenada c);
}
