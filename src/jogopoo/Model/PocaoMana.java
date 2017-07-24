package jogopoo.Model;

import jogopoo.View.Sprite;

public class PocaoMana extends Consumivel {

    /*public PocaoMana(Sprite sprite) {
        super(sprite);
    }*/

    public void consumir(PersonagemModel personagem) {
        if (personagem.getInventario().getItems().contains(this)) {
            if (personagem.getClass().getName().equals("jogopoo.Model.Mago"))
                ((Mago)personagem).regenerarMana(60);
            personagem.getInventario().getItems().remove(this);
            personagem.getInventario().setOcupado(
                    personagem.getInventario().getOcupado() - 1
            );
        }
    }
    
}
