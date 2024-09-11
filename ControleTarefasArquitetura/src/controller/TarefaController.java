package controller;

import dao.TarefaDAO;
import model.Tarefa;

import javax.swing.*;
import java.util.ArrayList;

public class TarefaController {

    public Boolean cadastrar(String titulo) {
        Tarefa tarefa = new Tarefa(null, titulo);
        TarefaDAO tarefaDAO = new TarefaDAO();
        Boolean resposta = tarefaDAO.inserir(tarefa);
        return resposta;
    }

    public String listar() {
        TarefaDAO tarefaDAO = new TarefaDAO();
        ArrayList<Tarefa> lista = tarefaDAO.selecionar();

        String conteudo = "";
        for (Tarefa tarefa : lista) {
            conteudo += tarefa + "\n";
        }

        return conteudo;
    }

    public String[] listarOpcoes() {
        TarefaDAO tarefaDAO = new TarefaDAO();
        ArrayList<Tarefa> lista = tarefaDAO.selecionar();

        String[] opcoes = new String[lista.size()];
        for (int i = 0; i < opcoes.length; i++) {
            opcoes[i] = lista.get(i).getId() + " - " + lista.get(i).getTitulo();
        }

        return opcoes;
    }

    public Boolean excluir(Integer id) {
        TarefaDAO tarefaDAO = new TarefaDAO();
        Boolean resposta = tarefaDAO.deletar(id);
        return resposta;
    }

    public Tarefa buscarPorId(Integer id) {
        TarefaDAO tarefaDAO = new TarefaDAO();
        Tarefa tarefa = tarefaDAO.selecionarPorId(id);
        return tarefa;
    }

    public Boolean alterar(Integer id, String titulo) {
        Tarefa tarefa = new Tarefa(id, titulo);
        TarefaDAO tarefaDAO = new TarefaDAO();
        Boolean resposta = tarefaDAO.atualizar(tarefa);
        return resposta;
    }
}
