/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.Engine.Subject;
import jogopoo.View.EntidadeView;
import jogopoo.View.Sprite;

/**
 *
 * @author tiago
 */
public class SimpleFactoryPersonagem {
    public static PersonagemModel CriarPersonagem(String classe, EntidadeView view,Coordenada c,SubjectPosPers sub){
        ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();
        if("mago".equals(classe)){
            imagens.add(new ImageIcon("src/imagens/mago.png"));
            Sprite spr = new Sprite(imagens,c);
            view.setSprite(spr);
            return new Mago(sub,c);
        }
        return null;
    }
}
