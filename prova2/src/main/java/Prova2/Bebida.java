package prova2;

import java.util.ArrayList;

/**
 *
 * @author gusta
 */
public class Bebida extends Item {

    public Bebida(String nome, float valor, String tipoItem) {
        super(nome, valor, tipoItem);
    }
    
    @Override
    public String imprimirItem() {
        return (String) (nome + "R$ " + valor);
    }
}
