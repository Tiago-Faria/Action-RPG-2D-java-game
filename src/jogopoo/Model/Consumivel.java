package jogopoo.Model;

import jogopoo.View.Sprite;

public abstract class Consumivel extends Item {

    /*public Consumivel(Sprite sprite) {
        super(sprite);
    }*/
    
    public abstract void consumir(PersonagemModel personagem);
}
