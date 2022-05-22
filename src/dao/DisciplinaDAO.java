package dao;

import domain.Disciplina;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {
    private static List<Disciplina> disciplinas = new ArrayList<>();

    public static void adicionar(Disciplina disciplina){
        disciplinas.add(disciplina);
    }

    public static List<Disciplina> list(){
        return disciplinas;
    }

}
