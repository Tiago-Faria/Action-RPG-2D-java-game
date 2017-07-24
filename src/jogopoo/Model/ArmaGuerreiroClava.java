package jogopoo.Model;

public class ArmaGuerreiroClava extends ArmaGuerreiro {
    
    public ArmaGuerreiroClava(int nivel) {
        super(nivel);
    }
    
    public void usarArma(PersonagemModel ataque) {
        if (this.getCooldown() == 0) {
            float value = super.getDano(ataque);
            ObjetoAtaque arma = new ObjetoAtaque(value,
                    ataque.posicao, super.duracao, super.raio
            );
            this.setCooldown(12);
        }
     
        
    }
}
