/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import jogopoo.Control.*;
import jogopoo.View.*;

/**
 *
 * @author tiago
 */
public class Mago extends PersonagemModel{
    public float mana_max;
    public float mana;
    public float mana_regen;
    public Mago(Coordenada pos, EntidadeView view) {
        super(pos, view,32);
        super.dano = 40;
        super.defesa = 20;
        super.hp_max = 200;
        super.hp = hp_max;
        this.mana_max = 200;
        this.mana = mana_max;
        super.pc_crit = 1;
        super.vel_ataque = 20;
        super.velocidade = 5;
        super.xp = 0;
        this.mana_regen = (float) 0.01;
        this.inventario.adicionarItem(new ArmaMagoVarinha(0));
        this.inventario.adicionarItem(new ArmaMagoVarinha(4));
    }


    @Override
    void uparNivel() {
        this.hp_max += 20;
        this.mana_max += 40;
        this.hp = hp_max;
        this.mana = mana_max;
        this.dano += 5;
        this.defesa += 4;
    }
    @Override
    public void hook(){
        mana += mana_regen;
        if(mana > mana_max)mana = mana_max;
    }public void regenerarMana(int mana) {
        this.mana += mana;
        if (this.mana > this.mana_max) this.mana = this.mana_max;
    }

    public float getMana_regen() {
        return mana_regen;
    }

    public void setMana_regen(float mana_regen) {
        this.mana_regen = mana_regen;
    }

    @Override
    public void atacar() {
        if(CooldownAtaque == 0){
            int aux_x = 0;
            int aux_y = 0;
            if(Application.teclas[KeyEvent.VK_LEFT])aux_x--;
            if(Application.teclas[KeyEvent.VK_UP])aux_y--;
            if(Application.teclas[KeyEvent.VK_RIGHT])aux_x++;
            if(Application.teclas[KeyEvent.VK_DOWN])aux_y++;

            if(aux_x != 0 || aux_y != 0){
                Arma arma = (Arma)equipavel[0];
                float dano = getDano();
                if(Math.random() < 100/getPc_crit())dano *= 2;
                if(arma != null)arma.usarArma((PersonagemModel)this,aux_x,aux_y, dano);
            }
        }
     
        
    }
   

}
