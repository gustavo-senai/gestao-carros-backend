package dao;

import dao.connection.ConexaoMySQL;
import model.Tarefa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TarefaDAO {
    public Boolean inserir(Tarefa tarefa) {
        try {
            String sql = "INSERT INTO tarefa (titulo) VALUES (?)";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setString(1, tarefa.getTitulo());
            int contLinhasAfetadas = preparacao.executeUpdate();
            return contLinhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Tarefa> selecionar() {
        try {
            String sql = "SELECT * FROM tarefa ORDER BY id";
            Statement stmt = ConexaoMySQL.get().createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            ArrayList<Tarefa> lista = new ArrayList<>();
            while(resultado.next()) {
                Tarefa tarefa = new Tarefa(resultado.getInt("id"), resultado.getString("titulo"));
                lista.add(tarefa);
            }
            return lista;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Tarefa selecionarPorId(Integer id) {
        try {
            String sql = "SELECT * FROM tarefa WHERE id = ?";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setInt(1, id);
            ResultSet resultado = preparacao.executeQuery();

            if(resultado.next()) {
                Tarefa tarefa = new Tarefa(resultado.getInt("id"), resultado.getString("titulo"));
                return tarefa;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean deletar(Integer id) {
        try {
            String sql = "DELETE FROM tarefa WHERE id = ?";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setInt(1, id);
            int contLinhasAfetadas = preparacao.executeUpdate();
            return contLinhasAfetadas > 0;
        } catch(SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean atualizar(Tarefa tarefa) {
        try {
            String sql = "UPDATE tarefa SET titulo = ? WHERE id = ?";
            PreparedStatement preparacao = ConexaoMySQL.get().prepareStatement(sql);
            preparacao.setString(1, tarefa.getTitulo());
            preparacao.setInt(2, tarefa.getId());
            int contLinhasAfetadas = preparacao.executeUpdate();
            return contLinhasAfetadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
