package Questao1;

import javax.swing.JOptionPane;

public class AppQuestao2UI {
    public static void main(String[] args) {
        try {
            Retangulo retangulo = new Retangulo();
            int altura = Integer.parseInt(JOptionPane.showInputDialog("Valor para altura: "));
            int comprimento = Integer.parseInt(JOptionPane.showInputDialog("Valor para comprimento: "));

            retangulo.setAltura(altura);
            retangulo.setComprimento(comprimento);

            int perimetro = retangulo.calcularPerimetro(altura, comprimento);
            int area = retangulo.calcularArea(altura, comprimento);

            JOptionPane.showMessageDialog(null, "Altura: " + altura + ". \nComprimento: " + comprimento + ". \nPerimetro: " + perimetro + ". \nArea: " + area);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
    }
}
    
    