/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Produto;
import Models.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Rodrigo
 */
public class CompraDao {

    private String jdbcURL = "jdbc:postgresql://localhost:12002/pointdopao";

    private String jdbcUsername = "admin";
    private String jdbcPassword = "admin";

    private static final String INSERT_COMPRA_SQL = "INSERT INTO compra (id_usuario,valor_total) VALUES (?,?);";
    
    private static final String INSERT_COMPRA_DETALHE_SQL = "INSERT INTO detalhe_compra (id_compra,id_produto,quantidade_produto) VALUES (?, ?, ?);";

    

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

    public void insertCompra(int idUsuario, float valorTotal) throws SQLException {

        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COMPRA_SQL)) {

            preparedStatement.executeUpdate();
          
        } catch (Exception e) {
            e.getMessage();
        }
    }

}
