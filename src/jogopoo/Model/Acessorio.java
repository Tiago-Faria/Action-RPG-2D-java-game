package jogopoo.Model;

public class Acessorio extends Equipavel {
    
    private float velocidade;
    private float pc_crit;
    private float mp_regen;

    public Acessorio(int nivel, float velocidade,
                    float pc_crit, float mp_regen) {
        
        super(nivel);
        this.velocidade = velocidade;
        this.pc_crit = pc_crit;
        this.mp_regen = mp_regen;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public float getPc_crit() {
        return pc_crit;
    }

    public float getMp_regen() {
        return mp_regen;
    }

    public void equipar(PersonagemModel personagem) {
        if (personagem.getClass().getName().equals("jogopoo.Model.Mago"))
            ((PersonagemMago)personagem).setMana_regen(mp_regen);
        personagem.setPc_crit(this.pc_crit);
        personagem.setVelocidade(this.velocidade);
    }
}
