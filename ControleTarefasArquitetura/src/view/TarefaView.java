package view;

import controller.TarefaController;
import dao.TarefaDAO;
import model.Tarefa;

import javax.swing.*;

public class TarefaView {

    public int telaInicial() {
        String[] menu = {"Cadastro", "Listagem", "Alteração", "Exclusão"};

        int opcao = JOptionPane.showOptionDialog(
                null,
                "Menu de tarefas:",
                "GESTÃO DE TAREFAS",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                menu,
                menu[0]
        );

        return opcao;
    }

    public void telaCadastro() {
        String titulo = (String) JOptionPane.showInputDialog(
                null,
                "Título:",
                "CADASTRO DE TAREFA",
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null
        );

        if(titulo != null) {
            TarefaController tarefaController = new TarefaController();
            Boolean cadastradoEfetuado = tarefaController.cadastrar(titulo);

            if (cadastradoEfetuado) {
                JOptionPane.showMessageDialog(
                        null,
                        "Tarefa cadastrada com sucesso!",
                        "CADASTRO DE TAREFA",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }

    public void telaListagem() {
        TarefaController tarefaController = new TarefaController();
        String conteudo = tarefaController.listar();

        JOptionPane.showMessageDialog(
                null,
                conteudo,
                "LISTAGEM DE TAREFAS",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    public void telaAlteracao() {
        TarefaController tarefaController = new TarefaController();
        String[] opcoes = tarefaController.listarOpcoes();

        // Escolha tarefa para alteração
        String opcao = (String) JOptionPane.showInputDialog(
                null,
                "Escolha uma tarefa:",
                "ALTERAÇÃO DE TAREFA",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                null
        );

        if(opcao != null) {
            // Busca tarefa por id
            Integer idEscolhido = Integer.parseInt(opcao.split(" - ")[0]);
            Tarefa tarefa = tarefaController.buscarPorId(idEscolhido);

            // Alteração dos dados
            String novoTitulo = (String) JOptionPane.showInputDialog(
                    null,
                    "Título:",
                    "ALTERAÇÃO DE TAREFA",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    tarefa.getTitulo()
            );

            // Salva as alterações
            Boolean alteracaoEfetuada = tarefaController.alterar(idEscolhido, novoTitulo);
            if(alteracaoEfetuada) {
                JOptionPane.showMessageDialog(
                        null,
                        "Tarefa alterada com sucesso!",
                        "ALTERAÇÃO DE TAREFA",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        }
    }

    public void telaExclusao() {
        TarefaController tarefaController = new TarefaController();
        String[] opcoes = tarefaController.listarOpcoes();

        // Escolha tarefa para exclusão
        String opcao = (String) JOptionPane.showInputDialog(
                null,
                "Escolha uma tarefa:",
                "EXCLUSÃO DE TAREFA",
                JOptionPane.QUESTION_MESSAGE,
                null,
                opcoes,
                null
        );

        if (opcao != null) {
            int confirmacao = JOptionPane.showConfirmDialog(
                    null,
                    "Você tem certeza que deseja excluir?",
                    "EXCLUSÃO DE TAREFA",
                    JOptionPane.YES_NO_OPTION
            );

            // Deleta a tarefa pelo id
            if(confirmacao == JOptionPane.YES_OPTION) {
                Integer idEscolhido = Integer.parseInt(opcao.split(" - ")[0]);
                Boolean exclusaoEfetuada = tarefaController.excluir(idEscolhido);
                if (exclusaoEfetuada) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Tarefa excluída com sucesso!",
                            "EXCLUSÃO DE TAREFA",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        }
    }
}
