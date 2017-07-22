/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Control;

import jogopoo.Engine.Subject;
import jogopoo.Model.EntidadeModel;
import jogopoo.Model.PersonagemModel;
import jogopoo.Model.SubjectPosPers;
import jogopoo.View.EntidadeView;

/**
 *
 * @author tiago
 */
public class PersonagemController extends EntidadeController{
    
    public PersonagemController(EntidadeView v, PersonagemModel m, Subject updater, SubjectPosPers SubPosPers) {
        
        super(v, m, updater);
        System.out.println("jogopoo.Control.PersonagemController.<init>()");
        m.SubjectPosicao = SubPosPers;
    }
    
}
