package business;

import dao.ProfessorDAO;
import domain.Professor;

import java.util.ArrayList;
import java.util.List;

public class ProfessorBO {

    public static void cadastrar(Professor professor){
        validarProfessor(professor);
        ProfessorDAO.adicionar(professor);
    }

   private static void validarProfessor(Professor professor) {

       if (professor.getNome() == null || professor.getNome().isBlank()) {
           throw new RuntimeException("Nome do professor não informado.");
       }

       if (professor.getTelefones() == null || professor.getTelefones().isEmpty()) {
           throw new RuntimeException("Telefone no informado.");
       }
        //TODO Efetuar verificação do id
//       for (Professor p : profCorrentes) {
//           if (p.getMatricula().equals(professor.getMatricula())){
//               throw new RuntimeException("Número de matrícula já existente");
//           }
//       }
   }
}
