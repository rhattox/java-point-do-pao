/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
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
}
