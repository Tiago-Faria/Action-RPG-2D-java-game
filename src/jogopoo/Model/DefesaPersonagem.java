/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogopoo.Model;

/**
 *
 * @author Esdras Chaves
 */
public class DefesaPersonagem implements Defesa{
    private float defesaPadrao;
    
    public void setDefesa(float defesaPadrao) {
        this.defesaPadrao = defesaPadrao;
    }
    
    @Override
    public float devolveDefesa() {
        return this.defesaPadrao;
    }

    @Override
    public float getDefesa() {
        return this.defesaPadrao;
    }
    
}
