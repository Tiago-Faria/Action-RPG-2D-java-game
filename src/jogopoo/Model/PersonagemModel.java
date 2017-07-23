/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.awt.event.KeyEvent;
import jogopoo.Control.*;
import jogopoo.View.EntidadeView;

/**
 *
 * @author tiago
 */
public abstract class PersonagemModel extends EntidadeModel{
    public int[] XPNecessario = {4,8,14,22,32};
    private boolean isDefending;
    public float pc_crit;
    public int xp;
    public float hp_regen;
    public boolean canCast;
    private Habilidades MagiaQ;
    private Habilidades MagiaE;

    public PersonagemModel(Coordenada pos, EntidadeView view,float raio) {
        super(pos, view,raio);
    }
    public void update(){
        defender();
        movimentar();
        regenerarVida();
        usarHabilidade();
        hook();
    }
    public void defender(){
        isDefending = Application.teclas[KeyEvent.VK_SPACE];
    }
    @Override
    public float getDefesa() {
        if(isDefending)return this.defesa;
        else return this.defesa/2;
    }
    public void usarHabilidade()
    {
        if(this.getCanCast()){
            if(Application.teclas[KeyEvent.VK_Q]){
                this.MagiaQ.usarHabilidade(this);
            }
            else if(Application.teclas[KeyEvent.VK_E]){
                this.getMagiaE();
            }       
        }
    }
    
    @Override
    public void movimentar() {
        float aux_x = 0;
        float aux_y = 0;
        if(Application.teclas[KeyEvent.VK_A])aux_x--;
        if(Application.teclas[KeyEvent.VK_W])aux_y--;
        if(Application.teclas[KeyEvent.VK_D])aux_x++;
        if(Application.teclas[KeyEvent.VK_S])aux_y++;
        
        if(aux_x != 0 && aux_y != 0){
            aux_y *= Math.cos(Math.PI/4);
            aux_x *= Math.cos(Math.PI/4);
        }
        this.posicao.x += aux_x*getVelocidade();
        if(ColisionHandler.isColiding(this, "jogopoo.Model.Parede")){
            this.posicao.x -= aux_x*getVelocidade();
            
        }
        this.posicao.y += aux_y*getVelocidade();
        if(ColisionHandler.isColiding(this, "jogopoo.Model.Parede")){
            this.posicao.y -= aux_y*getVelocidade();
        }
    }

    public Habilidades getMagiaQ() {
        return MagiaQ;
    }

    public Habilidades getMagiaE() {
        return MagiaE;
    }

    public float getPc_crit() {
        return pc_crit;
    }
    public void setPc_crit(float pc_crit) {
        this.pc_crit = pc_crit;
    }
    public float getHp_regen() {
        return hp_regen;
    }
    public void setHp_regen(float hp_regen) {
        this.hp_regen = hp_regen;
    }
    
    
    
    public boolean getCanCast(){
        return canCast;
    }
    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }
    private float getVelocidade(){
        if(isDefending)return this.velocidade/2;
        else return this.velocidade;
    }
    private void regenerarVida(){
        this.hp += this.hp_regen;
        if(hp > hp_max)hp = hp_max;
    }
    public void gainXp(int qtd){
        xp  += qtd;
        if(nivel < 5 && xp >= XPNecessario[nivel]){
            xp -= XPNecessario[nivel];
            nivel++;
            uparNivel();
        }
    }
    abstract void uparNivel();
    public void hook(){}
}
