package jogopoo.Model;

import jogopoo.Control.Application;
import jogopoo.Control.Observer;
import jogopoo.Control.ObserverColisao;
import jogopoo.Control.Updater;

public class ArmaObject implements ObserverColisao, Observer {
    
    private HitBox hitbox;
    private float dmg;
    private float velocidade;
    private Coordenada coordenada;
    private int duracao;
    private int countDuracao;
    Updater updt;

    public ArmaObject(float dmg, float velocidade,
            Coordenada coordenada, int duracao, float raio) {
        this.updt = Application.Application.updater;
        this.dmg = dmg;
        this.velocidade = velocidade;
        this.coordenada = coordenada;
        this.duracao = duracao;
        hitbox = new HitBoxCircle(coordenada, raio);
        updt.registrarObservador(this);
      
    }

    @Override
    public HitBox getHitBox() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void colide(ObserverColisao ObjColidido) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notificar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
