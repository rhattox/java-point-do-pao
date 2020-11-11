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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class ProdutoDao {

    private String jdbcURL = "jdbc:postgresql://localhost:12002/pointdopao";

    private String jdbcUsername = "admin";
    private String jdbcPassword = "admin";

    private static final String INSERT_PRODUTO_SQL = "INSERT INTO produto (nome, preco, descricao, quantidade) VALUES (?,?,?,?,?);";
    private static final String SELECT_PRODUTO_BY_NOME = "SELECT nome FROM produto WHERE nome = ?";
    private static final String UPDATE_PRODUTO_QUANTIDADE_BY_NOME = "UPDATE produto SET quantidade = ? WHERE nome = ?";

    protected Connection getConnection() {
        Connection connection = null;
        System.out.println(INSERT_PRODUTO_SQL);
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

    public void insertProduto(Produto p) throws SQLException {
        System.out.println(INSERT_PRODUTO_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUTO_SQL)) {
            preparedStatement.setString(1, p.getNome());
            preparedStatement.setFloat(2, p.getPreco());
            preparedStatement.setString(3, p.getDescricao());
            preparedStatement.setInt(4, p.getQuantidade());

            System.out.println("\nINSERTPRODUTO: " + preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

   
}
