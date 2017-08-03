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
    
    public static PersonagemModel CriarPersonagem(String classe, EntidadeView view,Coordenada c){
        ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();
        if("Mago".equals(classe)){
            imagens.add(new ImageIcon("src/imagens/Mago.png"));
            Sprite spr = new Sprite(imagens,c);
            view.setSprite(spr);
            return new PersonagemMago( c, view);
        }
        if("Guerreiro".equals(classe)){
            
            imagens.add(new ImageIcon("src/imagens/Guerreiro.png"));
            Sprite spr = new Sprite(imagens,c);
            view.setSprite(spr);
            return new PersonagemGuerreiro( c, view);
        }
        if("Arqueiro".equals(classe)){
            
            imagens.add(new ImageIcon("src/imagens/Arqueiro.png"));
            Sprite spr = new Sprite(imagens,c);
            view.setSprite(spr);
            return new PersonagemArqueiro( c, view);
        }
        return null;
    }

}
