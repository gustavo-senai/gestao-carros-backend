import view.TarefaView;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {

        // Inicialização de objetos e variáveis
        TarefaView tarefaView = new TarefaView();
        int opcao;

        // Estrutura de funcionalidades
        do {
            // Tela inicial
            opcao = tarefaView.telaInicial();

            switch (opcao) {
                // Cadastro
                case 0:
                    tarefaView.telaCadastro();
                    break;

                // Listagem
                case 1:
                    tarefaView.telaListagem();
                    break;

                // Alteração
                case 2:
                    tarefaView.telaAlteracao();
                    break;

                // Exclusão
                case 3:
                    tarefaView.telaExclusao();
                    break;

            }

        } while(opcao >= 0);

    }
}
