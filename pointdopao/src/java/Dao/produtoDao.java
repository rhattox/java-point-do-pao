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

    private final String jdbcURL = "jdbc:postgresql://localhost:12002/pointdopao";

    private final String jdbcUsername = "admin";
    private final String jdbcPassword = "admin";

    private static final String INSERT_PRODUTO_SQL = "INSERT INTO produto (nome, preco, descricao, quantidade) VALUES (?,?,?,?,?);";
    private static final String GET_PRODUTOS_SQL = "SELECT * FROM produto";
    private static final String SELECT_PRODUTO_BY_NOME = "SELECT nome FROM produto WHERE nome = ?";

    private static final String UPDATE_PRODUTO_PASS_BY_NOME = "UPDATE produto SET quantidade = ? WHERE nome = ?";

    protected Connection getConnection() {
        Connection connection = null;
        System.out.println(INSERT_PRODUTO_SQL);
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block

        }
        // TODO Auto-generated catch block
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

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public Boolean searchUser(String nome) {
        System.out.println(SELECT_PRODUTO_BY_NOME);
        boolean autenticado = false;

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUTO_BY_NOME)) {

            preparedStatement.setString(1, nome);

            ResultSet rs;
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String nomeBanco = rs.getString("nome");

                autenticado = true;
                System.out.println("RETORNO BOOL: " + nomeBanco);
            }

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getMessage();
        }
        return autenticado;
    }

    public boolean changeUserPass(int quantidade, String nome) {

        boolean autenticado = false;

        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUTO_PASS_BY_NOME)) {
            preparedStatement.setString(1, nome);

            ResultSet rs;
            rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String nomeBanco = rs.getString("nome");
                int row = rs.getRow();

                if (row == 1) {
                    try (PreparedStatement preparePostCheck = connection.prepareStatement(UPDATE_PRODUTO_PASS_BY_NOME)) {

                        preparePostCheck.setString(2, nome);
                        preparePostCheck.setInt(1, quantidade);
                        System.out.println(preparePostCheck);
                        preparePostCheck.executeUpdate();
                        autenticado = true;
                    }

                } else {
                    autenticado = false;
                    System.out.println("NOME NÃO ENCONTRADO!!");
                }

            }

        } catch (Exception e) {

            e.getMessage();
        }
        return autenticado;
    }

    public List<Produto> getAllProducts() {
        System.out.println(GET_PRODUTOS_SQL);
        // try-with-resource statement will auto close the connection.
        List<Produto> listaProduto = new ArrayList<Produto>();
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUTOS_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("name"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPreco(rs.getFloat("preco"));
                listaProduto.add(produto);
            }
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
            
        } catch (Exception e) {
            e.getMessage();
        }
        return listaProduto;
    }
}
