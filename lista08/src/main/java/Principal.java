
import javax.swing.JOptionPane;

/**
 *
 * @author gusta
 */
public class Principal {
    public static void main(String[] args) {
        new Principal();
    }
    
    public Principal() {
        Professor p = new Professor("Luciana", "lpa@furb.br", Titulacao.MESTRADO);
        Turma turma = new Turma("POO", Turno.MATUTINO, new Professor("Luciana", "lpa@furb.br", Titulacao.MESTRADO));
        
        turma.incluirAluno(new Aluno(123, "Ana"));
        turma.incluirAluno(new Aluno(222, "Henrique", 800));
        turma.incluirAluno(new Aluno(555, "Eric", 700));
        turma.incluirAluno(new Aluno(444, "Julia", 900));
        
        JOptionPane.showMessageDialog(null, turma.listarAlunos());
        JOptionPane.showMessageDialog(null, turma.obterAlunoMelhorNotaEnem().getNome());
        
        turma.excluirAluno(444, "Julia");
        JOptionPane.showMessageDialog(null, turma.listarAlunos());
        JOptionPane.showMessageDialog(null, turma.obterAlunoMelhorNotaEnem().getNome());
    }
}