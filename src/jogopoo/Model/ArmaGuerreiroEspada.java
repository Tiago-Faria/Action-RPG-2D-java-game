package jogopoo.Model;

public class ArmaGuerreiroEspada extends ArmaGuerreiro {
    
    public ArmaGuerreiroEspada(int nivel) {
        super(nivel);
    }
    
    public void usarArma(PersonagemModel ataque) {
        if (this.getCooldown() == 0) {
            float value = super.getDano(ataque);
            ObjetoAtaque arma = new ObjetoAtaque(value,
                    ataque.posicao, super.duracao, super.raio);
            this.setCooldown(12);
        }
        
    }
    
}
