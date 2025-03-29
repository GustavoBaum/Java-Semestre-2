package Lista09B;

/**
 *
 * @author gusta
 */
public class Cliente {
    private String nome;
    private String endereco;

    public Cliente(String nome, String endereco) {
        setNome(nome);
        setEndereco(endereco);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if (nome == null) {
            throw new IllegalArgumentException("Nome deve ser informado");
        }
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws IllegalArgumentException {
        if (endereco == null) {
            throw new IllegalArgumentException("Endereco deve ser informado");
        }
        this.endereco = endereco;
    }
}
