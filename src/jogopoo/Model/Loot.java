/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.Control.Application;
import jogopoo.Control.Observer;
import jogopoo.Control.ObserverColisao;
import jogopoo.View.EntidadeView;
import jogopoo.View.Sprite;

/**
 *
 * @author Esdras Chaves
 */
public class Loot implements Observer, ObserverColisao{
    private Item item;
    private int xp;
    private HitBox hitbox;
    private EntidadeView view;
    public Loot(Item item, Coordenada c, int xp) {
        this.item = item;
        this.xp = xp;
        this.hitbox = new HitBoxCircle(new Coordenada(c.x, c.y), 5.0f);
        Application.Application.updater.registrarObservador(this);
        Application.colisionHandler.registrarObservador(this);
        
        ArrayList<ImageIcon> iconeLoot = new ArrayList<ImageIcon>();
        iconeLoot.add(new ImageIcon("src/imagens/Loot.png"));
        view = new EntidadeView(new Sprite(iconeLoot,new Coordenada(c.x, c.y)));
    }

    @Override
    public void notificar() {
        view.draw();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HitBox getHitBox() {
        return this.hitbox;
    }

    @Override
    public void colide(ObserverColisao ObjColidido) {
        if(ObjColidido.getClass().getSuperclass().getName().equalsIgnoreCase("jogopoo.Model.PersonagemModel")) {
            
            PersonagemModel personagem = (PersonagemModel) ObjColidido;
            personagem.setLoot(item, xp);
            Application.updater.removerObservador(this);
            Application.colisionHandler.removerObservador(this);
        }
    }

    @Override
    public void setHitBoxColided(HitBox hitBox) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HitBox getHitBoxColided() {
        return null;
    }
    
    
}
