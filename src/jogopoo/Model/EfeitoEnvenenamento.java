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
public class EfeitoEnvenenamento extends Efeito{
    int xperSec;
    public EfeitoEnvenenamento(EntidadeModel entidade) {
        super(entidade);
        duracao = 90;
        contador = duracao;
        xperSec = 30;
        entidade.velocidade = 3;
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
            entidade.velocidade = 5;
            entidade.efeitos[2] = null;
            entidade = null;
        }
    }

    @Override
    public void zeraContador() {
        contador = duracao;

    }
    
}
