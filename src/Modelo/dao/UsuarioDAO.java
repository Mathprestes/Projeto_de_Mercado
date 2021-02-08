/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Conexao.ConexaoFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matheus
 */
public class UsuarioDAO {
    
    public boolean checkLogin(String email, String senha) {     //recebendo dois parametros
        
        Connection con = ConexaoFactory.getConnection();        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean check = false;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE email = ? and senha = ?");   
            stmt.setString (1, email);
            stmt.setString (2, senha);
            
            rs = stmt.executeQuery();                                 
            
            if (rs.next()) {           
                check = true; 
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        finally {
            ConexaoFactory.closeConnection (con, stmt, rs);
        }
        
        return check;
    }
    
    //public boolean nome_usuario (Usuario usuario) throws SQLException {
    //    
    //    String sql = "SELECT * FROM usuario WHERE nome = ?";                   //criando uma string sql
    //   PreparedStatement stmt = ConexaoFactory.preparedStatement (sql);       //  criando um "stmt" com o sql 
    //    stmt.execute();                                                           //executar o cara la no banco
    //    
    //    ResultSet resultSet = stmt.getResultSet();                              //pegar os resultados que viram do banco de dados e guardando no "resultSet"
    //    
    //    return resultSet.next();
    //}
}
     
    


























