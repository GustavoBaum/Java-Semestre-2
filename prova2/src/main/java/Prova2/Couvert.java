package prova2;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Couvert extends Item {

    public Couvert(String nome, float valor, String tipoItem) {
        super(nome, valor, tipoItem);
    }
    
    @Override
    public String imprimirItem() {
        return (String) ("O valor do couvert de hoje é R$" + valor) + ". Divirta-se";
    }
    
}
