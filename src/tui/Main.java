package tui;
import domain.Disciplina;
import domain.Professor;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Digite a opção desejada: ");
            System.out.println(OpcaoMenuEnum.INCLUSAO_DISCIPLINA.getDescricao());
            System.out.println(OpcaoMenuEnum.INCLUSAO_PROFESSORES.getDescricao());
            System.out.println(OpcaoMenuEnum.LISTAGEM_PROFESSOR_DISCIPLINA.getDescricao());
            System.out.println(OpcaoMenuEnum.SAIR.getDescricao());

            int opcao = Integer.parseInt(scanner.nextLine());

            switch (OpcaoMenuEnum.valueOfInt(opcao)) {

                case INCLUSAO_DISCIPLINA -> {
                    DisciplinaTUI.incluirDisciplina();
                }
                case INCLUSAO_PROFESSORES -> {
                    ProfessorTUI.incluirProfessor();
                    ProfessorTUI.vincularProfessorDisciplina();
                }
                case LISTAGEM_PROFESSOR_DISCIPLINA -> {
                    ProfessorTUI.ListarProfessorDisciplina();
                }
                case SAIR -> {
                    System.out.println("Saindo");
                    System.exit(400);
                }
                default -> {}
            }
        }
    }
}
