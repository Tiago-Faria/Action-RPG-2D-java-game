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

    public EfeitoQueimadura(EntidadeModel entidade) {
        super(entidade);
        duracao = 90;
        contador = duracao;
        updateEfeito();
    }

    @Override
    public void updateEfeito() {
        if(contador > 0) {
            contador--;
            entidade.hp = entidade.hp - 5;
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
