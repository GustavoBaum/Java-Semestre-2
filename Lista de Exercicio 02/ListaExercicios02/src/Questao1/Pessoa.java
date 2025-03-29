package Questao1;
public class Pessoa {
    private double altura;
    private double peso;
    private String nome;
    
    public double calcularImc() {
        return peso / (altura * altura);
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        if (nome == null || nome.trim().equals("")){
            throw new IllegalArgumentException("Nome deve ser preenchido");
        }
        this.nome = nome;
    }
    public double getAltura(){
        return altura;
    }
    
    public double getPeso() {
        return peso;
    }
    
    public void setAltura(double altura){
        if (altura <= 0) {
            throw new IllegalArgumentException("Altura"
                    + " deve ser maior que zero");
        }
            
        this.altura = altura;
    }
    
    public void setPeso(double peso) {
        if (peso <= 0) {
            throw new IllegalArgumentException("Peso deve ser "
                    + "maior que zero");
        }
        this.peso = peso;
    }
}