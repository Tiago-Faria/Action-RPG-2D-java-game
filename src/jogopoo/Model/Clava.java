package jogopoo.Model;

public class Clava extends ArmaGuerreiro {
    
    public Clava(int nivel) {
        super(nivel);
    }
    
    public void usarArma(PersonagemModel ataque) {
        if (this.getCooldown() == 0) {
            float value = super.getDano(ataque);
            ArmaObject arma = new ArmaObject(value, 
                    (ataque.getVel_ataque() + super.getVel_ataque()),
                    ataque.posicao, super.duracao, super.raio
            );
            this.setCooldown(12);
        }
     
        
    }
}
