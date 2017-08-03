/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
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
    public boolean canAction = true;
    private Habilidades MagiaQ;
    private Habilidades MagiaE;
    public double lastDirectionX= 0;
    public double lastDirectionY= 1;
    public Inventario inventario;
    public Equipavel[] equipavel;
    public int CooldownAtaque;
    

    
    public PersonagemModel(Coordenada pos, EntidadeView view,float raio) {
        super(pos, view,raio);
        equipavel = new Equipavel[3];
        inventario = new Inventario();
    }
    public void update(){
        DiminuiCooldown();
        atacar();
        defender();
        movimentar();
        regenerarVida();
        usarHabilidade();
        hook();
        if(hp<=0)morrer();
    }
    public abstract void atacar();
    public void defender(){
        if(Application.teclas[KeyEvent.VK_SPACE] && !isDefending) {
            isDefending = true;
            Armadura a = new Armadura(0);
            System.out.println("Defesa antes = " +this.defesa.getDefesa());
            a.setPersonagem(defesa);
            a.setDefesa(this.defesa.getDefesa());
            this.defesa = a;
            System.out.println("Defesa = " + this.defesa.devolveDefesa());
        }else if(!Application.teclas[KeyEvent.VK_SPACE] && isDefending) {
            isDefending = false;
            this.defesa = ((Armadura)this.defesa).getPersonagem();
        }
    }
    @Override
    public float getDefesa() {
        if(isDefending)return this.defesa.getDefesa();
        else return this.defesa.getDefesa()/2;
    }
    public void setDefesa(float defesa){
        this.defesa.setDefesa(defesa);
    }
    public ArrayList<Item> getItem() {
        return inventario.getItems();
    }
    
    
    
    public void usarHabilidade()
    {
        if(this.getCanAction()){
            if(Application.teclas[KeyEvent.VK_Q]){
                this.MagiaQ.usarHabilidade(this);
            }
            else if(Application.teclas[KeyEvent.VK_E]){
                this.MagiaE.usarHabilidade(this);
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
        
        if(aux_x != 0 || aux_y != 0){
            lastDirectionX = aux_x;
            lastDirectionY = aux_y;
        }
        
        if(aux_x != 0 && aux_y != 0){
            aux_y *= 0.70710678118;
            aux_x *= 0.70710678118;
        }
        
        double pX = this.posicao.x;
        double pY = this.posicao.y;
        
        
        this.posicao.x += aux_x*getVelocidade();
        if(ColisionHandler.isColiding(this, "jogopoo.Model.ObjetoParede")){
            this.posicao.x -= aux_x*getVelocidade();
            
        }
        this.posicao.y += aux_y*getVelocidade();
        if(ColisionHandler.isColiding(this, "jogopoo.Model.ObjetoParede")){
            this.posicao.y -= aux_y*getVelocidade();
        }
        
    }
    
    public void setMagiaQ(Habilidades h){
        this.MagiaQ = h;
    }
    public void setMagiaE(Habilidades h){
        this.MagiaE = h;
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

    public Inventario getInventario() {
        return inventario;
    }
    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
    
    
    public void setCanAction(boolean b){
        this.canAction = b;
    }
    public boolean getCanAction(){
        return this.canAction;
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
    
    public void regenerarVida(int hp){
        this.hp += hp;
        if(this.hp > this.hp_max)this.hp = hp_max;
    }
    public void gainXp(int qtd){
        xp  += qtd;
        if(nivel < 5 && xp >= XPNecessario[nivel]){
            xp -= XPNecessario[nivel];
            nivel++;
            uparNivel();
        }
    }

    public void setLoot(Item item, int xp) {
        gainXp(xp);
        inventario.adicionarItem(item);
    }
    abstract void uparNivel();
    public void hook(){}
    
    public void morrer(){
        Application.Exit();
    };

    private void DiminuiCooldown() {
        if(CooldownAtaque > 0)CooldownAtaque--;
        
    }

    public float getDano() {
        return dano;
    }

    public void setDano(float dano) {
        this.dano = dano;
    }
    
}
