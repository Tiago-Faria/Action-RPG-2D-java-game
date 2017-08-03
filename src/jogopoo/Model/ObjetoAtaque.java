package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.Control.Application;
import jogopoo.Control.Observer;
import jogopoo.Control.ObserverColisao;
import jogopoo.Control.Updater;
import jogopoo.View.EntidadeView;
import jogopoo.View.Sprite;

public class ObjetoAtaque extends ObjetoConcreto {
    
    private HitBox hitbox;
    private float dmg;
    private float velocidade;
    private Coordenada coordenada;
    private Coordenada coordenadaDoPersonagem;
    private int duracao;
    private int cooldown;
    protected int directionX;
    protected int directionY;
    private int tamanhoSprite=0;
    Updater updt;
    EntidadeView view;

    public ObjetoAtaque(Coordenada coordenada, float dmg, ArrayList<ImageIcon> imagens, int duracao,
            double directionX,double directionY, float raio) {
        
        this.coordenadaDoPersonagem = coordenada;
        this.dmg = dmg;
        this.duracao = duracao;
        this.coordenada = new Coordenada(coordenada.x,coordenada.y);    
        
        hitbox = new HitBoxCircle(coordenada, raio);
        Sprite sprite = new Sprite(imagens, coordenada);
        
        Application.Application.updater.registrarObservador(this);
        Application.colisionHandler.registrarObservador(this);
        
        setDirection(directionX,directionY);
        view = new EntidadeView(sprite);
      
    }

    public ObjetoAtaque(Coordenada coordenada, float dmg, ArrayList<ImageIcon> imagens,int tamanhoSprite, int duracao,
            double directionX,double directionY, float raio) {
        
        this.coordenadaDoPersonagem = coordenada;
        this.dmg = dmg;
        this.duracao = duracao;
        this.coordenada = new Coordenada(coordenada.x,coordenada.y); 
        this.tamanhoSprite = tamanhoSprite;
        
        hitbox = new HitBoxCircle(this.coordenada, raio);
        Sprite sprite = new Sprite(imagens, this.coordenada);
        
        
        Application.Application.updater.registrarObservador(this);
        Application.colisionHandler.registrarObservador(this);
        view = new EntidadeView(sprite,this.tamanhoSprite);
        
        setDirection(directionX,directionY);
      
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
               
        this.coordenada.x = this.coordenadaDoPersonagem.x;
        this.coordenada.y = this.coordenadaDoPersonagem.y;
        
        if(this.tamanhoSprite !=0)
            desenhar();
        else
            view.draw();
        if(this.duracao>0)this.duracao--;
        else{
            Application.Application.updater.removerObservador(this);
            Application.colisionHandler.removerObservador(this);
        }
    }
    
    public void desenhar(){
        
        if(this.directionX==1){
            //Righ
            this.coordenada.x += 30;
            view.drawR();
        }else if(this.directionX == -1){
            //Left
            this.coordenada.x -= 30;
            view.drawL();
        }else{
            if(this.directionY == -1){
                //Top
                this.coordenada.y -= 10;
                view.drawT();
            }else if(this.directionY == 1){
                //Down
                this.coordenada.y += 40;
                view.drawD();
            }
        }  
    }
    
}
