package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.Control.Application;
import jogopoo.Control.Observer;
import jogopoo.Control.ObserverColisao;
import jogopoo.Control.Updater;
import jogopoo.View.EntidadeView;
import jogopoo.View.Sprite;

public class ObjetoInvestida  extends ObjetoConcreto  {
    
    private HitBox hitbox;
    private float dmg;
    private float velocidade;
    private Coordenada coordenada;
    private Coordenada coordenadaDoPersonagem;
    private int duracao;
    private int condition = 0;
    protected int directionX;
    protected int directionY;
    Updater updt;
    EntidadeView view;

    public ObjetoInvestida(Coordenada coordenada, float dmg, ArrayList<ImageIcon> imagens,int velocidade 
            ,int duracao,double directionX,double directionY, float raio) {
        
        this.dmg = dmg;
        this.duracao = duracao;
        this.velocidade = velocidade;
        this.coordenada = coordenada;
        
        hitbox = new HitBoxCircle(coordenada, raio);
        Sprite sprite = new Sprite(imagens, coordenada);
        
        Application.Application.updater.registrarObservador(this);
        Application.colisionHandler.registrarObservador(this);
        
        setDirection(directionX,directionY);
        view = new EntidadeView(sprite);
      
    }
    
    public void setDirection(double directionX,double directionY){
        this.directionX = (int)directionX;
        this.directionY = (int)directionY;
    }
    
    @Override
    public HitBox getHitBox() {
        return this.hitbox;
    }

    @Override
    public void colide(ObserverColisao ObjColidido ) {
        

        if(ObjColidido.getHitBoxColided()!=null)
        System.out.println(!ObjColidido.getHitBoxColided().equals(this.hitbox));
            if(ObjColidido.getClass().getSuperclass().getName().equalsIgnoreCase("jogopoo.model.NPC")
                    && (ObjColidido.getHitBoxColided()==null
                        || !ObjColidido.getHitBoxColided().equals(this.hitbox))){
                System.out.println("QNTS VEZES APARECE"+ this.dmg);
                NPC npc = (NPC) ObjColidido;
                npc.receberDano(this.dmg);
                npc.setHitBoxColided(this.hitbox);
            }
        
    }
    
    @Override
    public void notificar() {
            if(this.directionX==1){
                //Righ
                this.coordenada.x += this.velocidade;
                view.drawR();
            }else if(this.directionX == -1){
                //Left
                this.coordenada.x -= this.velocidade;
                view.drawL();
            }else{
                if(this.directionY == -1){
                    //Top
                    this.coordenada.y -= this.velocidade;
                    view.drawT();
                }else if(this.directionY == 1){
                    //Down
                    this.coordenada.y += this.velocidade;
                    view.drawD();
                }
            }
        if(this.duracao>0)this.duracao--;
        else{
            Application.Application.updater.removerObservador(this);
            Application.colisionHandler.removerObservador(this);
        }
    }

    
}
