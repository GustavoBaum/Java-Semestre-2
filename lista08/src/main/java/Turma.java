
import java.util.ArrayList;

/**
 *
 * @author gusta
 */
public class Turma {
    private String disciplina;
    private Turno turno;
    private Professor professorTurma;
    private ArrayList<Aluno> listaAlunos;

    public Turma(String disciplina, Turno turno, Professor professorTurma) {
        listaAlunos = new ArrayList<Aluno>(); 
        setDisciplina(disciplina);
        setTurno(turno);
        setProfessorTurma(professorTurma);
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        if (disciplina == null) {
            throw new IllegalArgumentException("Disciplina deve ser informada");
        }
        this.disciplina = disciplina;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public Professor getProfessorTurma() {
        return professorTurma;
    }

    public void setProfessorTurma(Professor professorTurma) {
        if (professorTurma == null) {
            throw new IllegalArgumentException("Professor deve ser informado");
        }
        this.professorTurma = professorTurma;
    }

    public ArrayList<Aluno> getListaAlunos() {
        return listaAlunos;
    }
    
    public void incluirAluno(Aluno a) {
        if (a == null) {
            throw new IllegalArgumentException("Aluno deve ser informado");
        }
        if (buscar(a.getMatricula(), a.getNome()) != null) {
            throw new IllegalArgumentException("Aluno já existe na lista");
        }
        listaAlunos.add(a);
    }
    
    private Aluno buscar(int matricula, String nome) {
        for (Aluno a : listaAlunos) {
            if (a.getMatricula() == matricula && a.getNome().equalsIgnoreCase(nome)) {
                return a;
            }
        }
        return null;
    }
    
    public void excluirAluno(int matricula, String nome) {
        Aluno aRemover = buscar(matricula, nome);
        if (aRemover == null) {
            throw new IllegalArgumentException("Aluno deve ser informado");
        }
        listaAlunos.remove(aRemover);
    }
    
    public Aluno obterAlunoMelhorNotaEnem() {
        double notaEnem = 0;
        Aluno alunoMaior = null;
        for (Aluno a : listaAlunos) {
            if (a.getNotaEnem() > notaEnem) {
                    notaEnem = a.getNotaEnem();
                    alunoMaior = a;
            }
        }
        return alunoMaior;
    }

    public String listarAlunos() {
        String dados = "";
        for (Aluno a : listaAlunos) {
            dados += a.getNome() + " " + a.getNotaEnem() + "\n";
        }
        return dados;   
    }
}
