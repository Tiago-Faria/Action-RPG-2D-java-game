package jogopoo.Model;

public class AnelDeVelocidadeDeAtaque extends Acessorio {
    
    public AnelDeVelocidadeDeAtaque(int nivel, float valor) {
        super(nivel, valor, 0, 0);
    }
    
    @Override
    public void equipar(PersonagemModel personagem) {
        if (personagem.getClass().getName().equals("jogopoo.Model.Mago"))
            ((Mago)personagem).setMana_regen(super.getMp_regen());
        personagem.setVel_ataque(super.getVelocidade());
        personagem.setPc_crit(super.getPc_crit());
    }
}
