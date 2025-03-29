package prova2;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public abstract class Item {
    
    protected String nome;
    protected float valor;
    protected String tipoItem;
    
    public Item(String nome, float valor, String tipoItem) {
        setNome(nome);
        setValor(valor);
        setTipoItem(tipoItem);
    }
    
    public String getTipoItem() {
        return tipoItem;
    }
    
    public void setTipoItem(String tipoItem) throws IllegalArgumentException {
        if (tipoItem == null) {
            throw new IllegalArgumentException("Tipo do item deve ser informado");
        }
        this.tipoItem = tipoItem;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome.isBlank()) {
            throw new IllegalArgumentException("O nome deve ser informado");
        }
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) throws IllegalArgumentException {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero");
        }
        this.valor = valor;
    }
    
    public abstract String imprimirItem();
}
