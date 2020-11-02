/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.ConexaoBD;

/**
 *
 * @author bcovies
 */
public class UsuarioDao {

    private Connection connection;

    public UsuarioDao() {
        connection = ConexaoBD.getConnection();
    }

    public void adicionarUsuario(Usuario usuario) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into usuario(tipo,nome,sobrenome,email) values (?, ?, ?, ?) ");
            preparedStatement.setInt(1, usuario.getTipo());
            preparedStatement.setString(2, usuario.getNome());
            preparedStatement.setString(3, usuario.getSobrenome());
            preparedStatement.setString(4, usuario.getEmail());
            //  preparedStatement.setString(5, usuario.getSenha());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro na função Adicionar Usuario!" + "\n" + e.getMessage());
        }
    }

    public void deletarUsuario(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from usuario where id=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Erro na função Deletar Usuario!" + "\n" + e.getMessage());
        }
    }

    public void atualizarUsuario(Usuario usuario) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update usuario set nome=?, sobrenome=?, email=?, senha=? where id=?");
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getSobrenome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro na atualizar usuario!" + "\n" + e.getMessage());
        }
    }

    public Usuario retornarIdUsuario(int id) {
        Usuario usuario = new Usuario();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from users where userid=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                usuario.setNome(rs.getString("nome"));
                usuario.setNome(rs.getString("sobrenome"));
                usuario.setNome(rs.getString("email"));
                usuario.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao retornar id do usuário!" + "\n" + e.getMessage());
        }

        return usuario;
    }
}
