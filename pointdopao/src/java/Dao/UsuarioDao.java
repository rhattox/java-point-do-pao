/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bcovies
 */
public class UsuarioDao {

    private String jdbcURL = "jdbc:postgresql://localhost:12002/pointdopao";

    private String jdbcUsername = "admin";
    private String jdbcPassword = "admin";

    private static final String INSERT_USERS_SQL = "INSERT INTO usuario (tipo, nome, sobrenome, email, senha) VALUES (?,?,?,?,?);";
//    private static final String SELECT_USER_BY_ID = "select id, tipo, name, sobrenome, email, senha from usuario where id =?";
//    private static final String SELECT_ALL_USERS = "select * from usuario";
//    private static final String DELETE_USERS_SQL = "delete from usuario where id = ?;";
//    private static final String UPDATE_USERS_SQL = "update usuario set nome = ?,sobrenome= ?, email =? where id = ?;";
    protected Connection getConnection() {
        Connection connection = null;
        System.out.println(INSERT_USERS_SQL);
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

//    
    public void insertUser(Usuario user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setInt(1, user.getTipo());
            preparedStatement.setString(2, user.getNome());
            preparedStatement.setString(3, user.getSobrenome());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getSenha());

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
