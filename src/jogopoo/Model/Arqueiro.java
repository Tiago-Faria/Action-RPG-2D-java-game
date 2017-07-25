/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

import jogopoo.View.EntidadeView;

/**
 *
 * @author tiago
 */
public class Arqueiro extends PersonagemModel{
    public float mana_max;
    public float mana;
    public float mana_regen;
    public Arqueiro(Coordenada pos, EntidadeView view) {
        super(pos, view, 32);
        super.dano = 20;
        super.defesa = 20;
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

    @Override
    void uparNivel() {
        this.hp_max += 20;
        this.mana_max += 30;
        this.hp = hp_max;
        this.mana = mana_max;
        this.dano += 4;
        this.defesa += 4;
        this.vel_ataque += 5;
    }

    @Override
    public void atacar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
