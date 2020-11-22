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

/**
 *
 * @author Rodrigo
 */
public class CarrinhoDao {

    private String jdbcURL = "jdbc:postgresql://localhost:12002/pointdopao";

    private String jdbcUsername = "admin";
    private String jdbcPassword = "admin";

    private static final String INSERT_DETALHE_COMPRA_SQL = "INSERT INTO detalhe_compra (id_compra,id_produto,quantidade_produto) VALUES (?,?,?);";
    private static final String INSERT_RETURN_COMPRA_SQL = "INSERT INTO compra (id_usuario, valor_total) VALUES (?,?) RETURNING id ;";

    //private static final String INSERT_CARRINHO_SQL = "INSERT INTO carrinho (id_produto, quantidade) VALUES (?,?);";
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

    public int insertProduto(int idUsuario, Double valorTotal) throws SQLException {
        // try-with-resource statement will auto close the connection.
        int id_tabela = 0;
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RETURN_COMPRA_SQL)) {
            preparedStatement.setInt(1, idUsuario);
            preparedStatement.setDouble(2, valorTotal);

            ResultSet rs;
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                rs.getInt("id");
                id_tabela = rs.getInt("id");
            }

            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.getMessage();
        }
        return id_tabela;
    }

    public void insertProdutoDetalhe(int idTabelaCompra, int idProduto, int qntProduto) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DETALHE_COMPRA_SQL)) {
            preparedStatement.setInt(1, idTabelaCompra);
            preparedStatement.setInt(2, idProduto);
            preparedStatement.setInt(3, qntProduto);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
