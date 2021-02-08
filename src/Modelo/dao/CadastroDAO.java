/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Conexao.ConexaoFactory;
import Modelo.bean.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Matheus
 */
public class CadastroDAO {
    
    public void create(Usuario p) {      //CRUD=CREATE,UPDATE E DELETE
         
        Connection con = ConexaoFactory.getConnection();        //abrindo a conexao
        PreparedStatement stmt = null;                            //preparando e executando
        
        try {
            stmt = con.prepareStatement("INSERT INTO usuario (nome,telefone,email,senha) VALUES(?,?,?,?)");

            stmt.setString   (1, p.getNome      () );
            stmt.setString   (2, p.getTelefone  () );
            stmt.setString   (3, p.getEmail     () );
            stmt.setString   (4, p.getSenha     () );
            
            stmt.executeUpdate();                             //executando a sql
            
            JOptionPane.showMessageDialog (null, "Salvo com Sucesso!");     //exibindo mensagem se deu certo a inserçao
            
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog (null, "Erro ao salvar!" +ex);
                } 
        
        finally {
            ConexaoFactory.closeConnection (con, stmt);
        }
    }
}
