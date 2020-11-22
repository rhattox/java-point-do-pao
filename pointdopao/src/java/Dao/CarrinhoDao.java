/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rodrigo
 */
public class CarrinhoDao {

    private String jdbcURL = "jdbc:postgresql://localhost:12002/pointdopao";

    private String jdbcUsername = "admin";
    private String jdbcPassword = "admin";

    private static final String INSERT_CARRINHO_SQL = "INSERT INTO carrinho (id_produto, quantidade) VALUES (?,?);";

    protected Connection getConnection() {

        Connection connection = null;

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
        System.out.println("\nCARRINHODAO:\nIniciada a conexão com o banco de dados:\t" + connection);
        return connection;
    }

    public void insertProduto(int idProduto, int quantidadeProduto) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CARRINHO_SQL)) {
            preparedStatement.setInt(1, idProduto);
            preparedStatement.setInt(2, quantidadeProduto);
            preparedStatement.executeUpdate();
            System.out.println("\nCARRINHODAO:\n" + preparedStatement);
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
