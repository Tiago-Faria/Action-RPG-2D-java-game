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
public class EfeitoAtaqueSpeed extends Efeito{
    float aux;
    public EfeitoAtaqueSpeed(EntidadeModel entidade) {
        super(entidade);
        duracao = 15;
        aux = entidade.vel_ataque;
        entidade.vel_ataque = aux + 10;
        contador = duracao;
        updateEfeito();
    }

    @Override
    public void updateEfeito() {
        if(contador > 0) {
            contador--;
        }else {
            entidade.efeitos[5] = null;
            entidade.vel_ataque = aux;
            entidade = null;
        }
    }

    @Override
    public void zeraContador() {
        contador = duracao;
    }
}
