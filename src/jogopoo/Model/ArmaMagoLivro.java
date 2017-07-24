package jogopoo.Model;

public class ArmaMagoLivro extends ArmaMago {
    
    public ArmaMagoLivro(int nivel) {
        super(nivel);
    }
    
    public void usarArma(PersonagemModel personagem) {
        if (this.getCooldown() == 0) {
            float value = super.getDano(personagem);
            ObjetoProjetil p = new ObjetoProjetil(personagem.posicao, value, imagens, velocidadeDisparo, duracao,personagem.lastDirectionX,personagem.lastDirectionY, raio);
            this.setCooldown(9);
        }
    }
    
}
