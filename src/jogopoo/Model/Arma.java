package jogopoo.Model;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.Control.Observer;
import jogopoo.View.EntidadeView;
import jogopoo.View.Sprite;

public abstract class Arma extends Equipavel implements Observer{
    
    protected int dmg;
    private float vel_ataque;
    protected int duracao;
    protected int cooldown;
    protected float raio;
    protected float velocidadeDisparo;
    public int tamanhoSprite;
    ArrayList<ImageIcon> imagens = new ArrayList<ImageIcon>();
    
    public Arma(int nivel) {
        super(nivel);
        this.duracao = 4;
    }
    
    public void update(){
        if(cooldown>0)cooldown--;
    }
    
    
    public float getDano(PersonagemModel personagem) {
        if (personagem.getPc_crit() < (Math.random())) {
            return 2 * (this.dmg + personagem.getDano());
        }
        return this.dmg + personagem.getDano();
    }
    public void setDano(int dano) {
        this.dmg = dano;
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
    
    public void decreaseCooldown(){
        this.cooldown--;
    }
    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
    
    public abstract void usarArma(PersonagemModel ataque,int direcaox,int direcaoy,float dano);
}
