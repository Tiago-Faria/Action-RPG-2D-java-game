/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

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
    public Mago(Updater updt, SubjectPosPers s, Coordenada pos, EntidadeView view,float raio,ColisionHandler col) {
        super(updt, s, pos, view,raio,col);
        
    }

    @Override
    void uparNivel() {
        this.hp_max += 20;
        this.mana_max += 40;
        this.dano += 5;
        this.defesa += 2;
    }
    @Override
    public void hook(){
        mana += mana_regen;
        if(mana > mana_max)mana = mana_max;
    }

    public float getMana_regen() {
        return mana_regen;
    }

    public void setMana_regen(float mana_regen) {
        this.mana_regen = mana_regen;
    }
    
    
}
