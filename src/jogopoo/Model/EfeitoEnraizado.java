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
public class EfeitoEnraizado extends Efeito {

    public EfeitoEnraizado(EntidadeModel entidade) {
        super(entidade);
        entidade.velocidade = 0;
        duracao = 90;
        contador = duracao;
        updateEfeito();
    }
    
    

    @Override
    public void updateEfeito() {
        if(contador > 0)
            contador--;
        else {
            entidade.velocidade = 5;
            entidade.efeitos[3] = null;
            entidade = null;
        }
    }

    @Override
    public void zeraContador() {
        contador = duracao;
    }
    
}
