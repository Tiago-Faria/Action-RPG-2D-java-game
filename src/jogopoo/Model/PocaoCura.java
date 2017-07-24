package jogopoo.Model;

import jogopoo.View.Sprite;

public class PocaoCura extends Consumivel {

    /*public PocaoCura(Sprite sprite) {
        super(sprite);
    }*/

    @Override
    public void consumir(PersonagemModel personagem) {
        if (personagem.getInventario().getItems().contains(this)) {
            personagem.regenerarVida(60);
            personagem.getInventario().getItems().remove(this);
            personagem.getInventario().setOcupado(
                    personagem.getInventario().getOcupado() - 1 
            );
        }
    }
    
}
