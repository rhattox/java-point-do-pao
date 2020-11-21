/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Carrinho;
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
public class CarrinhoDao {

    public class UsuarioDao {

        private String jdbcURL = "jdbc:postgresql://localhost:12002/pointdopao";

        private String jdbcUsername = "admin";
        private String jdbcPassword = "admin";

        private static final String INSERT_CARRINHO_SQL = "INSERT INTO carrinho (id_produto, quantidade) VALUES (?,?);";

        private static final String SELECT_CARRINHO_BY_PRODUTO = "SELECT id FROM carrinho WHERE id_produto = ?";

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

        public void insertProduto(Produto id, Produto quantidade) throws SQLException {

            // try-with-resource statement will auto close the connection.
            try (Connection connection = getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CARRINHO_SQL)) {
                preparedStatement.setInt(1, id.getId());
                preparedStatement.setInt(2, quantidade.getQuantidade());

                preparedStatement.executeUpdate();
                System.out.println("\nCARRINHODAO:\n" + preparedStatement);
            } catch (Exception e) {
                e.getMessage();
            }
        }

        public Boolean searchCarrinho(int id, int id_produto) {

            boolean autenticado = false;

            try (Connection connection = getConnection();
                    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CARRINHO_BY_PRODUTO)) {

                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, id_produto);

                ResultSet rs;
                rs = preparedStatement.executeQuery();

                if (rs.next()) {
                    String loginBanco = rs.getString("id");
                    String senhaBanco = rs.getString("id_produto");
                    autenticado = true;
                }
                preparedStatement.executeUpdate();
                System.out.println("\nCarrinhoDAO:\n" + preparedStatement);
            } catch (Exception e) {
                e.getMessage();
            }
            return autenticado;
        }

    }
}
