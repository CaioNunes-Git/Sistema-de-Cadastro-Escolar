package tui;

import business.ProfessorBO;
import dao.DisciplinaDAO;
import dao.ProfessorDAO;
import domain.Disciplina;
import domain.Professor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProfessorTUI {
	public static void incluirProfessor() {
		Scanner sc = new Scanner(System.in);
		List<String> telefones = new ArrayList<>();
		System.out.println("***** CADASTRAR PROFESSOR *****");

		System.out.println("Digite o número de matrícula");
		String matricula = sc.nextLine();

		System.out.println("Digite o nome do professor");
		String nome = sc.nextLine();

		System.out.println("Quantos telefones deseja digitar?");
		int qtd = sc.nextInt();
		sc.nextLine();
		for (int i = 0; qtd > i; i++) {
			System.out.println("Digite o " + (i + 1) + "º número: ");
			telefones.add(sc.nextLine());
		}
		Professor professor = new Professor(matricula, nome, telefones);
		ProfessorBO.cadastrar(professor);
	}

	// Não precisa listar professor
	public static void ListarProfessor() {
		System.out.println("****** LISTAGEM PROFESSORES ******");
		for (Professor professor : ProfessorDAO.list()) {
			System.out.println("\nMatrícula: " + professor.getMatricula());
			System.out.println("\nNome: " + professor.getNome());
			for (String telefone : professor.getTelefones()) {
				System.out.println("\nTelefones: " + telefone);
			}
			DisciplinaTUI.ListarDisciplina();
		}
	}

	public static void ListarProfessorDisciplina() { // aqui
		System.out.println("##############################################################");
		List<Professor> professorList = ProfessorDAO.list();

		for (Professor p : professorList) {
			System.out.println("Professor: " + p.getNome());
			System.out.println("Matricula: " + p.getMatricula());

			for (String telefone : p.getTelefones()) {
				System.out.println("Telefone: " + telefone);
			}


			for (Disciplina disciplina : p.getDisciplinas()) {
				System.out.println("\t" + "Codigo: " + disciplina.getCodigo());
				System.out.println("\t" + "Nome da diciplina: " + disciplina.getNome());
				System.out.println("\t" + "Carga hor�ria: " + disciplina.getCargaHoraria() + "h");
			}
			System.out.println("__________________________________________________________________");
		}
		System.out.println("##############################################################");
	}

	public static void vincularProfessorDisciplina() {
		Scanner sc = new Scanner(System.in);

		DisciplinaTUI.ListarDisciplina();
		System.out.println("Quantas disciplinas você deseja auto atribuir? ");
		int qtd = sc.nextInt();
		sc.nextLine();

		List<Disciplina> disciplinas = DisciplinaDAO.list();
		List<Professor> professores = ProfessorDAO.list();

		for (int i = 0; qtd > i; i++) {
			System.out.println("Digite o seu n�mero de matr�cula: ");
			String numMatricula = sc.nextLine();
			System.out.println("Digite o código da disciplina: ");
			String codigoDisciplina = sc.nextLine();

			for (Disciplina disciplina : disciplinas) {
				for (Professor professor : professores) {
					if (disciplina.getCodigo().equals(codigoDisciplina)
							&& professor.getMatricula().equals(numMatricula)) {
						professor.setDisciplinas(disciplina);
					}
				}
			}
		}
		ListarProfessorDisciplina();
	}
}
