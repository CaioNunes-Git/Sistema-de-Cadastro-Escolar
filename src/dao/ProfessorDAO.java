package dao;

import domain.Disciplina;
import domain.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {

    private static List<Professor> professores = new ArrayList<>();

    public static void adicionar(Professor professor){
        professores.add(professor);
    }
    public static List<Professor> list(){
        return professores;
    }
}
