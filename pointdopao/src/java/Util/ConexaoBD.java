package util;
import java.sql.*;
import java.util.Properties;

public class ConexaoBD {
  
    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                
                String user = "admin";
                String password = "admin";
                //Class.forName("com.mysql.jdbc.Driver"); // Para quem for usar MySql
                Class.forName("org.postgresql.Driver");// Para quem for usar Postgres
                //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoIntegrador", user, password);// Para quem for usar MySql
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/pointdopao",user, password);// Para quem for usar Postgres
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println(e.getMessage());
            }
            return connection;
        }
    }
}