/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.ConexaoBD;

/**
 *
 * @author bcovies
 */
public class UsuarioDao {
    
    private Connection connection;
    
    public UsuarioDao(){
        connection = ConexaoBD.getConnection();
    }
    
    public void AdicionarUsuario(Usuario usuario){
        
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Usuario(tipo,nome,sobrenome,email,senha)");
        }
        catch(Exception e){
            System.out.println("Erro na função Adicionar Usuario!"+ "\n" + e.getMessage());
        }
    }
}
