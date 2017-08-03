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
public class EfeitoMoveSpeed extends Efeito{

    public EfeitoMoveSpeed(EntidadeModel entidade) {
        super(entidade);
        duracao = 15;
        entidade.velocidade = 10;
        contador = duracao;
        updateEfeito();
    }

    @Override
    public void updateEfeito() {
        if(contador > 0) {
            contador--;
        }else {
            entidade.efeitos[4] = null;
            entidade.velocidade = 5;
            entidade = null;
        }
    }

    @Override
    public void zeraContador() {
        contador = duracao;
    }
    
}
