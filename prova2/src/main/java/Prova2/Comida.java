package prova2;

import java.util.ArrayList;

/**
 *
 * @author gusta
 */
public class Comida extends Item {

    public Comida(String nome, float valor, String tipoItem) {
        super(nome, valor, tipoItem);
    }

    @Override
    public String imprimirItem() {
        return (String) (nome + "R$ " + valor);
    }
}
