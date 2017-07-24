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

    public EfeitoEnvenenamento(EntidadeModel entidade) {
        super(entidade);
        duracao = 120;
        contador = duracao;
        entidade.velocidade = 3;
        updateEfeito();
    }

    @Override
    public void updateEfeito() {
        if(contador > 0) {
            contador--;
            entidade.hp = entidade.hp - 3;
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
