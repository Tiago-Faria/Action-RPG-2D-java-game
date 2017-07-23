/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.Control.ColisionHandler;
import jogopoo.Control.Subject;
import jogopoo.Control.Updater;
import jogopoo.View.EntidadeView;
import jogopoo.View.Sprite;

/**
 *
 * @author tiago
 */
public class SimpleFactoryPersonagem {
    public static PersonagemModel CriarPersonagem(Updater updt, String classe, EntidadeView view,Coordenada c,SubjectPosPers sub,ColisionHandler col){
        ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();
        if("Mago".equals(classe)){
            imagens.add(new ImageIcon("src/imagens/Mago.png"));
            Sprite spr = new Sprite(imagens,c);
            view.setSprite(spr);
            return new Mago(updt, sub, c, view,50,col);
        }
        return null;
    }
}
