package domain;

import java.util.ArrayList;
import java.util.List;

public class Professor {
    private String matricula;
    private String nome;
    private List<String> telefones = new ArrayList<>();
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Professor() {
    }

    public Professor(String matricula, String nome, List<String> telefones) {
        this.matricula = matricula;
        this.nome = nome;
        this.telefones.addAll(telefones);
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<String> getTelefones() {
        return telefones;
    }
    public void setTelefones(String telefone) {
        telefones.add(telefone);
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }
}
