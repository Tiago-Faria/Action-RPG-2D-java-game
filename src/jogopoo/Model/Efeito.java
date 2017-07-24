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
public abstract class Efeito {
    protected int duracao;
    protected int contador;
    protected EntidadeModel entidade;
    
    public Efeito(EntidadeModel entidade) {
        this.entidade = entidade;
    }
    
    public abstract void updateEfeito();
    public abstract void zeraContador();
}
