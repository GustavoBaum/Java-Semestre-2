package Lista11;

import java.util.ArrayList;

/**
 *
 * @author gusta
 */
public class Conta {
    
    private ArrayList<Pagavel> contas;
       
    public void incluirConta(Pagavel conta) throws IllegalArgumentException {
        if (conta == null) {
            throw new IllegalArgumentException("Conta deve ser informado");
        }
        contas.add(conta);
    }
    
    public ArrayList<Pagavel> getContas() {
        return contas;
    }
    
    public double calcularTotalContas() throws IllegalArgumentException {
        if (contas == null) {
            throw new IllegalArgumentException("Contas devem ser informadas");
        }
        
        int totalContas = 0;
        for (Conta conta  : contas) {
             totalContas++;
            }
        return totalContas;
        }
    }
