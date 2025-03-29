package furb.exemplointerface;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class Principal {

    public Principal() {
        try{
        ArrayList<FormaGeometrica> formas = new ArrayList<FormaGeometrica>();
        formas.add(new Circulo(5));
        formas.add(new Retangulo(4,8));
        formas.add(new Quadrado(6));
        
        String dados = "";
        
        for (FormaGeometrica forma: formas) {
            dados += forma.getClass().getSimpleName() + "\n";
            dados += forma.area()+ " - " + forma.perimetro();
        }
        
            JOptionPane.showMessageDialog(null, dados);
        
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    public static void main(String[] args) {
        new Principal();
    }
 
}
