/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.Control.Application;
import jogopoo.Control.ColisionHandler;
import jogopoo.Control.Observer;
import jogopoo.Control.ObserverColisao;
import jogopoo.Control.Updater;
import jogopoo.View.EntidadeView;
import jogopoo.View.Sprite;

/**
 *
 * @author Marcio55
 */
public class ObjetoProjetil implements Observer, ObserverColisao{
    private HitBox hitbox;
    private float dmg;
    private float velocidade;
    private Coordenada coordenada;
    private int duracao;
    private int countDuracao;
    Updater updt;
    private int efeito;
    public double directionX;
    public double directionY;
    EntidadeView view;
    
    /* imagem */        
            
    public ObjetoProjetil(Coordenada coordenada,float dmg,ArrayList<ImageIcon> imagens,
            float velocidade,int duracao,
            double directionX,double directionY,float raio){
        
        
        this.dmg = dmg;
        this.coordenada = new Coordenada(coordenada.x,coordenada.y);
        this.velocidade = velocidade;
        this.duracao = duracao;
        this.countDuracao = duracao;
        hitbox = new HitBoxCircle(coordenada,raio);
        Application.Application.updater.registrarObservador(this);
        Application.colisionHandler.registrarObservador(this);
        
        Sprite sprite = new Sprite(imagens, this.coordenada);
            
        setDirection(directionX,directionY);
        view = new EntidadeView(sprite);
        
            
    }
    
    public ObjetoProjetil(Coordenada coordenada,float dmg,ArrayList<ImageIcon> imagens,
            float velocidade,int duracao,
            double directionX,double directionY,float raio,int efeito){
        
        
            
        this.dmg = dmg;
        this.coordenada = new Coordenada(coordenada.x,coordenada.y);
        this.velocidade = velocidade;
        this.duracao = duracao;
        this.countDuracao = duracao;
        hitbox = new HitBoxCircle(this.coordenada,raio);
        Application.Application.updater.registrarObservador(this);
        Application.colisionHandler.registrarObservador(this);
        
        Sprite sprite = new Sprite(imagens, this.coordenada);
        
        setDirection(directionX,directionY);
        
        view = new EntidadeView(sprite);
        this.efeito = efeito;
        
    }
    
    public void setDirection(double directionX,double directionY){
        this.directionX = directionX;
        this.directionY = directionY;
        if(directionX != 0 && directionY != 0){
            this.directionX *= 0.70710678118;
            this.directionY *= 0.70710678118;
        }
    }
    @Override
    public HitBox getHitBox(){
        return hitbox;
    }
    
    public void setHitBoxColided(HitBox hitbox) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public HitBox getHitBoxColided(){
        return null;
    }
    
    @Override
    public void colide(ObserverColisao ObjColidido) {
         System.out.println(ObjColidido.getClass().getName());
               
        if(ObjColidido.getClass().getSuperclass().getName().equalsIgnoreCase("jogopoo.model.NPC"))
        {
            EntidadeModel p = (EntidadeModel) ObjColidido;
            p.hp -= this.dmg;
            Application.colisionHandler.removerObservador(this);
            Application.Application.updater.removerObservador(this);
            
        }
        
        // CRIAR NPC E FUNCAO LEVAR DANO
        }

    
    public void movimentar()
    {
        this.coordenada.x += this.directionX*this.velocidade;
        this.coordenada.y += this.directionY*this.velocidade;
    }

    @Override
    public void notificar() {
        this.countDuracao--;
        this.movimentar();
        view.draw();
        if(this.countDuracao<0)
        {
            Application.colisionHandler.removerObservador(this);
            Application.Application.updater.removerObservador(this);
            
            /*destroi objeto*/
        }
    }


}
