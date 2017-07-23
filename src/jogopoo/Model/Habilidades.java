package jogopoo.Model;

import jogopoo.View.Sprite;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Marcio55
 */
public abstract class Habilidades {
    
    private int cooldown = 0;
    protected Sprite sprite; 
    
    
    public abstract void usarHabilidade(PersonagemModel personagem);

    public void update(){
        if(cooldown>0)cooldown--;
    }
    
    public int getCooldown(){
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }
    
}
