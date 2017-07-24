package jogopoo.Model;

import jogopoo.Control.Application;
import jogopoo.Control.Observer;
import jogopoo.Control.ObserverColisao;
import jogopoo.Control.Updater;

public class ObjetoAtaque implements ObserverColisao, Observer {
    
    private HitBox hitbox;
    private float dmg;
    private float velocidade;
    private Coordenada coordenada;
    final int duracao;
    private int cooldown;
    Updater updt;

    public ObjetoAtaque(float dmg, Coordenada coordenada, int duracao, float raio) {
        this.updt = Application.Application.updater;
        this.dmg = dmg;
        this.coordenada = coordenada;
        this.duracao = duracao;
        this.cooldown = duracao;
        hitbox = new HitBoxCircle(coordenada, raio);
        updt.registrarObservador(this);
        Application.colisionHandler.removerObservador(this);
      
    }

    @Override
    public HitBox getHitBox() {
        return null;
    }

    @Override
    public void colide(ObserverColisao ObjColidido) {
        
        if(ObjColidido.getHitBoxColided() != this.hitbox){
            ObjColidido.setHitBoxColided(this.hitbox);
            if(ObjColidido.getClass().getName().equals("jogopoo.Model.NPC")){
                PersonagemModel p = (PersonagemModel) ObjColidido;
                p.hp -= this.dmg;
                p.setCanAction(true);
                // CRIAR NPC E FUNCAO LEVAR DANO
            }
        }
    }

    @Override
    public void notificar() {
        if(this.cooldown>0)this.cooldown--;
        else{
            this.cooldown = this.duracao;
            Application.Application.updater.removerObservador(this);
        }
    }

    @Override
    public void setHitBoxColided(HitBox hitbox) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HitBox getHitBoxColided() {
        return null;
    }
    
    
    
}
