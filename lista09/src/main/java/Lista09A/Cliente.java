package Lista09A;

/**
 *
 * @author gusta
 */
public class Cliente {
    private String nome;
    private String endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null) {
            throw new IllegalArgumentException("Nome deve ser informado");
        }
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco == null) {
            throw new IllegalArgumentException("Endereco deve ser informado");
        }
        this.endereco = endereco;
    }
}
