/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.awt.event.KeyEvent;
import jogopoo.Application;
import jogopoo.Engine.Subject;

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
    public SubjectPosPers SubjectPosicao;

    public PersonagemModel(SubjectPosPers s, Coordenada pos) {
        super(pos);
        this.SubjectPosicao = s;
    }
    public void update(){
        defender();
        movimentar();
        regenerarVida();
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
            aux_x = aux_y;
        }
        if(aux_x != 0 || aux_y != 0)this.SubjectPosicao.notificarObservadores(this.posicao);
        this.posicao.x += aux_x*getVelocidade();
        this.posicao.y += aux_y*getVelocidade();
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
