package jogopoo.Model;

public class ArmaGuerreiroMachado extends ArmaGuerreiro {
    
    public ArmaGuerreiroMachado(int nivel) {
        super(nivel);
    }
    
    public void usarArma(PersonagemModel ataque) {
        if (this.getCooldown() == 0) {
            float value = super.getDano(ataque);
            ObjetoAtaque arma = new ObjetoAtaque(value,
                    ataque.posicao, super.duracao, super.raio
            );
            this.setCooldown(8);
        }
        
    }

    @Override
    public void usarArma(PersonagemModel ataque, int direcaox, int direcaoy, float dano) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
