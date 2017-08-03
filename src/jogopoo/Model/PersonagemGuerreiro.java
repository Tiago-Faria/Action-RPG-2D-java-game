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
public class PersonagemGuerreiro extends PersonagemModel{
    public float stamina;
    public float stamina_max;
    public float stamina_regen;
    public PersonagemGuerreiro(Coordenada pos, EntidadeView view) {
        super(pos, view, 16);
        this.stamina = 100;
        this.stamina_max = 100;
        this.stamina_regen = (float) 0.1;
        super.dano = 20;
        super.defesa.setDefesa(40);
        super.hp_max = 350;
        super.hp = hp_max;
        super.pc_crit = 1;
        super.vel_ataque = 15;
        super.velocidade = 5;
        super.xp = 0;
        super.setMagiaQ(new HabilidadeGolpeFulminante());
        super.inventario.adicionarItem(new ArmaGuerreiroEspada(1));
        super.inventario.adicionarItem(new ArmaGuerreiroMachado(0));
        super.inventario.adicionarItem(new ArmaGuerreiroClava(0));
    }

    @Override
    void uparNivel() {
        this.hp_max += 25;
        this.hp = hp_max;
        this.dano += 3;
        this.defesa.setDefesa(getDefesa() + 7);
    }
    public void hook(){
        stamina += stamina_regen;
        if(stamina > stamina_max)stamina = stamina_max;
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
