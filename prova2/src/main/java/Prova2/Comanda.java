package prova2;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Comanda {
    
    protected TipoBuffet tipoBuffet;
    protected ArrayList<Item> itens;
    
    public Comanda(TipoBuffet tipoBuffet) {
        setTipoBuffet(tipoBuffet);
        itens = new ArrayList<Item>();
    }

    public ArrayList<Item> getTipoItem() {
        return itens;
    }

    public void setTipoItem(ArrayList<Item> tipoItem) throws IllegalArgumentException {
        if (tipoItem == null) {
            throw new IllegalArgumentException("O tipo do item deve ser informado");
        }
        this.itens = tipoItem;
    }
    
    
    public float calcularValorComanda() {
        float valor = 0;
        if (tipoBuffet == tipoBuffet.LIVRE) {
            for (Item item: itens) {
                if (item instanceof Couvert || item instanceof Bebida) {
                    valor += item.getValor();
                }
            }
            valor += 30;
        } else {
            for (Item item: itens) {
                valor = item.getValor();
            }
        }
        return valor;
    }
    
    private Item buscar(String nome, float valor) {
        for (Item f : itens) {
            if (f.getNome() == nome && f.getValor() == valor) {
                return f;
            }
        }
        return null;
    }
    
    public void incluirItem(Item item) throws IllegalArgumentException {
        if (item == null) {
            throw new IllegalArgumentException("Item deve ser informado");
        }
        itens.add(item);
    }
    
    public void removerItem(String nome, float valor) throws IllegalArgumentException {
         Item removerItem = buscar(nome, valor);
         if (removerItem == null) {
            throw new IllegalArgumentException("Item deve ser informado");
         }
         itens.remove(removerItem);
    }
    
    public  ArrayList<Item> getItens() {
        return itens;
    }

    public TipoBuffet getTipoBuffet() {
        return tipoBuffet;
    }

    public void setTipoBuffet(TipoBuffet tipoBuffet) throws IllegalArgumentException {
        if (tipoBuffet == null) {
            throw new IllegalArgumentException("O tipo do buffet deve ser informado");
        }
        this.tipoBuffet = tipoBuffet;
    }
    
}
