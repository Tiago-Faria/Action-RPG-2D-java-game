package jogopoo.Model;

import java.util.ArrayList;

public class Inventario {
    
    public ArrayList<Item> items = new ArrayList<Item>();
    private int tam_max = 29;
    private int ocupado;

    public void adicionarItem(Item item) {
        if (this.ocupado + 1 <= this.tam_max) {
            this.items.add(item);
            this.ocupado++;
        }
    }
    
    public ArrayList<Item> getItems() {
        return items;
    }
    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    public int getTam_max() {
        return tam_max;
    }
    public void setTam_max(int tam_max) {
        this.tam_max = tam_max;
    }
    public int getOcupado() {
        return ocupado;
    }
    public void setOcupado(int ocupado) {
        this.ocupado = ocupado;
    }
    public void removeItem(int slot) {
        items.remove(slot);
        ocupado--;
    }
    
}
