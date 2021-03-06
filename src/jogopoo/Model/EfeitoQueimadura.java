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
public class EfeitoQueimadura extends Efeito{
    int xperSec;
    public EfeitoQueimadura(EntidadeModel entidade) {
        super(entidade);
        duracao = 90;
        contador = duracao;
        xperSec = 15;
        updateEfeito();
    }

    @Override
    public void updateEfeito() {
        if(contador > 0) {
            contador--;
            if(xperSec == 0){
                entidade.hp = entidade.hp - 5;
                xperSec = 16;
            }
            xperSec--;
        }else {
            entidade.efeitos[1] = null;
            entidade = null;
        }
    }

    @Override
    public void zeraContador() {
        contador = duracao;
    }
    
}
