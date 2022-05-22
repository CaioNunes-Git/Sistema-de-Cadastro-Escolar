package tui;
import business.DisciplinaBO;
import dao.DisciplinaDAO;
import domain.Disciplina;
import domain.Professor;

import java.util.List;
import java.util.Scanner;

public class DisciplinaTUI {
    public static void incluirDisciplina() { //aqui
        Scanner sc = new Scanner(System.in);
        System.out.println("Quantas disciplinas deseja cadastrar?") ;
        int qtd = sc.nextInt();
        sc.nextLine();

        for(int i = 0 ; qtd > i ; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("***** CADASTRAR DISCIPLINA NÚMERO " + (i + 1) + " *****");
            System.out.println("Digite o nome da disciplina: ");
            String nome = scanner.nextLine();
            System.out.println("Digite o código da disciplina: ");
            String codigo = scanner.nextLine();
            System.out.println("Digite a carga horaria da disciplina: ");
            String cargaHoraria = scanner.nextLine();
            Disciplina disciplina = new Disciplina(nome, codigo, cargaHoraria);
            DisciplinaBO.cadastrar(disciplina);
        }
        ListarDisciplina();
    }

    //Não precisa listar disciplinas
    public static void ListarDisciplina() {
        System.out.println("****** LISTAGEM DISCIPLINAS ******");
            for (Disciplina disciplina : DisciplinaDAO.list()){
                System.out.println("Codigo da Disciplina: " + disciplina.getCodigo());
                System.out.println("Nome da Disciplina: " + disciplina.getNome());
                System.out.println("Carga Horária: " + disciplina.getCargaHoraria());
            }
    }
}
