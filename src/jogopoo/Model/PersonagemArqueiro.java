/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import java.awt.event.KeyEvent;
import jogopoo.Control.Application;
import jogopoo.View.EntidadeView;

/**
 *
 * @author tiago
 */
public class PersonagemArqueiro extends PersonagemModel{
    public float mana_max;
    public float mana;
    public float mana_regen;
    public PersonagemArqueiro(Coordenada pos, EntidadeView view) {
        super(pos, view, 32);
        super.dano = 20;
        super.defesa.setDefesa(20);
        super.hp_max = 200;
        super.hp = hp_max;
        this.mana_max = 130;
        this.mana = mana_max;
        super.pc_crit = 5;
        super.vel_ataque = 30;
        super.velocidade = 7;
        super.xp = 0;
        this.mana_regen = (float) 0.01;
    }

    public float getMana_max() {
        return mana_max;
    }

    public float getMana() {
        return mana;
    }

    @Override
    void uparNivel() {
        this.hp_max += 20;
        this.mana_max += 30;
        this.hp = hp_max;
        this.mana = mana_max;
        this.dano += 4;
        this.defesa.setDefesa(getDefesa() + 4);
        this.vel_ataque += 5;
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
