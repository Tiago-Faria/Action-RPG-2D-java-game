package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.View.EntidadeView;
import jogopoo.View.Sprite;

public abstract class Arma extends Equipavel {
    
    private float dano;
    private float vel_ataque;
    protected int duracao;
    protected int cooldown;
    protected float raio;
    protected float velocidadeDisparo;
    protected Sprite sprite;
    ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();
    
    public Arma(int nivel) {
        super(nivel);
    }
    
    public void update(){
        if(cooldown>0)cooldown--;
    }
    
    
    public float getDano(PersonagemModel ataque) {
        if (ataque.getPc_crit() < (Math.random())) {
            return 2 * this.dano;
        }
        return this.dano;
    }
    public void setDano(float dano) {
        this.dano = dano;
    }
    public float getVel_ataque() {
        return vel_ataque;
    }
    public void setVel_ataque(float vel_ataque) {
        this.vel_ataque = vel_ataque;
    }
    public int getCooldown() {
        return cooldown;
    }
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
    
    public abstract void usarArma(PersonagemModel ataque,int direcaox,int direcaoy,float dano);
}
