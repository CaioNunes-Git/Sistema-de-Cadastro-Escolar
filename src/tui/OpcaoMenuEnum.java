package tui;

public enum OpcaoMenuEnum {
    INCLUSAO_DISCIPLINA(1, "Incluir disciplina"),
    INCLUSAO_PROFESSORES(2, "Incluir professores"),
    LISTAGEM_PROFESSOR_DISCIPLINA(3, "Listar professores e suas respectivas disciplinas"),
    SAIR(4, "SAIR");

    private Integer codigo;
    private String descricao;

    OpcaoMenuEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return codigo + "-" + descricao;
    }

    public static OpcaoMenuEnum valueOfInt(Integer codigo) {
        for (OpcaoMenuEnum opcaoMenu : values()) {
            if (opcaoMenu.codigo.equals(codigo)) {
                return opcaoMenu;
            }
        }
        throw new RuntimeException("Não existe a opção número: " + codigo + " no MENU");
    }
}