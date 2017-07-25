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
public class Guerreiro extends PersonagemModel{
    public float stamina;
    public float stamina_max;
    public float stamina_regen;
    public Guerreiro(Coordenada pos, EntidadeView view) {
        super(pos, view, 32);
        this.stamina = 100;
        this.stamina_max = 100;
        this.stamina_regen = (float) 0.1;
        super.dano = 20;
        super.defesa = 40;
        super.hp_max = 350;
        super.hp = hp_max;
        super.pc_crit = 1;
        super.vel_ataque = 15;
        super.velocidade = 5;
        super.xp = 0;
    }

    @Override
    void uparNivel() {
        this.hp_max += 25;
        this.hp = hp_max;
        this.dano += 3;
        this.defesa += 7;
    }
    public void hook(){
        stamina += stamina_regen;
        if(stamina > stamina_max)stamina = stamina_max;
    }

    @Override
    public void atacar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
