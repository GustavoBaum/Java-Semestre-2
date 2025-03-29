package Questao2;
public class Pessoa {
    
        String nome;
        double altura;
        double peso;

        double calcularImc() {
            return  peso / (altura*altura);
        }
    }

 
