/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Control;

import jogopoo.View.*;
import jogopoo.Engine.*;
import jogopoo.Model.*;

/**
 *
 * @author tiago
 */
public class EntidadeController implements Observer,Controller{
    EntidadeView View;
    EntidadeModel Model;
    public EntidadeController(EntidadeView v,EntidadeModel m,Subject s){
        this.View = v;
        this.Model = m;
        s.registrarObservador(this);
    }
    public void notificar() {
        this.Model.update();
        this.View.draw();
    }
    
}
