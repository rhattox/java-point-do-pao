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

import static java.lang.Integer.valueOf;

/**
 *
 * @author Rodrigo
 */
public class ProdutoDao {

    private final String jdbcURL = "jdbc:postgresql://localhost:12002/pointdopao";

    private final String jdbcUsername = "admin";
    private final String jdbcPassword = "admin";

    private static final String GET_PRODUTOS_SQL = "SELECT * FROM produto";
    private static final String INSERT_PRODUTO_SQL = "INSERT INTO produto (nome, preco, quantidade) VALUES (?,?,?);";
    private static final String SELECT_IMAGEM = "SELECT IMAGEM FROM PRDOTUO WHERE ID=?";
    private static final String GET_PRODUTO_BY_ID = "SELECT id,nome,preco,quantidade FROM produto WHERE id = ?;";
    private static final String UPDATE_PRODUTO_QUANTIDADE_BY_NOME = "UPDATE produto SET quantidade = ? WHERE nome = ?";

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.getMessage();
        }
        // TODO Auto-generated catch block
        return connection;
    }

    public void insertProduto(Produto p) throws SQLException {
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUTO_SQL)) {
            preparedStatement.setString(1, p.getNome());
            preparedStatement.setBigDecimal(2, p.getPreco());
            preparedStatement.setInt(3, p.getQuantidade());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Produto getProductById(String id) {
        // try-with-resource statement will auto close the connection.
        Produto produto = new Produto();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUTO_BY_ID)) {
            ResultSet rs;

            preparedStatement.setInt(1, Integer.parseInt(id));
            rs = preparedStatement.executeQuery();

            while (rs.next()) {

                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getBigDecimal("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));
                System.out.println(produto.getId());
            }
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.getMessage();
        }
        return produto;
    }

    public List<Produto> getAllProducts() {
        // try-with-resource statement will auto close the connection.
        List<Produto> listaProduto = new ArrayList<Produto>();
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUTOS_SQL)) {
            ResultSet rs;
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getBigDecimal("preco"));
                produto.setQuantidade(rs.getInt("quantidade"));

                listaProduto.add(produto);
            }
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            e.getMessage();
        }
        return listaProduto;
    }
}
