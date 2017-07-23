package jogopoo.Model;

public class Cajado extends ArmaMago {
    
    public Cajado(int nivel) {
        super(nivel);
    }
    
    public void usarArma(PersonagemModel ataque) {
        if (this.getCooldown() == 0) {
            float value = super.getDano(ataque);
            Projetil p = new Projetil(ataque.posicao, value, sprite, velocidadeDisparo, duracao, raio);
            this.setCooldown(7);
        }
    }
    
}
