package business;

import dao.DisciplinaDAO;
import domain.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class DisciplinaBO {

    public static void cadastrar(Disciplina disciplina){
        validarDisciplina(disciplina);
        DisciplinaDAO.adicionar(disciplina);
    }

    private static void validarDisciplina(Disciplina disciplina) {

        if (disciplina.getNome() == null || disciplina.getNome().isBlank()) {
            throw new RuntimeException("Nome da disciplina não informado.");
        }
        if (disciplina.getCargaHoraria() == null || disciplina.getCargaHoraria().isBlank()) {
            throw new RuntimeException("Carga Horária não informada.");
        }

        //TODO Efetuar verificação do id
//        for (Disciplina d : discCorrentes) {
//            if (d.getCodigo().equals(disciplina.getCodigo())){
//                throw new RuntimeException("Código da disciplina já existente");
//            }
//        }
    }
}
